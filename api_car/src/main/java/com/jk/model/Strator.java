package com.jk.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ： 张松光
 * @date ：Created in 2019/8/15 9:49
 * @description：工作人员表,用于登录后台管理
 * @package ：com.jk.model
 * @version: 1.0.0
 */
public class Strator implements Serializable {
    private Integer userid;

    private String username;

    private String userpwd;

    private Date createdate;

    private String questionone;

    private String questiontwo;

    private String questionthree;

    private String userstatus;

    public Integer getuserid() {
        return userid;
    }

    public void setuserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getuserpwd() {
        return userpwd;
    }

    public void setuserpwd(String userpwd) {
        this.userpwd = userpwd == null ? null : userpwd.trim();
    }

    public Date getcreatedate() {
        return createdate;
    }

    public void setcreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getquestionone() {
        return questionone;
    }

    public void setquestionone(String questionone) {
        this.questionone = questionone == null ? null : questionone.trim();
    }

    public String getquestiontwo() {
        return questiontwo;
    }

    public void setquestiontwo(String questiontwo) {
        this.questiontwo = questiontwo == null ? null : questiontwo.trim();
    }

    public String getquestionthree() {
        return questionthree;
    }

    public void setquestionthree(String questionthree) {
        this.questionthree = questionthree == null ? null : questionthree.trim();
    }

    public String getuserstatus() {
        return userstatus;
    }

    public void setuserstatus(String
                       userstatus) {
        this.userstatus = userstatus == null ? null : userstatus.trim();
    }
}
