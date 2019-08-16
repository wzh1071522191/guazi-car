package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.dao.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class CarServiceImpl {
    //===========未完成时间条查与商品趋势
    @Autowired
    private CarMapper carMapper;

    //商品概况：求出出售的商品数 仓库的商品数量  被访问的商品数 --//商品流量: 商品的曝光数 商品浏览量 商品数访客数  --//商品转化  加购件数 下单数  支付数
     public List<Car> queryCarAnalysiCount(Car car){

         return carMapper.queryCarAnalysiCount(car);
     }



}
