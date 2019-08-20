package com.jk.model;



import com.alibaba.fastjson.JSON;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ： 张松光
 * @date ：Created in 2019/8/15 9:43
 * @description：菜单表，权限表
 * @package ：com.jk.model
 * @version: 1.0.0
 */
public class Menu implements Serializable {

    private static final long serialVersionUID = 8565943964608152437L;
    private Integer id;

    private String name;

    private Integer pid;

    private String text;

    private String url;

    private JSON state ;

    //private String status;

    private String checked;


    private List<Menu> nodes;

    private String description;

    private Map<String, Object> attributes = new HashMap<String, Object>();


    public JSON getState() {
        return state;
    }

    public void setState(JSON state) {
        this.state = state;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Menu> getNodes() {
        return nodes;
    }

    public void setNodes(List<Menu> nodes) {
        this.nodes = nodes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }
}
