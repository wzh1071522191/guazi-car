package com.jk.model;

import org.xml.sax.SAXException;

import java.io.Serializable;

public class RoundImg implements Serializable {
    private Integer imgid;

    private String imgurl;

    private Integer imgzt;

    public Integer getImgid() {
        return imgid;
    }

    public void setImgid(Integer imgid) {
        this.imgid = imgid;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl == null ? null : imgurl.trim();
    }

    public Integer getImgzt() {
        return imgzt;
    }

    public void setImgzt(Integer imgzt) {
        this.imgzt = imgzt;
    }
}