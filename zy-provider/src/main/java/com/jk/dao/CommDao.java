package com.jk.dao;

import com.jk.model.Details;
import com.jk.model.Order;
import com.jk.model.Refund;
import com.jk.util.ParameUtil;

import java.util.List;

public interface CommDao {
    List<Order> cha(ParameUtil param);

    List<Order> dai(ParameUtil param);

    List<Order> fa(ParameUtil param);

    List<Order> yi(ParameUtil param);

    List<Order> wan(ParameUtil param);

    List<Order> guan(ParameUtil param);

    List<Order> tui(ParameUtil param);



    List<Refund> kuan(ParameUtil parame);


    List<Details> xiang(Integer id);
}
