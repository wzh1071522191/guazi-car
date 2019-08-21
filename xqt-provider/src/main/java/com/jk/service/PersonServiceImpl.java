package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.dao.PersonMapper;
import com.jk.model.Audit;
import com.jk.model.Car;
import com.jk.util.ParameUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ： xueqitao
 * @date ：Created in 2019/8/21 0021 19:35
 * @description：
 * @package ：com.jk.service
 * @version:
 */
@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonMapper personMapper;


    @Override
    public HashMap<String, Object> findCarShoppingList(Integer page, Integer rows, Car car) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("car", car);
        int count = personMapper.findCarShoppingCount(hashMap);
        List<Car> lists = personMapper.findCarShoppingList((page-1)*rows,rows,car);
        hashMap.put("total", count);
        hashMap.put("rows", lists);
        return hashMap;
    }
}
