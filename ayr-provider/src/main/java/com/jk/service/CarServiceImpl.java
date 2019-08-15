package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.dao.CarMapper;
import com.jk.model.Car;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CarServiceImpl implements  CarService {
    @Autowired
    private CarMapper carmapper;
/**
 * Copyright (C), 2015-2019, jk
 * FileName: CarServiceImpl
 * Author:   Lemovo
 * Date:     2019-08-15 11:54
 * Description: 
 * History:
 * <author>          <time>          <version>          <desc>
 * 安安          修改时间           版本号              描述
 */
public  void  addCar(Car car){
    carmapper.addCar(car);
}
}

