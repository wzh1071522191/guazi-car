package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.service.Mservice;
import com.jk.util.ParameUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


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
     public Map querycar(@RequestBody ParameUtil parm){


         return Mservice.querycar(parm);
     }




}
