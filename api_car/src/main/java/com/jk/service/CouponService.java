package com.jk.service;

import com.jk.model.Coupon;
import com.jk.util.ParameUtil;

import java.util.HashMap;
import java.util.List;

/**
 * @author ： 张松光
 * @date ：Created in 2019/8/18 14:29
 * @description：
 * @package ：com.jk.service
 * @version:
 */
public interface CouponService {
    HashMap<String, Object> queryCoupon(ParameUtil pu);

    List<Coupon> queryType();

    void addCoupon(Coupon c);
}
