package com.jk.util;

import java.io.Serializable;

public class ParamQuery implements Serializable {
    public Integer getQuerytype() {
        return querytype;
    }

    public void setQuerytype(Integer querytype) {
        this.querytype = querytype;
    }

    /**
     * Copyright (C), 2015-2019, jk
     * FileName: ParamQuery
     * Author:   Lemovo
     * Date:     2019-08-16 16:13
     * Description:
     * History:
     * <author>          <time>          <version>          <desc>
     * 安安          修改时间           版本号              描述
     */
    private Integer querytype;

    public Integer getCarlc() {
        return carlc;
    }

    public void setCarlc(Integer carlc) {
        this.carlc = carlc;
    }

    public Integer getCarcolor() {
        return carcolor;
    }

    public void setCarcolor(Integer carcolor) {
        this.carcolor = carcolor;
    }

    public Integer getCarranyou() {
        return carranyou;
    }

    public void setCarranyou(Integer carranyou) {
        this.carranyou = carranyou;
    }

    public Integer getCarpl() {
        return carpl;
    }

    public void setCarpl(Integer carpl) {
        this.carpl = carpl;
    }

    private Integer  carlc;
    private Integer carcolor;
    private Integer  carranyou;
    private Integer carpl;
}

