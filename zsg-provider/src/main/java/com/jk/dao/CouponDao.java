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

    @Select("select count(*) from coupon ")
    Integer queryCountCoupon();

    @Select("select * from coupon limit #{pageNumber},#{pageSize}")
    List<Coupon> queryListCoupon(ParameUtil pu);

    @Select("select * from coupon")
    List<Coupon> queryType();

    @Insert("insert into coupon(name,startDate,endDate,cCount) values(#{name},#{startDate},#{endDate},#{cCount})")
    void addCoupon(Coupon c);
}
