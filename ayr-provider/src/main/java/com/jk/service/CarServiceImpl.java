package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.dao.CarMapper;
import com.jk.dao.CarTypeMapper;
import com.jk.model.Car;
import com.jk.model.CarType;
import com.jk.util.ParamQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(version = "1.0")
public class CarServiceImpl implements  CarService {
    @Autowired
    private CarMapper carmapper;
    @Autowired
    private CarTypeMapper cartypemapper;
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
   /* if(car.getCartypeid()==1){
        if(car.()==8){
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
       *//* if(car.getcarlc()!=null){
            price+=Double.parseDouble(car.getcarlc());
        }*//*
        if(car.getcardate().getTime()>new Date("2017-01-01").getTime() && car.getcardate().getTime()<new Date("2017-12-29").getTime()){
            price+=12.3;
        }
        if(car.getcardate().getTime()>new Date("2018-01-01").getTime() && car.getcardate().getTime()<new Date("2018-12-29").getTime()){
            price+=13.3;
        }if(car.getcardate().getTime()>new Date("2019-01-01").getTime() && car.getcardate().getTime()<new Date("2019-12-29").getTime()){
            price+=14.3;
        }if(car.getcardate().getTime()>new Date("2016-01-01").getTime() && car.getcardate().getTime()<new Date("2016-12-29").getTime()){
            price+=10.3;
        }*/
        System.out.println(price);
        return price;
    }
    @Override
    public List<Car> queryCar(ParamQuery param) {

        return carmapper.queryCarByType(param.getQuerytype());
    }


//    @Override
//    public List<Car> queryCarList(ParamQuery param) {
//        return carmapper.queryCarList(param);
//    }

    @Override
    public Map showCar(Integer page,Integer rows,Integer uid) {
    int stat=(page-1)*rows;
    long count=carmapper.queryCount();
   // List<Car> list=carmapper.queryList(stat,rows,uid);
    Map map=new HashMap();
  //  map.put("rows", list);
    map.put("total", count);
        return map;
    }

    @Override
    public List<Car> queryCarAll(Car car) {
        return carmapper.queryCarAll(car);
    }



    @Override
    public Car showThisCarJsp(Integer carid) {
        return carmapper.showThisCarJsp(carid);
    }


    @Override
    public List<CarType> queryBrand() {
        return cartypemapper.queryBrand();
    }

    @Override
    public List<CarType> queryBrandType(Integer pid) {
        return cartypemapper.queryBrandType(pid);
    }

    @Override
    public List<Car> queryCar1() {
        return carmapper.queryCar1();
    }

    @Override
    public List<Car> queryCar2() {
        return carmapper.queryCar2();
    }

    @Override
    public List<Car> queryCar3() {
        return carmapper.queryCar3();
    }

    @Override
    public List<Car> queryCar4() {
        return carmapper.queryCar4();
    }


}

