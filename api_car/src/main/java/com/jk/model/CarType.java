package com.jk.model;

import java.io.Serializable;

public class CarType  implements Serializable {
    private Integer id;

    private String typename;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }
}