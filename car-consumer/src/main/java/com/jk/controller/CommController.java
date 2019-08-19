package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Details;
import com.jk.model.Order;
import com.jk.service.CommService;
import com.jk.util.DataGridResult;
import com.jk.util.PageUtil;
import com.jk.util.ParameUtil;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("comm")
public class CommController {
    @Reference
    private CommService se;
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
    //订单详情查询
    @RequestMapping("xiang")

    public String xiang(Integer id,Model model){
        List<Details> list= se.xiang(id);
        model.addAttribute("s",list);
 return  "xiang";
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
    public void  dindanxin(Order o, Integer uid, Integer cid){
        se.dindanxin(o,uid,cid);
    }
}

