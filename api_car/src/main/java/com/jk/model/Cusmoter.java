package com.jk.model;

import java.io.Serializable;

/**
 * @author ： xueqitao
 * @date ：Created in 2019/8/22 0022 10:47
 * @description：客服中心
 * @package ：com.jk.model
 * @version:
 */
public class Cusmoter implements Serializable {
    private Integer id;
    private Integer customerid;
    private String codeKehu;//客户回复的消息
    private String codeKefu;//客服回复的消息
    private String cusTime;//回复的时间

    @Override
    public String toString() {
        return "Cusmoter{" +
                "id=" + id +
                ", customerid=" + customerid +
                ", codeKehu='" + codeKehu + '\'' +
                ", codeKefu='" + codeKefu + '\'' +
                ", cusTime='" + cusTime + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    public String getCodeKehu() {
        return codeKehu;
    }

    public void setCodeKehu(String codeKehu) {
        this.codeKehu = codeKehu;
    }

    public String getCodeKefu() {
        return codeKefu;
    }

    public void setCodeKefu(String codeKefu) {
        this.codeKefu = codeKefu;
    }

    public String getCusTime() {
        return cusTime;
    }

    public void setCusTime(String cusTime) {
        this.cusTime = cusTime;
    }
}
