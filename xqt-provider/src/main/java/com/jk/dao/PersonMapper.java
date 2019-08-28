package com.jk.dao;

import com.jk.model.Audit;
import com.jk.model.Car;
import com.jk.model.Cusmoter;
import com.jk.util.ParameUtil;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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

    @Insert("insert into t_cusmoter (codeKehu,codeKefu,cusTime) values (#{codeKehu},'--稍等',now())")
    void insertKehu(Cusmoter cusmoter);

    List<Cusmoter> queryKehus2();

    @Insert("insert into t_cusmoter (codeKefu,codeKehu,cusTime) values (#{codeKefu},'--稍等',now())")
    void insertkefu(Cusmoter cusmoter);

    List<Cusmoter> queryKefucode();
}
