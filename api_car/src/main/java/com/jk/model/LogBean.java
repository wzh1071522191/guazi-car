package com.jk.model;









import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ： 张松光
 * @date ：Created in 2019/8/15 10:03
 * @description：日志表，记录员工登录日志
 * @package ：com.jk.model
 * @version: 1.0.0
 */
public class LogBean implements Serializable {

    private static final long serialVersionUID = -1342285481020412884L;//序列id
    private String id;
    private String logname;         //日志名称
    private String logip;           //ip地址
    private String logis;           //是否有效
    private String requerpath;      //请求路径
    private String parame;          //参数
    private Integer userId;         //登录用户id
    private Object returningValue;  //返回值
    private String userName;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd") // 处理从	前端到后端的时间
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")// 处理从	后端到前端的时间
    private Date starDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd") // 处理从	前端到后端的时间
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")// 处理从	后端到前端的时间
    private Date endDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 处理从	前端到后端的时间
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")// 处理从	后端到前端的时间
    private Date logtime;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogname() {
        return logname;
    }

    public void setLogname(String logname) {
        this.logname = logname;
    }

    public String getLogip() {
        return logip;
    }

    public void setLogip(String logip) {
        this.logip = logip;
    }

    public String getLogis() {
        return logis;
    }

    public void setLogis(String logis) {
        this.logis = logis;
    }

    public String getRequerpath() {
        return requerpath;
    }

    public void setRequerpath(String requerpath) {
        this.requerpath = requerpath;
    }

    public String getParame() {
        return parame;
    }

    public void setParame(String parame) {
        this.parame = parame;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Object getReturningValue() {
        return returningValue;
    }

    public void setReturningValue(Object returningValue) {
        this.returningValue = returningValue;
    }

    public Date getStarDate() {
        return starDate;
    }

    public void setStarDate(Date starDate) {
        this.starDate = starDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getLogtime() {
        return logtime;
    }

    public void setLogtime(Date logtime) {
        this.logtime = logtime;
    }
}
