package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.service.Mservice;
import com.jk.util.DataGridResult;
import com.jk.util.PageUtil;
import com.jk.util.ParameUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("mqc")
public class Mqccontroller {
    @Reference(version="1.0")
    private Mservice Mservice;


    //跳转到汽车页面
     @RequestMapping("query")
      public String car1(){
        return "mqcquerycar";
      }




    //汽车查询
     @RequestMapping("querycar")
     @ResponseBody
     public DataGridResult querycar(@RequestBody ParameUtil parm){

         PageUtil page = Mservice.querycar(parm);

         DataGridResult dat = new DataGridResult();
         dat.setRows(page.getList());
         dat.setTotal(page.getSumSize());

         return dat;
     }




}
