package com.jk.controller;

import com.alibaba.dubbo.common.json.JSONObject;
import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.User;
import com.jk.service.UserService;
import com.jk.util.CheckSumBuilder;
import com.jk.util.HttpClientUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author ： 安雅茹
 * @date ：Created in 2019-08-18 15:29
 * @description：
 * @package ：com.jk.controller
 * @version:
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Reference(version = "1.0")
    private UserService userservice;
    @Resource
    private RedisTemplate redisTemplate;
@RequestMapping("login")
    public String login(){
    return "login";
}
    @RequestMapping("testCode")
    @ResponseBody
    public String testCode(String mobile, HttpSession session){
        String key="code";
        String url = "https://api.netease.im/sms/sendcode.action";
        String appKey = "cb595eefb48954cfed18d79bdee18a5d";
        String curTime = String.valueOf(Calendar.getInstance().getTimeInMillis()/1000);
        String nonce = UUID.randomUUID().toString().replace("-", "");
        String checkSum = CheckSumBuilder.getCheckSum("54e89da1c152",nonce,curTime);
        // 设置 hander 参数
        HashMap<String, Object> headers = new HashMap();
        headers.put("AppKey", appKey);
        headers.put("Nonce", nonce);
        headers.put("CurTime", curTime);
        headers.put("CheckSum", checkSum);


        HashMap<String, Object>  params = new HashMap();
        params.put("mobile", mobile);
        session.setAttribute("mobile22222",mobile);

        System.out.println(mobile);
        params.put("templateid", "14799456");

        try {
            String str = HttpClientUtil.post(url, params, headers);
       //  JSONObject jsonobject = JSONObject.parseObject(str);

           // String code=jsonobject.getString("code");
          //  if(code.equals("200")){
             //   String objcode = jsonobject.getString("obj");
                redisTemplate.opsForValue().set(key, mobile);

            System.out.println("+++++++++++++++++++++"+session.getAttribute("mobile22222").toString());
                //设置过期时间
                redisTemplate.expire(key, 60, TimeUnit.MINUTES);

                return str;
         //   }
           // System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }
/*    @RequestMapping("queryPhone")
    @ResponseBody
    public void queryPhone(HttpSession session){
      // session.setAttribute("mobile22222","18534146517");
        System.out.println("+++++++++++++++++++++"+session.getAttribute("mobile22222"));
        String phone= (String)session.getAttribute("mobile22222");
        System.out.println(phone);
        int flag=userservice.queryPhone(phone);
        if(flag==0){
            User user1=new User();
            user1.setuserphone(phone);
            userservice.addUser(user1);
            User user=userservice.queryLoginPhone(phone.toString());
            session.setAttribute("LoginUser",user);

        }else{
          User user=userservice.queryLoginPhone(phone.toString());
            session.setAttribute("LoginUser",user);
            System.out.println( session.getAttribute("LoginUser").toString()+"++++++++");
        }
    }*/
  /*  @RequestMapping("queryLoginPhone")
    public void queryLoginPhone(HttpSession session){
        Object phone = session.getAttribute("mobile22222");
          User user=userservice.queryLoginPhone(phone.toString());
            session.setAttribute("LoginUser",user);
    }*/
    @RequestMapping("queryUserPhone")
    @ResponseBody
    public void queryUserPhone(HttpSession session){
        String phone= (String)session.getAttribute("mobile22222");
        System.out.println("phone++++++++++++"+phone);
       User reuser =userservice.queryLoginPhone(phone);
       if(reuser==null){
           User user1=new User();
           user1.setUserphone(phone);
           userservice.addUser(user1);
           User user=userservice.queryLoginPhone(phone.toString());
           session.setAttribute("LoginUserid",user.getUserid());
           session.setAttribute("LoginUserphone",user.getUserphone());
       }else{
           session.setAttribute("LoginUserid",reuser.getUserid());
           Object loginUserid = session.getAttribute("LoginUserid");
           session.setAttribute("LoginUserphone",reuser.getUserphone());
       }
    }
}

