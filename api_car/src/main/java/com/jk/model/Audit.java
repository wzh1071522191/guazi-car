package com.jk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Audit implements Serializable {

    private static final long serialVersionUID = -2191296443509406864L;

    private Integer id;//id主键

    private Integer carid;//汽车id

    private Integer userid;//车主（卖家）信息

    private Integer varifierid;//检测师id

    private String carname;//汽车品牌名称

    private String carimg;//汽车图片

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date auditdate;//检测时间

    private Integer isshiigu;//是否是重大事故车 0.不是 1.是

    private String shiguimg;//如果是事故车，将损坏部位图片上传

    private Integer iswaiguan;//外观是否良好 0.不是 1.是

    private String waiguanimg;//外观有问题的话，将问题图片上传

    private Integer isbujian;//部件是否良好 0.不是 1.是

    private String bujianimg;//部件问题图片

    private Integer ischangyong; //常用功能检测是否良好 0.不是 1.是

    private String changyongimg;//功能检测是否完好，上传问题图片

    private Integer status; //状态   1.待审核 2.审核已通过 3.审核不通过

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getVarifierid() {
        return varifierid;
    }

    public void setVarifierid(Integer varifierid) {
        this.varifierid = varifierid;
    }

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public String getCarimg() {
        return carimg;
    }

    public void setCarimg(String carimg) {
        this.carimg = carimg;
    }

    public Date getAuditdate() {
        return auditdate;
    }

    public void setAuditdate(Date auditdate) {
        this.auditdate = auditdate;
    }

    public Integer getIsshiigu() {
        return isshiigu;
    }

    public void setIsshiigu(Integer isshiigu) {
        this.isshiigu = isshiigu;
    }

    public String getShiguimg() {
        return shiguimg;
    }

    public void setShiguimg(String shiguimg) {
        this.shiguimg = shiguimg;
    }

    public Integer getIswaiguan() {
        return iswaiguan;
    }

    public void setIswaiguan(Integer iswaiguan) {
        this.iswaiguan = iswaiguan;
    }

    public String getWaiguanimg() {
        return waiguanimg;
    }

    public void setWaiguanimg(String waiguanimg) {
        this.waiguanimg = waiguanimg;
    }

    public Integer getIsbujian() {
        return isbujian;
    }

    public void setIsbujian(Integer isbujian) {
        this.isbujian = isbujian;
    }

    public String getBujianimg() {
        return bujianimg;
    }

    public void setBujianimg(String bujianimg) {
        this.bujianimg = bujianimg;
    }

    public Integer getIschangyong() {
        return ischangyong;
    }

    public void setIschangyong(Integer ischangyong) {
        this.ischangyong = ischangyong;
    }

    public String getChangyongimg() {
        return changyongimg;
    }

    public void setChangyongimg(String changyongimg) {
        this.changyongimg = changyongimg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}