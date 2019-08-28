package com.jk.service;

import com.jk.model.RoundImg;
import com.jk.util.ParameUtil;

import java.util.List;
import java.util.Map;

/**
 * @author ： 安雅茹
 * @date ：Created in 2019-08-20 20:18
 * @description：
 * @package ：com.jk.service
 * @version:
 */
public interface ImgService {

  //  Map queryImg(Integer page, Integer rows);

    void addImg(RoundImg roundimg);

    void addLbShow(String lbid);

    List<RoundImg> ShowNowLb();

    Map queryImgList(ParameUtil parm);

    void delImg(String lbid);
}
