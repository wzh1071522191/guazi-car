package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.dao.AreaMapper;
import com.jk.model.Area;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author ： 安雅茹
 * @date ：Created in 2019-08-20 15:04
 * @description：
 * @package ：com.jk.service
 * @version:
 */
@Service
public class AreaServiceImpl implements  AreaService{
@Autowired
    private AreaMapper areamapper;

    @Override
    public List<Area> querySheng() {
        return areamapper.querySheng();
    }

    @Override
    public List<Area> queryShi(Integer pid) {
        return areamapper.queryShi(pid);
    }
}

