package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.dao.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CarServiceImpl {

    @Autowired
    private CarMapper carMapper;

}
