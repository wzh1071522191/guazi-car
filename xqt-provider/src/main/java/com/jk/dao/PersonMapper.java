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

    @Insert("insert into t_cusmoter (codeKehu,codeKefu,cusTime) values (#{codeKehu},'.....亲,请稍等,客服可能有些忙',now())")
    void insertKehu(Cusmoter cusmoter);

    List<Cusmoter> queryKehus2();

    @Insert("insert into t_cusmoter (codeKefu,codeKehu,cusTime) values (#{codeKefu},'......请稍等,客户可能在回话中',now())")
    void insertkefu(Cusmoter cusmoter);

    List<Cusmoter> queryKefucode();
}
