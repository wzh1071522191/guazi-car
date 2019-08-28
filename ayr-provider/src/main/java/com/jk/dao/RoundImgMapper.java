package com.jk.dao;

import com.jk.model.RoundImg;
import com.jk.util.ParameUtil;
import org.apache.ibatis.annotations.Param;

import java.awt.print.Book;
import java.util.List;

public interface RoundImgMapper {
    int deleteByPrimaryKey(Integer imgid);

    int insert(RoundImg record);

    int insertSelective(RoundImg record);

    RoundImg selectByPrimaryKey(Integer imgid);

    int updateByPrimaryKeySelective(RoundImg record);

    int updateByPrimaryKey(RoundImg record);

    long queryCount();

    List<RoundImg> queryList(@Param("stat") Integer stat, @Param("rows") Integer rows);

    void addImg(RoundImg roundimg);

    void addLbShow(@Param("lbid") String lbid);

    List<RoundImg> ShowNowLb();

    List<RoundImg> queryList1(@Param("stat") int stat, @Param("rows") Integer pageSize, @Param("parm") ParameUtil parm);

    void delImg(@Param("lbid") String lbid);
}