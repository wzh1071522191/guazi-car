package com.jk.model;

import java.io.Serializable;
import java.util.Date;

public class Car implements Serializable{

    private static final long serialVersionUID = -128926087222449921L;
    private Integer carid;

    private Double  carmaxprice;
    private Double carminprice;
    private Integer carbrandid;

    private Date cardate;

    private String carlc;

    private Integer carareaid;

    private Integer carck;

    private Integer cartypeid;

    private String carcolor;

    private Integer carstatus;

    private Integer userid;

    private Date createdate;

    private String carname;

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    private Integer carage;

    private Integer carlocation;

    private Integer carpl;

    private Integer carranyou;

    private Integer sellcarcount;

    private Integer expocarstatu;

    private Integer placecarstatu;

    private Integer mentcarstatu;

    private Integer visitcarstatu;

    private String carimg;

    private Integer cartypesonid;

    private Integer carvolume;

    private Integer visitorsum;

    private Integer purchasesum;

    private Integer carquerytypeid;

    private Integer carsxj;

    private Double carprice;

    private Date buydate;
    private Integer visitcount;


    private Integer expocarcount;


    private Integer placecarcount;


    private Integer mentcarcount;

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public Integer getCangkucount() {
        return cangkucount;
    }

    public void setCangkucount(Integer cangkucount) {
        this.cangkucount = cangkucount;
    }

    //仓库总数量临时
    private Integer cangkucount;

    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }

    public Double getCarmaxprice() {
        return carmaxprice;
    }

    public void setCarmaxprice(Double carmaxprice) {
        this.carmaxprice = carmaxprice;
    }

    public Double getCarminprice() {
        return carminprice;
    }

    public void setCarminprice(Double carminprice) {
        this.carminprice = carminprice;
    }

    public Integer getCarbrandid() {
        return carbrandid;
    }

    public void setCarbrandid(Integer carbrandid) {
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

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getCarage() {
        return carage;
    }

    public void setCarage(Integer carage) {
        this.carage = carage;
    }

    public Integer getCarlocation() {
        return carlocation;
    }

    public void setCarlocation(Integer carlocation) {
        this.carlocation = carlocation;
    }

    public Integer getCarpl() {
        return carpl;
    }

    public void setCarpl(Integer carpl) {
        this.carpl = carpl;
    }

    public Integer getCarranyou() {
        return carranyou;
    }

    public void setCarranyou(Integer carranyou) {
        this.carranyou = carranyou;
    }

    public Integer getSellcarcount() {
        return sellcarcount;
    }

    public void setSellcarcount(Integer sellcarcount) {
        this.sellcarcount = sellcarcount;
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

    public String getCarimg() {
        return carimg;
    }

    public void setCarimg(String carimg) {
        this.carimg = carimg;
    }

    public Integer getCartypesonid() {
        return cartypesonid;
    }

    public void setCartypesonid(Integer cartypesonid) {
        this.cartypesonid = cartypesonid;
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

    public Integer getCarquerytypeid() {
        return carquerytypeid;
    }

    public void setCarquerytypeid(Integer carquerytypeid) {
        this.carquerytypeid = carquerytypeid;
    }

    public Integer getCarsxj() {
        return carsxj;
    }

    public void setCarsxj(Integer carsxj) {
        this.carsxj = carsxj;
    }

    public Double getCarprice() {
        return carprice;
    }

    public void setCarprice(Double carprice) {
        this.carprice = carprice;
    }

    public Date getBuydate() {
        return buydate;
    }

    public void setBuydate(Date buydate) {
        this.buydate = buydate;
    }
    @Override
    public String toString() {
        return "Car{" +
                "carid=" + carid +
                ", carmaxprice=" + carmaxprice +
                ", carminprice=" + carminprice +
                ", carbrandid=" + carbrandid +
                ", cardate=" + cardate +
                ", carlc='" + carlc + '\'' +
                ", carareaid=" + carareaid +
                ", carck=" + carck +
                ", cartypeid=" + cartypeid +
                ", carcolor='" + carcolor + '\'' +
                ", carstatus=" + carstatus +
                ", userid=" + userid +
                ", createdate=" + createdate +
                ", carage=" + carage +
                ", carlocation=" + carlocation +
                ", carpl=" + carpl +
                ", carranyou=" + carranyou +
                ", sellcarcount=" + sellcarcount +
                ", expocarstatu=" + expocarstatu +
                ", placecarstatu=" + placecarstatu +
                ", mentcarstatu=" + mentcarstatu +
                ", visitcarstatu=" + visitcarstatu +
                ", carimg='" + carimg + '\'' +
                ", cartypesonid=" + cartypesonid +
                ", carvolume=" + carvolume +
                ", visitorsum=" + visitorsum +
                ", purchasesum=" + purchasesum +
                ", carquerytypeid=" + carquerytypeid +
                ", carsxj=" + carsxj +
                ", carprice=" + carprice +
                ", buydate=" + buydate +
                '}';
    }
}