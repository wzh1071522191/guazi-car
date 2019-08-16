package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jk.dao.Mdao;


import com.jk.model.Car;
import com.jk.util.PageUtil;
import com.jk.util.ParameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Service(version="1.0")
@Component
public class MserviceImpl implements Mservice {

    @Autowired
    private Mdao mdao;


    @Override
    public PageUtil querycar(ParameUtil parm) {
        PageHelper.startPage(parm.getPageNumber(), parm.getPageSize());
        List<Car> list= mdao.querycar(parm);
        PageInfo<Car> pageInfo = new PageInfo<>(list);
        PageUtil page= new PageUtil((int)pageInfo.getTotal(),parm.getPageNumber(), parm.getPageSize());
        page.setList(list);
        return page;
    }
}
