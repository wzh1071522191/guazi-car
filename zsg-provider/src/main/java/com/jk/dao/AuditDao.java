package com.jk.dao;

import com.jk.model.Audit;
import com.jk.util.ParameUtil;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.HashMap;
import java.util.List;

/**
 * @author ： 张松光
 * @date ：Created in 2019/8/20 19:22
 * @description：车辆审核持久层
 * @package ：com.jk.dao
 * @version: 1.0.0
 */
public interface AuditDao {
   // @Select("SELECT COUNT(*) FROM t_audit")
    Integer queryAuditCarCount();

    //@Select("SELECT * FROM t_audit LIMIT #{pageNumber},#{pageSize}")
    List<Audit> queryListAuditCar(ParameUtil pu);

    void updateStatus(HashMap<String, Object> hashMap);

   // @Update("update t_audit set auditdate=now(),isshigu=#{isshigu},shiguimg=#{shiguimg},iswaiguan=#{iswaiguan},waiguanimg=#{waiguanimg},isbujian=#{isbujian},bujianimg=#{bujianimg},ischangyong=#{ischangyong},changyongimg=#{changyongimg} where id=#{id}")
    void upMessage(Audit audit);

    //@Select("SELECT * FROM t_audit where id=#{id}")
    Audit queryCarById(Integer id);
}
