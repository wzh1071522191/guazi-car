package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.dao.CouponDao;
import com.jk.model.Coupon;
import com.jk.util.ParameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * @author ： 张松光
 * @date ：Created in 2019/8/18 14:13
 * @description：优惠券业务层
 * @package ：com.jk.service
 * @version: 1.0.0
 */
@Service(version = "1.0")
@Component
public class CouponServiceImpl implements CouponService{

    @Autowired
    private CouponDao couponDao;

    @Override
    public HashMap<String, Object> queryCoupon(ParameUtil pu) {
        Integer total =couponDao.queryCountCoupon();
        Integer page = pu.getPageNumber();
        pu.setPageNumber((page-1)*pu.getPageSize());
        List<Coupon> queryListCoupon = couponDao.queryListCoupon(pu);
        HashMap<String,Object> hashMap =new HashMap<String,Object>();
        hashMap.put("total",total);
        hashMap.put("rows",queryListCoupon);
        return hashMap;
    }

    @Override
    public List<Coupon> queryType() {

        return couponDao.queryType();
    }

    @Override
    @Async
    public void addCoupon(List<Coupon> list) {
        couponDao.addCoupon(list);
    }

}
