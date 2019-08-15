package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.service.CommService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("com")
public class ComController {
    @Reference
    private CommService se;

}
