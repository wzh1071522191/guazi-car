package com.jk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import javafx.scene.chart.PieChart;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class jiameng implements Serializable {
    private Integer jmid; //加盟id
    private String username; //
    private String userphone;
    private String shengdq;  //省地址
    private String shidq; //市
    private String youxiang; //邮箱
    private String liuyan;  //留言
    private Integer shenhe;  //审核
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date sqdate;
     private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getSqdate() {
        return sqdate;
    }

    public void setSqdate(Date sqdate) {
        this.sqdate = sqdate;
    }

    public Integer getJmid() {
        return jmid;
    }

    public void setJmid(Integer jmid) {
        this.jmid = jmid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getShengdq() {
        return shengdq;
    }

    public void setShengdq(String shengdq) {
        this.shengdq = shengdq;
    }

    public String getShidq() {
        return shidq;
    }

    public void setShidq(String shidq) {
        this.shidq = shidq;
    }

    public String getYouxiang() {
        return youxiang;
    }

    public void setYouxiang(String youxiang) {
        this.youxiang = youxiang;
    }

    public String getLiuyan() {
        return liuyan;
    }

    public void setLiuyan(String liuyan) {
        this.liuyan = liuyan;
    }

    public Integer getShenhe() {
        return shenhe;
    }

    public void setShenhe(Integer shenhe) {
        this.shenhe = shenhe;
    }
}
