package com.jk.dao;

import com.jk.model.Car;

import java.util.List;

public interface Mdao {

    List<Car> querycar(Integer sum, Integer pageNumber);

    Integer querysum();
}
