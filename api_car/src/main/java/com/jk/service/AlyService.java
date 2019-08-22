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
//饼状图
    List<Map<String, Object>> queryBingZhuang();
//柱状图
    List<Map<String, Object>> queryZhuzhuang();
//查询折线
    List<Map<String, Object>> queryShoppingZhexian();
    //查询折线--week
    List<Map<String, Object>> queryShoppingZhexianWeek();
    //查询折线--月
    List<Map<String, Object>> queryShoppingZhexianYue();
    //查询柱状--Month
    List<Map<String, Object>> queryShoppingZhuxingByMonth();
    //查询柱状--天
    List<Map<String, Object>> queryShoppingZhuxingByYear();
    //查询柱状--星期
    List<Map<String, Object>> queryShoppingZhuxingByWeek();
    //查询柱状--面积
    List<Map<String, Object>> queryMianjiShopping();
    //Excle导出商品概况
    List<Car> SelectShoppingGaikuang();
    //Excle导出商品流量
    List<Car> SelectShoppingLiuliang();
    //Excle导出商品转化
    List<Car> SelectShoppingZhuanhua();
    //Excle导出商品概况近7天
    List<Car> queryExportExcelGaikuangSeven();
    //Excle导出商品流量近7天
    List<Car> queryExportExcelLiuliangSeven();
    //Excle导出商品转化近7天
    List<Car> queryExportExcelZhuanhuaSeven();
    //Excle导出商品概况近30天
    List<Car> queryExportExcelGaikuangThree();
    //Excle导出商品流量近30天
    List<Car> queryExportExcelLiuliangThree();
    //Excle导出商品转化近30天
    List<Car> queryExportExcelZhuanhuaThree();
}
