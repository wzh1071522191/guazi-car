package com.jk.util;

import java.io.Serializable;

public class ParameUtil  implements Serializable {
    private Integer pageNumber;
    private Integer pageSize;
    private String qian;
    private String hou;
    private Integer ordername;

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	private String typename;
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
