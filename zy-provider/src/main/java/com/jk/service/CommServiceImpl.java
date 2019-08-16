package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jk.dao.CommDao;
import com.jk.model.Order;
import com.jk.util.PageUtil;
import com.jk.util.ParameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.List;

@Service
@Component
public class CommServiceImpl implements CommService {
    @Autowired
    private CommDao da;

    @Override
    public PageUtil cha(ParameUtil param) {
        PageHelper.startPage(param.getPageNumber(),param.getPageSize());
        List<Order> list=da.cha(param);
        PageInfo<Order> pa=new PageInfo<>(list);
        PageUtil page=new PageUtil((int) pa.getTotal(),param.getPageNumber(),param.getPageSize());
         page.setList(list);
        return page;
    }
}
