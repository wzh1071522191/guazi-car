package com.jk.util;

import java.io.Serializable;

public class ParameUtil implements Serializable {
    private Integer pageNumber;
    private Integer pageSize;
    private Integer carstatus;
	private Integer carbrandid;
    private String qian;
    private String hou;
    private Integer ordername;

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

	public Integer getCarstatus() {
		return carstatus;
	}

	public void setCarstatus(Integer carstatus) {
		this.carstatus = carstatus;
	}

	public Integer getCarbrandid() {
		return carbrandid;
	}

	public void setCarbrandid(Integer carbrandid) {
		this.carbrandid = carbrandid;
	}

	public String getQian() {
		return qian;
	}

	public void setQian(String qian) {
		this.qian = qian;
	}

	public String getHou() {
		return hou;
	}

	public void setHou(String hou) {
		this.hou = hou;
	}

	public Integer getOrdername() {
		return ordername;
	}

	public void setOrdername(Integer ordername) {
		this.ordername = ordername;
	}
}
