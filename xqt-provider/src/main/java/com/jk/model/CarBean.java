package com.jk.model;

import java.io.Serializable;

public class CarBean implements Serializable {
    private Integer carid;
    private Integer carbrandid;
    private String cardate;
    private String carlc;
    private Integer carareaid;
    private Integer carck;
    private Integer cartypeid;
    private String carcolor;
    private Integer carstatus;
    private Integer userid;
    private String createdate;
    private Integer sellcarstatu;
    private Integer expocarstatu;
    private Integer placecarstatu;
    private Integer mentcarstatu;
    private Integer visitcarstatu;

    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }

    public Integer getCarbrandid() {
        return carbrandid;
    }

    public void setCarbrandid(Integer carbrandid) {
        this.carbrandid = carbrandid;
    }

    public String getCardate() {
        return cardate;
    }

    public void setCardate(String cardate) {
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

    public String getCarcolor() {
        return carcolor;
    }

    public void setCarcolor(String carcolor) {
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

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public Integer getSellcarstatu() {
        return sellcarstatu;
    }

    public void setSellcarstatu(Integer sellcarstatu) {
        this.sellcarstatu = sellcarstatu;
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

    @Override
    public String toString() {
        return "CarBean{" +
                "carid=" + carid +
                ", carbrandid=" + carbrandid +
                ", cardate='" + cardate + '\'' +
                ", carlc='" + carlc + '\'' +
                ", carareaid=" + carareaid +
                ", carck=" + carck +
                ", cartypeid=" + cartypeid +
                ", carcolor='" + carcolor + '\'' +
                ", carstatus=" + carstatus +
                ", userid=" + userid +
                ", createdate='" + createdate + '\'' +
                ", sellcarstatu=" + sellcarstatu +
                ", expocarstatu=" + expocarstatu +
                ", placecarstatu=" + placecarstatu +
                ", mentcarstatu=" + mentcarstatu +
                ", visitcarstatu=" + visitcarstatu +
                '}';
    }
}