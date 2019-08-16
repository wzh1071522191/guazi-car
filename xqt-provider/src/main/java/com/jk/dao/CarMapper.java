package com.jk.dao;

import com.jk.model.Car;

import java.util.List;

public interface CarMapper {
    List<Car> queryCarAnalysiCount(Car car);
}
