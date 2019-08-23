package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jk.model.Car;
import com.jk.model.Cusmoter;
import com.jk.service.PersonService;
import com.jk.util.HttpClientUtil;
import com.jk.util.ParameUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * @author ： xueqitao
 * @date ：Created in 2019/8/21 0021 17:16
 * @description：客服聊天系统
 * @package ：com.jk.controller
 * @version:
 */
@Controller
@RequestMapping("/Perso")
public class PersonController {



    @Reference
    private PersonService personService;

    //跳转消费者商品列表接口
    @RequestMapping("/CusList")
    public String torobotchat(){

        return "xqt/CusList.html";
    }
    //跳转机器人服务接口
    @RequestMapping("/queryperson")
    public String jiqiren(){

        return "xqt/person.html";
    }
//测试人工客服页面
    @RequestMapping("/tosocket")
    public String tosocket(){

        return "xqt/socket.html";
    }
    //跳转人工客户服务接口
    @RequestMapping("/querypeople")
    public String querypeople(){

        return "xqt/people.html";
    }

    //跳转人工客服服务接口
    @RequestMapping("/querykefu")
    public String querykefu(){

        return "xqt/kefu.html";
    }

    //商品分页列表查询
    @RequestMapping("findCarShoppingList")
    @ResponseBody
    public HashMap<String, Object> findCarShoppingList(Integer page, Integer rows, Car car){


        return personService.findCarShoppingList(page,rows,car);
    }

    //机器人服务正式接口
    @RequestMapping("robotchat")
    @ResponseBody
    public JSONObject liaoTian(String code)throws Exception {
        String url="http://api.qingyunke.com/api.php";
        HashMap<String, Object> params = new HashMap<>();
        params.put("key","free");
        params.put("appid",0);
        params.put("msg",code);
        String returnStr = HttpClientUtil.get(url, params);
        JSONObject parseObject = JSON.parseObject(returnStr);
        return parseObject;
    }

    //将客服说的话存入数据库中
    @RequestMapping("rengong")
    @ResponseBody
    public String rengong(HttpServletRequest request,Cusmoter cusmoter){
        //获取客户说的话
        String code = request.getParameter("codeKehu");
        System.out.println("获取客户说的话-----"+code);
        //将获取客户说的话存入到数据库中
        personService.insertKehu(cusmoter);
        return null;
    }

    //正式---查询查询客户说过的话
    @RequestMapping("queryKehus2")
    @ResponseBody
    public List<Cusmoter> queryKehus2(){

        return personService.queryKehus2();
    }

    //正式---将客服说的话存入数据库中
    @RequestMapping("insertkefucode")
    @ResponseBody
    public String insertkefucode(HttpServletRequest request,Cusmoter cusmoter){
        String codeKefu = request.getParameter("codeKefu");
        System.out.println("获取客服说的话-----"+codeKefu);
        //将客服说的话新增到数据库中
        personService.insertkefu(cusmoter);
        return null;
    }

    //测试--查询查询客服说过的话
    @RequestMapping("queryKefucode")
    @ResponseBody
    public List<Cusmoter> queryKefucode(){

        return personService.queryKefucode();
    }
}
