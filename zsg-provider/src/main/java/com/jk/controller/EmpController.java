package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.service.EmpService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ： 张松光
 * @date ：Created in 2019/8/15 19:25
 * @description：1
 * @package ：
 * @version: 1.0
 */
@Controller
@RequestMapping("emp")
public class EmpController {

    @Reference(version = "1.0")
    private EmpService empService;
}
