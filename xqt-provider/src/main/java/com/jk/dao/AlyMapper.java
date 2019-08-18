package com.jk.dao;

import com.jk.model.Car;

import java.util.List;
import java.util.Map;

public interface AlyMapper {

    List<Car> findAnaList(Car car);

    List<Car> queryTodayAnaList(Car car);

    List<Car> queryYesterdayAnaList(Car car);

    List<Car> querySevendaysAnaList(Car car);

    List<Car> queryThirtyAnaList(Car car);

    List<Map<String, Object>> queryAnalyXian();
}
