package com.jk.dao;

import com.jk.model.Audit;
import com.jk.model.Car;
import com.jk.util.ParameUtil;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @author ： xueqitao
 * @date ：Created in 2019/8/21 0021 19:36
 * @description：
 * @package ：com.jk.dao
 * @version:
 */
public interface PersonMapper {

    int findCarShoppingCount(HashMap<String, Object> hashMap);

    List<Car> findCarShoppingList(@Param("page")int i, @Param("rows")Integer rows, @Param("car")Car car);
}
