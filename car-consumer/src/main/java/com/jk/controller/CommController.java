package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Details;
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

@Controller
@RequestMapping("comm")
public class CommController {
    @Reference
    private CommService se;
    //订单查询全部
    @RequestMapping("cha")
    @ResponseBody
    public DataGridResult chauxn(@RequestBody ParameUtil params){
         DataGridResult da=new DataGridResult();
        PageUtil pa=se.cha(params);
        da.setRows(pa.getList());
        da.setTotal(pa.getSumSize());

      return da;
    }
    //跳转订单查询页面
  @RequestMapping("cha1")
    public String cha1(){

        return "cha";
  }
 //订单待付款查询
 @RequestMapping("daifukuan")
 @ResponseBody
 public DataGridResult daifukuan(@RequestBody ParameUtil param){
     DataGridResult da=new DataGridResult();
     PageUtil pa=se.dai(param);
     da.setTotal(pa.getSumSize());
     da.setRows(pa.getList());
     return da;
 }

 //订单待发货查询
 @RequestMapping("daifahuo")
 @ResponseBody
 public DataGridResult daifahuo(@RequestBody ParameUtil param){
     DataGridResult da=new DataGridResult();
     PageUtil pa=se.fa(param);
     da.setTotal(pa.getSumSize());
     da.setRows(pa.getList());
     return da;
 }
 //订单已发货查询
 @RequestMapping("yifahuo")
 @ResponseBody
 public DataGridResult yifahuo(@RequestBody ParameUtil param){
     DataGridResult da=new DataGridResult();
     PageUtil pa=se.yi(param);
     da.setTotal(pa.getSumSize());
     da.setRows(pa.getList());
     return da;
 }
    //订单已完成查询
    @RequestMapping("yiwancheng")
    @ResponseBody
    public DataGridResult yiwancheng(@RequestBody ParameUtil param){
        DataGridResult da=new DataGridResult();
        PageUtil pa=se.wan(param);
        da.setTotal(pa.getSumSize());
        da.setRows(pa.getList());
        return da;
    }
    //订单已关闭查询
    @RequestMapping("yiguanbi")
    @ResponseBody
    public DataGridResult yiguanbi(@RequestBody ParameUtil param){
        DataGridResult da=new DataGridResult();
        PageUtil pa=se.guan(param);
        da.setTotal(pa.getSumSize());
        da.setRows(pa.getList());
        return da;
    }
    //订单退款中查询
    @RequestMapping("tuikuanzhong")
    @ResponseBody
    public DataGridResult tuikuanzhong(@RequestBody ParameUtil param){
        DataGridResult da=new DataGridResult();
        PageUtil pa=se.tui(param);
        da.setTotal(pa.getSumSize());
        da.setRows(pa.getList());
        return da;
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
    public DataGridResult kuan(@RequestBody ParameUtil parame){
        DataGridResult da=new DataGridResult();
        PageUtil pa=se.kuan(parame);
        da.setTotal(pa.getSumSize());
        da.setRows(pa.getList());
        return da;
    }
    //交易退款跳转页面
    @RequestMapping("kuan1")
    public String kuan1(){

     return "kuan";
    }
}
