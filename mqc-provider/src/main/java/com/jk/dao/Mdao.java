package com.jk.dao;

import com.jk.model.Car;
import com.jk.model.CarType;
import com.jk.util.ParameUtil;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface Mdao {

    List<Car> querycar(ParameUtil parm);


    int sumcount();

    List<CarType> querytye();

     @Delete("delete from t_car where carid=#{id}")
    void deleteUser(String id);



    int sumcount2();

    List<CarType> querycartype(ParameUtil parm);
    @Update("update t_car set carsxj=2 where carid=#{id}")
    void upx(Integer id);

    int sumcount12();

    List<Car> querycar2(ParameUtil parm);

    @Insert("insert into t_car(carbrandid, carareaid, carcolor, carck, createdate, carstatus,carsxj) values(#{p.carbrandid},#{p.carareaid},#{p.carcolor},#{p.carck},now(),#{p.carstatus},1)")
    void addcar(@Param("p") Car c);

    @Update("update t_car set carsxj=1 where carid=#{id}")
    void ups(Integer id);
}
