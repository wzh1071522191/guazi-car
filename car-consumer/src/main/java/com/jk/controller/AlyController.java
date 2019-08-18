package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Car;
import com.jk.service.AlyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/analysis")
public class AlyController {

    @Reference
    private AlyService alyService;

    // 求出出售的商品数 仓库的商品数量  被访问的商品数 商品的曝光数 商品浏览量 商品数访客数 加购件数 下单数  支付数
    @RequestMapping("queryCarAnalysiCount")
    @ResponseBody
    public List<Car> queryCarAnalysiCount(){

        return alyService.queryCarAnalysiCount();
    }

    //跳转html页面
    @RequestMapping("/toAnalHtml")
    public String toAnalHtml() {

        return "xqt/Analist.html";
    }

 }
