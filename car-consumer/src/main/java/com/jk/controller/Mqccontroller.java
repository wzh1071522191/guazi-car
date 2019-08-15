package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Car;
import com.jk.service.Mservice;
import com.jk.util.DataGridResult;
import com.jk.util.PageUtil;
import com.jk.util.ParameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("mqc")
public class Mqccontroller {
     @Reference
    private Mservice Mservice;


     @RequestMapping("querycar")
     public DataGridResult querycar(@RequestBody ParameUtil parm){
         PageUtil page = Mservice.querycar(parm);
         DataGridResult dat = new DataGridResult();
         dat.setRows(page.getList());
         dat.setTotal(page.getSumSize());
         return dat;
     }




}
