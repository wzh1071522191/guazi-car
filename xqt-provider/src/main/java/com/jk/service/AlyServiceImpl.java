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

    @Override
    public Map queryCarAnalysiCount() {
        Map<String, Object> map = new HashMap<>();
        List<Car> cars = alyMapper.queryCarAnalysiCount();
        map.put("total",cars);
        System.out.println(map);
        return map;
    }
}
