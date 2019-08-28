package com.jk.service;

import com.jk.model.Car;
import com.jk.model.CarType;
import com.jk.util.ParamQuery;

import java.util.List;
import java.util.Map;

public interface CarService {
   void addCar(Car car);

    Double testCarPrice(Car car);

    List<Car> queryCar(ParamQuery param);

    Map showCar(Integer page, Integer rows,Integer uid);

    List<Car> queryCarAll(Car car);

    Car showThisCarJsp(Integer carid);


    List<CarType> queryBrand();

 List<CarType> queryBrandType(Integer pid);

    List<Car> queryCar1();

    List<Car> queryCar2();

    List<Car> queryCar3();

    List<Car> queryCar4();
}
