package com.jk.model;

import java.io.Serializable;

public class User  implements Serializable {
    private Integer  userid;
    private String username;


    private String  userphone;


    private Integer gwcid;//购物车id

    private Integer fivehundred;
    private Integer onethousand;
    private Integer fivethousand;
    private Integer userstatus;




    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
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

    public Integer getGwcid() {
        return gwcid;
    }

    public void setGwcid(Integer gwcid) {
        this.gwcid = gwcid;
    }

    public Integer getFivehundred() {
        return fivehundred;
    }

    public void setFivehundred(Integer fivehundred) {
        this.fivehundred = fivehundred;
    }

    public Integer getOnethousand() {
        return onethousand;
    }

    public void setOnethousand(Integer onethousand) {
        this.onethousand = onethousand;
    }

    public Integer getFivethousand() {
        return fivethousand;
    }

    public void setFivethousand(Integer fivethousand) {
        this.fivethousand = fivethousand;
    }

    public Integer getUserstatus() {
        return userstatus;
    }

    public void setUserstatus(Integer userstatus) {
        this.userstatus = userstatus;
    }


}