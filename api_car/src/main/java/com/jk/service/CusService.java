package com.jk.service;

import com.jk.model.Car;

import java.util.HashMap;

/**
 * @author ： xueqitao
 * @date ：Created in 2019/8/21 0021 16:33
 * @description：
 * @package ：com.jk.service
 * @version:
 */
public interface CusService {
    HashMap<String, Object> queryCustomerListAll(Car car);
}
