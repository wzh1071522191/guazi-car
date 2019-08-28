package com.jk.model;

import java.io.Serializable;

//订单详情表
public class Details implements Serializable {
  private Integer id;//详情id
    private Integer oid;//订单管理id
    private String guige;//规格
    private Integer kuaidifei;//快递费
    private Integer yuhui;//优惠
    private Integer sprice;//实付款

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getGuige() {
        return guige;
    }

    public void setGuige(String guige) {
        this.guige = guige;
    }

    public Integer getKuaidifei() {
        return kuaidifei;
    }

    public void setKuaidifei(Integer kuaidifei) {
        this.kuaidifei = kuaidifei;
    }

    public Integer getYuhui() {
        return yuhui;
    }

    public void setYuhui(Integer yuhui) {
        this.yuhui = yuhui;
    }

    public Integer getSprice() {
        return sprice;
    }

    public void setSprice(Integer sprice) {
        this.sprice = sprice;
    }
}
