package com.jk.model;

import java.io.Serializable;
//退款表
public class Refund implements Serializable {

    private  Integer id;//退款ID
    private  Integer oid;//订单id
    private  Integer carid;//汽车id
    private  Integer price;//订单金额
    private  Integer tkprice;//退款金额
    private  Integer status;//发货状态
    private  Integer fangshi;//退款方式
    private  Integer reason;//原因
    private  Integer dtime;//申请时间
    private  Integer zhuangtai;//退款状态

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

    public Integer getTkprice() {
        return tkprice;
    }

    public void setTkprice(Integer tkprice) {
        this.tkprice = tkprice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getFangshi() {
        return fangshi;
    }

    public void setFangshi(Integer fangshi) {
        this.fangshi = fangshi;
    }

    public Integer getReason() {
        return reason;
    }

    public void setReason(Integer reason) {
        this.reason = reason;
    }

    public Integer getDtime() {
        return dtime;
    }

    public void setDtime(Integer dtime) {
        this.dtime = dtime;
    }

    public Integer getZhuangtai() {
        return zhuangtai;
    }

    public void setZhuangtai(Integer zhuangtai) {
        this.zhuangtai = zhuangtai;
    }
}
