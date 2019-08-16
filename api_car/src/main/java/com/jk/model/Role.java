package com.jk.model;

import java.io.Serializable;

/**
 * @author ： 张松光
 * @date ：Created in 2019/8/15 9:46
 * @description：角色表
 * @package ：com.jk.model
 * @version: 1.0.0
 */
public class Role implements Serializable {

    private static final long serialVersionUID = -8863742933862120139L;
    private Integer id;

    private String rolename;

    private String text;

    private String checked;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked == null ? null : checked.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}
