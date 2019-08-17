package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.dao.AlyMapper;
import com.jk.model.Car;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class AlyServiceImpl implements AlyService{
    @Autowired
    private AlyMapper alyMapper;

    @Override
    public List<Car> queryCarAnalysiCount() {
        return alyMapper.queryCarAnalysiCount();
    }
}
