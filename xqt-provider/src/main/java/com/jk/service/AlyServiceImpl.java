package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.dao.AlyMapper;
import com.jk.model.Car;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AlyServiceImpl implements AlyService{

    @Autowired
    private AlyMapper alyMapper;

//查询所有商品分析的数据
    @Override
    public HashMap<String, Object> queryAnaList(Car car) {
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("car",car);
        List<Car> Analist =  alyMapper.findAnaList(car);
        hashMap.put("rows", Analist);
        return hashMap;
    }
//查询今天商品分析的数据
    @Override
    public HashMap<String, Object> queryTodayAnaList(Car car) {
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("car",car);
        List<Car> Analist2 =  alyMapper.queryTodayAnaList(car);
        hashMap.put("rows", Analist2);
        return hashMap;
    }
    //查询昨天商品分析的数据
    @Override
    public HashMap<String, Object> queryYesterdayAnaList(Car car) {
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("car",car);
        List<Car> Analist3 =  alyMapper.queryYesterdayAnaList(car);
        hashMap.put("rows", Analist3);
        return hashMap;
    }
    //查询最近七天商品分析的数据
    @Override
    public HashMap<String, Object> querySevendaysAnaList(Car car) {
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("car",car);
        List<Car> Analist4 =  alyMapper.querySevendaysAnaList(car);
        hashMap.put("rows", Analist4);
        return hashMap;
    }

    @Override
    public HashMap<String, Object> queryThirtyAnaList(Car car) {
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("car",car);
        List<Car> Analist5 =  alyMapper.queryThirtyAnaList(car);
        hashMap.put("rows", Analist5);
        return hashMap;
    }

    @Override
    public List<Map<String, Object>> queryBingZhuang() {
        return alyMapper.queryBingZhuang();
    }

    @Override
    public List<Map<String, Object>> queryZhuzhuang() {
        return alyMapper.queryZhuzhuang();
    }

    @Override
    public List<Map<String, Object>> queryShoppingZhexian() {
        return alyMapper.queryShoppingZhexian();
    }

    @Override
    public List<Map<String, Object>> queryShoppingZhexianWeek() {
        return alyMapper.queryShoppingZhexianWeek();
    }

    @Override
    public List<Map<String, Object>> queryShoppingZhexianYue() {
        return alyMapper.queryShoppingZhexianYue();
    }

    @Override
    public List<Map<String, Object>> queryShoppingZhuxingByMonth() {
        return alyMapper.queryShoppingZhuxingByMonth();
    }

    @Override
    public List<Map<String, Object>> queryShoppingZhuxingByYear() {
        return alyMapper.queryShoppingZhuxingByYear();
    }

    @Override
    public List<Map<String, Object>> queryShoppingZhuxingByWeek() {
        return alyMapper.queryShoppingZhuxingByWeek();
    }

    @Override
    public List<Map<String, Object>> queryMianjiShopping() {
        return alyMapper.queryMianjiShopping();
    }

    @Override
    public List<Car> SelectShoppingGaikuang() {
        return alyMapper.SelectShoppingGaikuang();
    }

    @Override
    public List<Car> SelectShoppingLiuliang() {
        return alyMapper.SelectShoppingLiuliang();
    }

    @Override
    public List<Car> SelectShoppingZhuanhua() {
        return alyMapper.SelectShoppingZhuanhua();
    }

    @Override
    public List<Car> queryExportExcelGaikuangSeven() {
        return alyMapper.queryExportExcelGaikuangSeven();
    }

    @Override
    public List<Car> queryExportExcelLiuliangSeven() {
        return alyMapper.queryExportExcelLiuliangSeven();
    }

    @Override
    public List<Car> queryExportExcelZhuanhuaSeven() {
        return alyMapper.queryExportExcelZhuanhuaSeven();
    }

    @Override
    public List<Car> queryExportExcelGaikuangThree() {
        return alyMapper.queryExportExcelGaikuangThree();
    }

    @Override
    public List<Car> queryExportExcelLiuliangThree() {
        return alyMapper.queryExportExcelLiuliangThree();
    }

    @Override
    public List<Car> queryExportExcelZhuanhuaThree() {
        return alyMapper.queryExportExcelZhuanhuaThree();
    }


}
