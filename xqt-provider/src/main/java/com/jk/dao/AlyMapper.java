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

    List<Map<String, Object>> queryBingZhuang();

    List<Map<String, Object>> queryZhuzhuang();

    List<Map<String, Object>> queryShoppingZhexian();

    List<Map<String, Object>> queryShoppingZhexianWeek();

    List<Map<String, Object>> queryShoppingZhexianYue();

    List<Map<String, Object>> queryShoppingZhuxingByMonth();

    List<Map<String, Object>> queryShoppingZhuxingByYear();

    List<Map<String, Object>> queryShoppingZhuxingByWeek();

    List<Map<String, Object>> queryMianjiShopping();

    List<Car> SelectShoppingGaikuang();

    List<Car> SelectShoppingLiuliang();

    List<Car> SelectShoppingZhuanhua();

    List<Car> queryExportExcelGaikuangSeven();

    List<Car> queryExportExcelLiuliangSeven();

    List<Car> queryExportExcelZhuanhuaSeven();

    List<Car> queryExportExcelGaikuangThree();

    List<Car> queryExportExcelLiuliangThree();

    List<Car> queryExportExcelZhuanhuaThree();
}
