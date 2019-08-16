package com.jk.dao;

import com.jk.model.Car;
import com.jk.util.ParameUtil;

import java.util.List;
import java.util.Map;

public interface Mdao {

    List<Car> querycar(ParameUtil parm);


    Integer sumcount();
}
