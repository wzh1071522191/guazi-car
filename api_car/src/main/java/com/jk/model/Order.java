package com.jk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

//订单管理表
public class Order implements Serializable {
    private Integer  id; //订单号
    private Integer  carid;//汽车id
    private Integer  price;//单价
    private Integer  cunmber;//数量
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 处理从	前端到后端的时间
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")// 处理从	后端到前端的时间
    private Date xdtime;//下单时间
    private Integer  userid;//买家id
    private Integer  status;//交易状态
    private Integer  shprice;//实收金额
    private Integer  dataid;//订单详情id
    private String  username;//用户名称临时字段
    private String   typename;//汽车名称临时字段
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCunmber() {
        return cunmber;
    }

    public void setCunmber(Integer cunmber) {
        this.cunmber = cunmber;
    }



    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getShprice() {
        return shprice;
    }

    public void setShprice(Integer shprice) {
        this.shprice = shprice;
    }

    public Integer getDataid() {
        return dataid;
    }

    public void setDataid(Integer dataid) {
        this.dataid = dataid;
    }



    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getXdtime() {
        return xdtime;
    }

    public void setXdtime(Date xdtime) {
        this.xdtime = xdtime;
    }
}
