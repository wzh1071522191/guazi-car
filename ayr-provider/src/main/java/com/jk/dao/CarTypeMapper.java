package com.jk.dao;

import com.jk.model.CarType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarTypeMapper {
    int deleteByPrimaryKey(Integer tid);

    int insert(CarType record);

    int insertSelective(CarType record);

    CarType selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(CarType record);

    int updateByPrimaryKey(CarType record);

    List<CarType> queryBrand();

    List<CarType> queryBrandType(@Param("pid") Integer pid);
}