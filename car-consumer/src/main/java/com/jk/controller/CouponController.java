package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Coupon;
import com.jk.service.CouponService;
import com.jk.util.ParameUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * @author ： 张松光
 * @date ：Created in 2019/8/18 14:09
 * @description：优惠卷
 * @package ：com.jk.controller
 * @version: 1.0.0
 */
@Controller
@RequestMapping("coupon")
public class CouponController {

    @Reference(version = "1.0")
    private CouponService couponService;

    /**
     * @author :张松光
     * @method : toCoupon
     * @description : 跳转优惠券查询页面
     * @date: 2019/8/18 14:46
     * @param: []
     * @return java.lang.String
     */
    @RequestMapping("toCoupon")
    public String toCoupon(){

        return "coupon";
    }

    /**
     * @author :张松光
     * @method : queryCoupon
     * @description : 优惠券查询
     * @date: 2019/8/18 14:45
     * @param: [pu]
     * @return java.util.HashMap<java.lang.String,java.lang.Object>
     */
    @RequestMapping("queryCoupon")
    @ResponseBody
    public HashMap<String,Object> queryCoupon(@RequestBody ParameUtil pu){

        return couponService.queryCoupon(pu);
    }

    @RequestMapping("toAddCoupon")
    public String toAddCoupon(){
        return "addCoupon";
    }

    /**
     * @author :张松光
     * @method : queryType
     * @description : 描述一下方法的作用
     * @date: 2019/8/18 16:43
     * @param: []
     * @return java.util.List<com.jk.model.Coupon>
     */
    @RequestMapping("queryType")
    @ResponseBody
    public List<Coupon> queryType(){
        return couponService.queryType();
    }
    @RequestMapping("addCoupon")
    @ResponseBody
    public void addCoupon(Coupon c){
        couponService.addCoupon(c);
    }
}
