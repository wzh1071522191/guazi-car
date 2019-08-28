package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.minggan.test;
import com.jk.model.*;
import com.jk.service.CommService;
import com.jk.util.DataGridResult;
import com.jk.util.PageUtil;
import com.jk.util.ParameUtil;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import sun.net.httpserver.HttpsServerImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.io.UnsupportedEncodingException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("comm")
public class CommController {
    @Reference
    private CommService se;
  @Autowired
  private RedisTemplate redisTemplate;
    @Autowired
    private AmqpTemplate amqpTemplate;
    //订单查询全部
    @RequestMapping("cha")
    @ResponseBody
    public Map chauxn(@RequestBody ParameUtil params){


      return se.cha(params);
    }
    //跳转订单查询页面
  @RequestMapping("cha1")
    public String cha1(){

        return "cha";
  }
 //订单待付款查询
 @RequestMapping("daifukuan")
 @ResponseBody
 public Map daifukuan(@RequestBody ParameUtil param){

     return se.dai(param);
 }

 //订单待发货查询
 @RequestMapping("daifahuo")
 @ResponseBody
 public Map daifahuo(@RequestBody ParameUtil param){

     return se.fa(param);
 }
 //订单已发货查询
 @RequestMapping("yifahuo")
 @ResponseBody
 public Map yifahuo(@RequestBody ParameUtil param){

     return se.yi(param);
 }
    //订单已完成查询
    @RequestMapping("yiwancheng")
    @ResponseBody
    public Map yiwancheng(@RequestBody ParameUtil param){

        return se.wan(param);
    }
    //订单已关闭查询
    @RequestMapping("yiguanbi")
    @ResponseBody
    public Map yiguanbi(@RequestBody ParameUtil param){

        return se.guan(param);
    }
    //订单退款中查询
    @RequestMapping("tuikuanzhong")
    @ResponseBody
    public Map tuikuanzhong(@RequestBody ParameUtil param){

        return se.tui(param);
    }
    //订单详情跳转
    @RequestMapping("xiang")

    public String xiang(Integer id,HttpServletRequest request){
        request.getSession().setAttribute("s",id);
 return  "xiang" ;

    }

    //订单详情查询

    @RequestMapping("xiang1")
    @ResponseBody
    public Map xiang1(@RequestBody ParameUtil param, Integer id){

        return se.xiang1(param,id);
    }
    //交易退款查询
    @RequestMapping("kuan")
    @ResponseBody
    public Map kuan(@RequestBody ParameUtil parame){

        return se.kuan(parame);
    }
    //交易退款跳转页面
    @RequestMapping("kuan1")
    public String kuan1(){

     return "kuan";
    }
    //同意  拒绝
    @RequestMapping("tong")
    @ResponseBody
    public void tong(Integer sum,Integer id){
        se.tong(sum,id);
    }
    //评论查询
    @RequestMapping("pinglun")
    @ResponseBody
    public List<Comment> treeList(Integer id){
        List<Comment> list=se.shu(id);
        return list;
    }

    //评论查询
    @RequestMapping("ping")
    @ResponseBody

    public Map pinglun(@RequestBody ParameUtil  param){

        return se.ping(param);
    }
 @RequestMapping("ping1")
    public String ping1(){
        return "ping";
 }
    //订单新增
    @RequestMapping("dindanxin")
    @ResponseBody
    public void  dindanxin(HttpServletRequest request,Integer status,String carname,Integer yuhui,Integer price,String color,Integer cid){
        Integer loginUserid = (Integer) request.getSession().getAttribute("LoginUserid");
        long time =  System.currentTimeMillis();
        Random ran = new Random();
        int i = ran.nextInt(1000);
        long s= time+i;
        Order o=new Order();
        o.setDindanhao(s+"");
        o.setCarid(cid);
        o.setUserid(loginUserid);
        o.setPrice(price);
        o.setCunmber(1);
        o.setXdtime(new Date());
        o.setKuaidifei(0);
        if (yuhui==null) {
            o.setYuhui(0);
        }else if(yuhui==1){
            o.setYuhui(500);
        }else if(yuhui==2){
            o.setYuhui(1000);
        }else if(yuhui==3){
            o.setYuhui(5000);
        }
        o.setStatus(status);
     Integer commodity=price-yuhui;
        o.setShprice(commodity);
        o.setGuige(color);
       o.setSpprice(commodity);
        if(o.getStatus()==1){
            String cun="order";

            redisTemplate.opsForValue().set(cun,o);
            redisTemplate.expire(cun,20,TimeUnit.MINUTES);
        }else{
            amqpTemplate.convertAndSend("Rabbitmq",o);
        }


    }
//回复弹框
 @RequestMapping("huifu1")
    public String  huifu1(){

        return "huifu";
 }
 //评论弹框
 @RequestMapping("pinglun1")
    public  String pinglun1(Integer id,HttpServletRequest request){
 request.getSession().setAttribute("pinglun",id);
        return "pinglun";
 }
 //回复新增
    @RequestMapping("huifu")
    @ResponseBody
    public  void huifu(Integer id,Comment c) throws UnsupportedEncodingException {
        String text = c.getText();

        String[] arr = {"傻","傻逼","王八蛋","猪","草","王八","智障吗","逼", "你妈","sb","SB","S B","s b"};
        String content = text;

        test t = new test();

        List<String> words = new ArrayList<String>();

        for (String in : arr) {
            words.add(in);
        }
        t.createKeywordTree(words);

        String result = t.searchKeyword(content);
        c.setText(result);
        System.out.println(result);


      se.huifu(id,c);
    }
    //沙箱实现
    @RequestMapping("shaxiang")
    public String shaxiang(){
        return "aaa";
    }
//秒杀跳页面
    String key = "youhui";
    @RequestMapping("miaosha1")
       public  String miaosha1(HttpSession session,Integer uid,Integer status,HttpServletRequest request){
        Integer loginUserid = (Integer) request.getSession().getAttribute("LoginUserid");
        session.setAttribute("z",status);
        session.setAttribute("y",loginUserid);
        Integer shuliang = (Integer) request.getSession().getAttribute("shuliang");
        if (redisTemplate.hasKey(key)) {
        } else {
            redisTemplate.opsForValue().set(key, shuliang);
            redisTemplate.expire(key,30,TimeUnit.MINUTES);
        }


      return "tiao";
    }

//秒杀实现
@RequestMapping("miaosha")
@ResponseBody
public String miaosha(Integer uid,Integer status){

     if(uid==null){
         return "cuo";
     }else {
         String aa = "uid"+uid;
         if(redisTemplate.hasKey(aa)){
             return "you";
         }else{
             redisTemplate.opsForList().leftPush(aa, uid);

                if (redisTemplate.hasKey(key)) {
                     Integer o = (Integer) redisTemplate.opsForValue().get(key);
                     if (o > 0) {
                         redisTemplate.opsForValue().decrement(key);
                     } else {
                         return "wan";
                     }
                 } else {
                     redisTemplate.opsForValue().set(key, 50);
                     redisTemplate.expire(key,30,TimeUnit.MINUTES);

                 }


         }

     }
    se.miaosha(uid, status);
    return "dao";
}
//秒杀数据查询
@RequestMapping("miaoshacha")
@ResponseBody
    public  Map  maoshacha(@RequestBody ParameUtil param){
        return se.miaoshacha(param);
}
//秒杀跳转页面
@RequestMapping("miaoshacha1")
    public  String miaoshacha1(){

 return "miaoshacha";
    }
    //秒杀页面
    @RequestMapping("aaa")
    public  String aaa(){
        return  "miaosha";
    }

   @RequestMapping("updateseckill")
    public String  chaseckill(Integer id,Model model){
       Seckill list=se.chaseckill(id);
       model.addAttribute("l",list);
         return  "updateseckill";
   }
   @RequestMapping("update")
    @ResponseBody
    public void update(Seckill s,HttpServletRequest request){
       SimpleDateFormat c=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       System.out.println(s.getStime());
       String format = c.format(s.getStime());
      request.getSession().setAttribute("time",format);
       request.getSession().setAttribute("shuliang",s.getZhangshu());
       request.getSession().setAttribute("yuhui",s.getSeckillname());
       se.update(s);
   }

}