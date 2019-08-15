package com.jk.dao;

import com.jk.model.Order;
import com.jk.util.ParameUtil;

import java.util.List;

public interface CommDao {
    List<Order> cha(ParameUtil param);
}
