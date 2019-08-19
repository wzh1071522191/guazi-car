package com.jk.service;

import com.jk.model.Car;
import com.jk.model.CarType;
import com.jk.util.PageUtil;
import com.jk.util.ParameUtil;

import java.util.List;
import java.util.Map;

public interface Mservice {


  Map querycar(ParameUtil parm);

  List<CarType> querytype();

        void   deleteUser(String ids);



        Map querycartype(ParameUtil parm);

  void upx(Integer id);

  Map querycar2(ParameUtil parm);

  void addcar(Car c);

  void ups(Integer id);

    Car toup(Integer id);

    void upcar(Car c);

    void deleteUser2(String ids);
}
