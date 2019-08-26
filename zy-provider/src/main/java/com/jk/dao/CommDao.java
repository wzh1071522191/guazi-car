package com.jk.dao;

import com.jk.model.*;
import com.jk.util.ParameUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommDao {



 


    List<Details> xiang(Integer id);

    Integer czong(ParameUtil params);

    List<Order> cha(@Param("page") Integer page, @Param("pageSize") Integer pageSize, @Param("p") ParameUtil params);

    List<Order> dai(@Param("page") Integer page, @Param("pageSize") Integer pageSize, ParameUtil param);

    Integer dzong(ParameUtil param);

    List<Order> fa(@Param("page") Integer page, @Param("pageSize") Integer pageSize, ParameUtil param);

    Integer fzong(ParameUtil param);

    List<Order> yi(@Param("page") Integer page, @Param("pageSize") Integer pageSize, ParameUtil param);

    Integer yzong(ParameUtil param);

    Integer wzong(ParameUtil param);

    List<Order> wan(@Param("page") Integer page, @Param("pageSize") Integer pageSize, ParameUtil param);

    List<Order> guan(@Param("page") Integer page, @Param("pageSize") Integer pageSize, ParameUtil param);

    Integer gzong(ParameUtil param);

    Integer tzong(ParameUtil param);

    List<Order> tui(@Param("page") Integer page, @Param("pageSize") Integer pageSize, ParameUtil param);

    List<Refund> kuan(@Param("page") Integer page, @Param("pageSize") Integer pageSize, @Param("s") ParameUtil parame);

    Integer kzong(ParameUtil parame);

    void tong(Integer id);

    void jj(Integer id);

    Integer pzong(ParameUtil param);

    List<Comment> ping(@Param("page")Integer page, @Param("pageSize")Integer pageSize, @Param("a") ParameUtil param);

    void didanxin(Order o);


    void xiangqing(Details s);

    List<Order> xiang1(@Param("page")Integer page,  @Param("pageSize")Integer pageSize,  @Param("id")Integer id);

    List<Comment> shu(Integer id);


    void huifu(Comment c);

    void wubai(Integer uid);

    void yiqian(Integer uid);

    void wuqian(Integer uid);

    Integer mszong(ParameUtil param);

    List<Seckill> miaoshacha(@Param("page")Integer page, @Param("pageSize")Integer pageSize);


    Seckill chaseckill(Integer id);

    void update(Seckill s);
}
