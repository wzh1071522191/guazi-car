package com.jk.service;

import com.jk.model.Audit;
import com.jk.model.Car;
import com.jk.model.CarType;
import com.jk.model.jiameng;
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

 

  void ups(Integer id);

    Car toup(Integer id);

    void upcar(Car c);

    void deleteUser2(String ids);

    Map querymaiche(ParameUtil parm);

  int addcar(Car c);
  Audit querymai(Integer id);

  void addxianxia(Audit a, String id);

  void addaudit(Car a);

  void addyes(Integer id);

  void addno(Integer id);

  Map querykk(ParameUtil parm);

  void cv(Integer id);

  Map queryhei(ParameUtil parm);

  void huifu(Integer id);

  Map jm(ParameUtil parm);

  void sh(Integer id);

  void sh2(Integer id);

  void addjm(jiameng jm);

  Integer queryId();

  Car queryById(Integer id);




}
