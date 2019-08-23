package com.jk.service;


import com.jk.model.Comment;
import com.jk.model.Details;
import com.jk.model.Order;
import com.jk.util.DataGridResult;
import com.jk.util.PageUtil;
import com.jk.util.ParameUtil;

import java.util.List;
import java.util.Map;

public interface CommService {


    List<Details> xiang(Integer id);

    Map cha(ParameUtil params);

    Map fa(ParameUtil param);

    Map yi(ParameUtil param);

    Map wan(ParameUtil param);

    Map guan(ParameUtil param);

    Map tui(ParameUtil param);



    Map dai(ParameUtil param);

    Map kuan(ParameUtil parame);

    void tong(Integer sum, Integer id);

    Map ping(ParameUtil param);





    Map xiang1(ParameUtil param, Integer id);

    List<Comment> shu(Integer id);

    void huifu(Integer id, Comment c);

    void miaosha(Integer uid,Integer status);
}
