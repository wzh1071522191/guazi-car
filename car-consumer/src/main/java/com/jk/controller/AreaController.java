package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Area;
import com.jk.service.AreaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ： 安雅茹
 * @date ：Created in 2019-08-20 15:02
 * @description：
 * @package ：com.jk.controller
 * @version:
 */
@Controller
@RequestMapping("area")
public class AreaController {
@Reference
    private AreaService areaservice;
@RequestMapping("querySheng")
    @ResponseBody
    public List<Area> querySheng(){
    return areaservice.querySheng();
}
@RequestMapping("queryShi")
    @ResponseBody
    public List<Area> queryShi(Integer pid){
    return areaservice.queryShi(pid);
}
}

