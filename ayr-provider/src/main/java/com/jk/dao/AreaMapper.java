package com.jk.dao;

import com.jk.model.Area;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AreaMapper {
    int deleteByPrimaryKey(Integer aid);

    int insert(Area record);

    int insertSelective(Area record);

    Area selectByPrimaryKey(Integer aid);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);

    List<Area> querySheng();

    List<Area> queryShi(@Param("pid") Integer pid);
}