package com.jk.model;

import java.io.Serializable;

//订单详情表
public class Details implements Serializable {
  private Integer id;//详情id

    private String guige;//规格
    private Integer kuaidifei;//快递费
    private Integer yuhui;//优惠
    private Integer spprice;//商品总价
    private String   typename;//汽车名称临时字段
    private Integer  price;//单价临时字段
    private Integer  cunmber;//数量临时字段

    private Integer  shprice;//实收金额临时字段

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getShprice() {
        return shprice;
    }

    public void setShprice(Integer shprice) {
        this.shprice = shprice;
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


    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public Integer getSpprice() {
        return spprice;
    }

    public void setSpprice(Integer spprice) {
        this.spprice = spprice;
    }
}
