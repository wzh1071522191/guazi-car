package com.jk.dao;

import com.jk.model.Car;

public interface CarMapper {
    int deleteByPrimaryKey(Integer carid);

    int insert(Car record);

    int insertSelective(Car record);

    Car selectByPrimaryKey(Integer carid);

    int updateByPrimaryKeySelective(Car record);

    int updateByPrimaryKey(Car record);

    void addCar(Car car);
}