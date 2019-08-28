package com.jk.dao;

import com.jk.model.Car;
import com.jk.util.ParamQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarMapper {
    int deleteByPrimaryKey(Integer carid);

    int insert(Car record);

    int insertSelective(Car record);

    Car selectByPrimaryKey(Integer carid);

    int updateByPrimaryKeySelective(Car record);

    int updateByPrimaryKey(Car record);

    void addCar(Car car);


    List<Car> queryCarByType(@Param("querytype") Integer querytype);

    List<Car> queryCarList(ParamQuery param);

    long queryCount();

    List<Car> queryCarAll(Car car);

    Car showThisCarJsp(@Param("carid") Integer carid);

    List<Car> queryCar1();

    List<Car> queryCar2();

    List<Car> queryCar3();

    List<Car> queryCar4();
}