package com.jk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Car implements Serializable {
    //id
    private Integer carid;
    //品牌id
    private Integer carbrandid;
    //上牌时间
    private Date cardate;
    //汽车里程
    private String carlc;
    //汽车牌照地
    private Integer carareaid;
    //车况 一共有四种：1.好 2.正常 3.一般 4.事故车
    private Integer carck;
    //类型id
    private Integer cartypeid;
    // 颜色
    private String carcolor;
    //状态
    private Integer carstatus;
    //对应的客户id
    private Integer userid;
    private String typename;
    //发布日期
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 处理从	前端到后端的时间
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")// 处理从	后端到前端的时间
    private Date createdate;
    private Integer carsxj;

    private Integer carage;

    private Integer carlocation;

    private Integer carpl;

    private Integer carranyou;

    //出售数量，下单成功后自动加所下单数量----商品分析
    private Integer sellcarcount;
    //商品浏览量
    private Integer carvolume;
    //商品访客数
    private Integer visitorsum;
    //加购件数
    private Integer purchasesum;
    //1:已曝光 2:未曝光
    private Integer expocarstatu;
   //1:已下单 2:未下单
    private Integer placecarstatu;
   //1:已支付 3:支付中 2:未支付   默认是2未支付
    private Integer mentcarstatu;
   //1:未访问 2:已访问   默认是1未访问
    private Integer visitcarstatu;
    //仓库总数量临时
    private Integer cangkucount;


    private String carimg;
     private String text;






    private Integer visitcount;


    private Integer expocarcount;


    private Integer placecarcount;


    private Integer mentcarcount;

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

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getCarsxj() {
        return carsxj;
    }

    public void setCarsxj(Integer carsxj) {
        this.carsxj = carsxj;
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

    public Integer getCangkucount() {
        return cangkucount;
    }

    public void setCangkucount(Integer cangkucount) {
        this.cangkucount = cangkucount;
    }

    public String getCarimg() {
        return carimg;
    }

    public void setCarimg(String carimg) {
        this.carimg = carimg;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    @Override
    public String toString() {
        return "Car{" +
                "carid=" + carid +
                ", carbrandid=" + carbrandid +
                ", cardate=" + cardate +
                ", carlc='" + carlc + '\'' +
                ", carareaid=" + carareaid +
                ", carck=" + carck +
                ", cartypeid=" + cartypeid +
                ", carcolor='" + carcolor + '\'' +
                ", carstatus=" + carstatus +
                ", userid=" + userid +
                ", typename='" + typename + '\'' +
                ", createdate=" + createdate +
                ", carsxj=" + carsxj +
                ", carage=" + carage +
                ", carlocation=" + carlocation +
                ", carpl=" + carpl +
                ", carranyou=" + carranyou +
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
}