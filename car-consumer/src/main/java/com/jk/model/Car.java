package com.jk.model;

import java.io.Serializable;
import java.util.Date;

public class Car implements Serializable {
   private Integer carid;
   private String carbrandid ;
   private Date cardate;
   private String carlc;
   private Integer carareaid;
   private Integer carck;
   private Integer cartypeid;
   private Integer carcolor;
   private Integer carstatus;
   private Integer userid;
   private Date createdate;
   private Integer sellcarcount;
   private Integer carvolume;
   private Integer visitorsum;
   private Integer purchasesum;
   private Integer expocarstatu;
   private Integer placecarstatu;
   private Integer mentcarstatu;
   private Integer visitcarstatu;

   //临时字段-->商品分析
    private Integer cangkucount;
    private Integer visitcount;
    private Integer expocarcount;
    private Integer placecarcount;
    private Integer mentcarcount;

    @Override
    public String toString() {
        return "Car{" +
                "carid=" + carid +
                ", carbrandid='" + carbrandid + '\'' +
                ", cardate=" + cardate +
                ", carlc='" + carlc + '\'' +
                ", carareaid=" + carareaid +
                ", carck=" + carck +
                ", cartypeid=" + cartypeid +
                ", carcolor=" + carcolor +
                ", carstatus=" + carstatus +
                ", userid=" + userid +
                ", createdate=" + createdate +
                ", sellcarcount=" + sellcarcount +
                ", carvolume=" + carvolume +
                ", visitorsum=" + visitorsum +
                ", purchasesum=" + purchasesum +
                ", expocarstatu=" + expocarstatu +
                ", placecarstatu=" + placecarstatu +
                ", mentcarstatu=" + mentcarstatu +
                ", visitcarstatu=" + visitcarstatu +
                ", cangkucount=" + cangkucount +
                ", visitcount=" + visitcount +
                ", expocarcount=" + expocarcount +
                ", placecarcount=" + placecarcount +
                ", mentcarcount=" + mentcarcount +
                '}';
    }

    public Integer getCangkucount() {
        return cangkucount;
    }

    public void setCangkucount(Integer cangkucount) {
        this.cangkucount = cangkucount;
    }

    public Integer getVisitcount() {
        return visitcount;
    }

    public void setVisitcount(Integer visitcount) {
        this.visitcount = visitcount;
    }

    public Integer getExpocarcount() {
        return expocarcount;
    }

    public void setExpocarcount(Integer expocarcount) {
        this.expocarcount = expocarcount;
    }

    public Integer getPlacecarcount() {
        return placecarcount;
    }

    public void setPlacecarcount(Integer placecarcount) {
        this.placecarcount = placecarcount;
    }

    public Integer getMentcarcount() {
        return mentcarcount;
    }

    public void setMentcarcount(Integer mentcarcount) {
        this.mentcarcount = mentcarcount;
    }

    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }

    public String getCarbrandid() {
        return carbrandid;
    }

    public void setCarbrandid(String carbrandid) {
        this.carbrandid = carbrandid;
    }

    public Date getCardate() {
        return cardate;
    }

    public void setCardate(Date cardate) {
        this.cardate = cardate;
    }

    public String getCarlc() {
        return carlc;
    }

    public void setCarlc(String carlc) {
        this.carlc = carlc;
    }

    public Integer getCarareaid() {
        return carareaid;
    }

    public void setCarareaid(Integer carareaid) {
        this.carareaid = carareaid;
    }

    public Integer getCarck() {
        return carck;
    }

    public void setCarck(Integer carck) {
        this.carck = carck;
    }

    public Integer getCartypeid() {
        return cartypeid;
    }

    public void setCartypeid(Integer cartypeid) {
        this.cartypeid = cartypeid;
    }

    public Integer getCarcolor() {
        return carcolor;
    }

    public void setCarcolor(Integer carcolor) {
        this.carcolor = carcolor;
    }

    public Integer getCarstatus() {
        return carstatus;
    }

    public void setCarstatus(Integer carstatus) {
        this.carstatus = carstatus;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getSellcarcount() {
        return sellcarcount;
    }

    public void setSellcarcount(Integer sellcarcount) {
        this.sellcarcount = sellcarcount;
    }

    public Integer getCarvolume() {
        return carvolume;
    }

    public void setCarvolume(Integer carvolume) {
        this.carvolume = carvolume;
    }

    public Integer getVisitorsum() {
        return visitorsum;
    }

    public void setVisitorsum(Integer visitorsum) {
        this.visitorsum = visitorsum;
    }

    public Integer getPurchasesum() {
        return purchasesum;
    }

    public void setPurchasesum(Integer purchasesum) {
        this.purchasesum = purchasesum;
    }

    public Integer getExpocarstatu() {
        return expocarstatu;
    }

    public void setExpocarstatu(Integer expocarstatu) {
        this.expocarstatu = expocarstatu;
    }

    public Integer getPlacecarstatu() {
        return placecarstatu;
    }

    public void setPlacecarstatu(Integer placecarstatu) {
        this.placecarstatu = placecarstatu;
    }

    public Integer getMentcarstatu() {
        return mentcarstatu;
    }

    public void setMentcarstatu(Integer mentcarstatu) {
        this.mentcarstatu = mentcarstatu;
    }

    public Integer getVisitcarstatu() {
        return visitcarstatu;
    }

    public void setVisitcarstatu(Integer visitcarstatu) {
        this.visitcarstatu = visitcarstatu;
    }

}
