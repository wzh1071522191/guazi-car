package com.jk.model;

import java.io.Serializable;

/**
 * @author ： 张松光
 * @date ：Created in 2019/8/15 9:59
 * @description：员工权限表
 * @package ：com.jk.model
 * @version: 1.0.0
 */
public class Userrole implements Serializable {

    private static final long serialVersionUID = 5658494549972183571L;
    private Integer id;

    private Integer uid;

    private Integer rid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

}
