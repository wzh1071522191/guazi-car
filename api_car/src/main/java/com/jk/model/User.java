package com.jk.model;

public class User {
    private Integer 
userid;

    private String 
userphone;

    private Integer 
gwcid;

    private String username;

    public Integer getuserid() {
        return 
userid;
    }

    public void setuserid(Integer
userid) {
        this.
userid = 
userid;
    }

    public String getuserphone() {
        return 
userphone;
    }

    public void setuserphone(String
userphone) {
        this.
userphone = 
userphone == null ? null : 
userphone.trim();
    }

    public Integer getgwcid() {
        return 
gwcid;
    }

    public void setgwcid(Integer
gwcid) {
        this.
gwcid = 
gwcid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
}