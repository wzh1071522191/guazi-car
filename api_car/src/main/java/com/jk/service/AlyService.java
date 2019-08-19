package com.jk.service;

import com.jk.model.Car;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AlyService {

//全部数据
    HashMap<String, Object> queryAnaList(Car car);
//今天数据
    HashMap<String, Object> queryTodayAnaList(Car car);
//昨天数据
    HashMap<String, Object> queryYesterdayAnaList(Car car);
//近7天数据
    HashMap<String, Object> querySevendaysAnaList(Car car);
//近30天数据
    HashMap<String, Object> queryThirtyAnaList(Car car);
//折线图
    List<Map<String, Object>> queryAnalyXian();
//饼状图
    List<Map<String, Object>> queryBingZhuang();
//柱状图
    List<Map<String, Object>> queryZhuzhuang();
}
