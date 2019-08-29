package com.jk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ： 朱友
 * @date ：Created in 2019/8/23 20:08
 * @description：1
 * @package ：com.jk.model
 * @version: 1
 */
public class Seckill implements Serializable {
    private  Integer id;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 处理从	前端到后端的时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")// 处理从	后端到前端的时间
    private Date stime;
    private  Integer seckillname;
    private  Integer zhangshu;
   private  Integer  fivesum;
    private  Integer  onesum;
    private  Integer thsum;

    public Integer getFivesum() {
        return fivesum;
    }

    public void setFivesum(Integer fivesum) {
        this.fivesum = fivesum;
    }

    public Integer getOnesum() {
        return onesum;
    }

    public void setOnesum(Integer onesum) {
        this.onesum = onesum;
    }

    public Integer getThsum() {
        return thsum;
    }

    public void setThsum(Integer thsum) {
        this.thsum = thsum;
    }

    public Integer getId() {
        return id;
    }

    public Date getStime() {
        return stime;
    }

    public void setStime(Date stime) {
        this.stime = stime;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getSeckillname() {
        return seckillname;
    }

    public void setSeckillname(Integer seckillname) {
        this.seckillname = seckillname;
    }

    public Integer getZhangshu() {
        return zhangshu;
    }

    public void setZhangshu(Integer zhangshu) {
        this.zhangshu = zhangshu;
    }
}
