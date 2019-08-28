package com.jk.model;

import java.io.Serializable;

//评论表
public class Comment implements Serializable {
private Integer id;//评论id
    private String commentname;//评论内容
    private String ptime;//评论时间
    private Integer userid;//评论人id
    private Integer carid;//汽车id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommentname() {
        return commentname;
    }

    public void setCommentname(String commentname) {
        this.commentname = commentname;
    }

    public String getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }
}
