package com.jk.model;

import java.io.Serializable;

/**
 * @author ： 张松光
 * @date ：Created in 2019/8/15 9:48
 * @description：角色权限表
 * @package ：com.jk.model
 * @version: 1.0.0
 */
public class Rolemenu implements Serializable {

    private Integer id;

    private Integer rid;

    private Integer mid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }
}
