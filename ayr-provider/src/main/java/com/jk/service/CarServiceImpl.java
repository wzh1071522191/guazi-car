package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.dao.CarMapper;
import com.jk.model.Car;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

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

    @Override
    public Double testCarPrice(Car car) {

    Double price=0.00;
    if(car.getcartypeid()==1){
        if(car.getCartypesonid()==8){
            price+=20.6;
        }else if(car.getCartypesonid()==9){
            price+=19.6;
        }
        else if(car.getCartypesonid()==10){
            price+=18.6;
        }else if(car.getCartypesonid()==11){
            price+=17.6;
        }else if(car.getCartypesonid()==12){
            price+=16.6;
        }else if(car.getCartypesonid()==13){
            price+=15.6;
        }else if(car.getCartypesonid()==14){
            price+=14.6;
        }
    }else  if(car.getcartypeid()==2){
        if(car.getCartypesonid()==15){
            price+=21.6;
        }else if(car.getCartypesonid()==16){
            price+=22.6;
        }else if(car.getCartypesonid()==17){
            price+=23.6;
        }else if(car.getCartypesonid()==18){
            price+=24.6;
        }
        else if(car.getCartypesonid()==19){
            price+=25.6;
        }else if(car.getCartypesonid()==20){
            price+=26.6;
        }else if(car.getCartypesonid()==21){
            price+=27.6;
        }else if(car.getCartypesonid()==22){
            price+=28.6;
        }else if(car.getCartypesonid()==23){
            price+=29.6;
        }
    }else if(car.getcartypeid()==3){
        if(car.getCartypesonid()==24){
            price+=30.6;
        }else if(car.getCartypesonid()==25){
            price+=22.6;
        }
    }
     if(car.getcarlc()<10.0 && car.getcarlc()>0){
         price+=car.getcarlc();
     }
        if(car.getcarlc()!=null){
            price+=car.getcarlc();
        }
        if(car.getcardate().getTime()>new Date("2017-01-01").getTime() && car.getcardate().getTime()<new Date("2017-12-29").getTime()){
            price+=12.3;
        }
        if(car.getcardate().getTime()>new Date("2018-01-01").getTime() && car.getcardate().getTime()<new Date("2018-12-29").getTime()){
            price+=13.3;
        }if(car.getcardate().getTime()>new Date("2019-01-01").getTime() && car.getcardate().getTime()<new Date("2019-12-29").getTime()){
            price+=14.3;
        }if(car.getcardate().getTime()>new Date("2016-01-01").getTime() && car.getcardate().getTime()<new Date("2016-12-29").getTime()){
            price+=10.3;
        }
        System.out.println(price);
        return price;
    }
}

