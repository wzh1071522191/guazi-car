package com.jk.service;

import com.jk.model.Car;
import com.jk.model.Cusmoter;
import com.jk.util.ParameUtil;

import java.util.HashMap;
import java.util.List;

/**
 * @author ： xueqitao
 * @date ：Created in 2019/8/21 0021 19:33
 * @description：
 * @package ：com.jk.service
 * @version:
 */
public interface PersonService {
    HashMap<String, Object> findCarShoppingList(Integer page, Integer rows, Car car);

    void insertKehu(Cusmoter cusmoter);

    List<Cusmoter> queryKehus2();

    void insertkefu(Cusmoter cusmoter);

    List<Cusmoter> queryKefucode();
}
