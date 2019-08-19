package com.jk.util;

import java.io.Serializable;

public class ParameUtil implements Serializable {
    private Integer pageNumber;
    private Integer pageSize;
	private String sortName;      //排序字段
	private String sortOrder;    //正序或倒,+-序
    private String qian;
    private String ho;
    private Integer id;
    private Integer fang;
	private Integer zhuang;
	private Integer kuan;
	private Integer re;



    private Integer ordername;

	public Integer getFang() {
		return fang;
	}

	public void setFang(Integer fang) {
		this.fang = fang;
	}

	public Integer getZhuang() {
		return zhuang;
	}

	public void setZhuang(Integer zhuang) {
		this.zhuang = zhuang;
	}

	public Integer getKuan() {
		return kuan;
	}

	public void setKuan(Integer kuan) {
		this.kuan = kuan;
	}

	public Integer getRe() {
		return re;
	}

	public void setRe(Integer re) {
		this.re = re;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getQian() {
		return qian;
	}

	public void setQian(String qian) {
		this.qian = qian;
	}



	public Integer getOrdername() {
		return ordername;
	}

	public void setOrdername(Integer ordername) {
		this.ordername = ordername;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

}
