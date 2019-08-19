package com.jk.dao;

import com.jk.model.Coupon;
import com.jk.util.ParameUtil;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ： 张松光
 * @date ：Created in 2019/8/18 14:19
 * @description：
 * @package ：com.jk.dao
 * @version:
 */
public interface CouponDao {

    @Select("SELECT  COUNT(*) FROM (select * from coupon c GROUP BY c.name, c.startDate) a")
    Integer queryCountCoupon();

    @Select("SELECT a.name,COUNT(*) cCount,a.startDate,a.endDate FROM (select * from coupon c) a GROUP BY a.startDate,a.name limit #{pageNumber},#{pageSize}")
    List<Coupon> queryListCoupon(ParameUtil pu);

    @Select("select * from coupon GROUP BY name")
    List<Coupon> queryType();


    void addCoupon(List<Coupon> list);
}
