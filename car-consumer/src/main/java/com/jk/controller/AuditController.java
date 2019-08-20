package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.service.AuditService;
import com.jk.util.ParameUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * @author ： 张松光
 * @date ：Created in 2019/8/20 19:18
 * @description：审核车辆控制层
 * @package ：com.jk.controller
 * @version: 1.0.0
 */
@Controller
@RequestMapping("audit")
public class AuditController {

    @Reference(version = "1.0")
    private AuditService auditService;

    @RequestMapping("toAuditPage")
    public String toAuditPage(){
        return "auditCar";
    }

    @RequestMapping("queryAuditCar")
    @ResponseBody
    public HashMap<String,Object> queryAuditCar(@RequestBody ParameUtil pu){
        return auditService.queryAuditCar(pu);
    }

    @RequestMapping("updateStatus")
    @ResponseBody
    public String updateStatus(Integer id,Integer flag){
        return  auditService.updateStatus(id,flag);
    }
}
