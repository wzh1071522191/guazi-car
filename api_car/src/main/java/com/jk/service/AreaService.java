package com.jk.service;

import com.jk.model.Area;

import java.util.List;

/**
 * @author ： 安雅茹
 * @date ：Created in 2019-08-20 15:03
 * @description：
 * @package ：com.jk.service
 * @version:
 */
public interface AreaService {

    List<Area> querySheng();

    List<Area> queryShi(Integer pid);
}
