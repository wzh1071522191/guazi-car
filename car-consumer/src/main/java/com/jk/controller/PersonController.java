package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jk.model.Car;
import com.jk.service.PersonService;
import com.jk.util.HttpClientUtil;
import com.jk.util.ParameUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * @author ： xueqitao
 * @date ：Created in 2019/8/21 0021 17:16
 * @description：客服
 * @package ：com.jk.controller
 * @version:
 */
@Controller
@RequestMapping("/Perso")
public class PersonController {

    @Reference
    private PersonService personService;

    //跳转商品列表接口
    @RequestMapping("/CusList")
    public String torobotchat(){

        return "xqt/CusList.html";
    }
    //跳转机器人服务接口
    @RequestMapping("/queryperson")
    public String jiqiren(){

        return "xqt/person.html";
    }

    //跳转人工服务接口
    @RequestMapping("/querypeople")
    public String querypeople(){

        return "xqt/people.html";
    }
    //商品分页列表查询
    @RequestMapping("findCarShoppingList")
    @ResponseBody
    public HashMap<String, Object> findCarShoppingList(Integer page, Integer rows, Car car){


        return personService.findCarShoppingList(page,rows,car);
    }

    //机器人服务正式接口
    @RequestMapping("robotchat")
    @ResponseBody
    public JSONObject liaoTian(String code)throws Exception {
        String url="http://api.qingyunke.com/api.php";
        HashMap<String, Object> params = new HashMap<>();
        params.put("key","free");
        params.put("appid",0);
        params.put("msg",code);
        String returnStr = HttpClientUtil.get(url, params);
        JSONObject parseObject = JSON.parseObject(returnStr);
        return parseObject;
    }


}
