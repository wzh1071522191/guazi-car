package com.jk;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.service.Mservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("mqc")
public class Mqccontroller {
     @Reference
    private Mservice Mservice;


     @RequestMapping("querycar")
     public Map<String,Object> querycar(Integer page ,Integer rows){
         Map map=new HashMap();
         return map;
     }




}
