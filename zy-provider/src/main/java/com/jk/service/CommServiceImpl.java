package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jk.dao.CommDao;
import com.jk.model.Details;
import com.jk.model.Order;
import com.jk.model.Refund;
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
    public PageUtil cha(ParameUtil params) {
        PageHelper.startPage(params.getPageNumber(),params.getPageSize());
        List<Order> list=da.cha(params);
        PageInfo<Order> pa=new PageInfo<>(list);
        PageUtil page=new PageUtil((int) pa.getTotal(),params.getPageNumber(),params.getPageSize());
         page.setList(list);
        return page;
    }

    @Override
    public PageUtil dai(ParameUtil param) {
        PageHelper.startPage(param.getPageNumber(),param.getPageSize());
        List<Order> list=da.dai(param);
        PageInfo<Order> pa=new PageInfo<>(list);
        PageUtil page=new PageUtil((int) pa.getTotal(),param.getPageNumber(),param.getPageSize());
        page.setList(list);
        return page;
    }

    @Override
    public PageUtil fa(ParameUtil param) {
        PageHelper.startPage(param.getPageNumber(),param.getPageSize());
        List<Order> list=da.fa(param);
        PageInfo<Order> pa=new PageInfo<>(list);
        PageUtil page=new PageUtil((int) pa.getTotal(),param.getPageNumber(),param.getPageSize());
        page.setList(list);
        return page;
    }

    @Override
    public PageUtil yi(ParameUtil param) {
        PageHelper.startPage(param.getPageNumber(),param.getPageSize());
        List<Order> list=da.yi(param);
        PageInfo<Order> pa=new PageInfo<>(list);
        PageUtil page=new PageUtil((int) pa.getTotal(),param.getPageNumber(),param.getPageSize());
        page.setList(list);
        return page;
    }

    @Override
    public PageUtil wan(ParameUtil param) {
        PageHelper.startPage(param.getPageNumber(),param.getPageSize());
        List<Order> list=da.wan(param);
        PageInfo<Order> pa=new PageInfo<>(list);
        PageUtil page=new PageUtil((int) pa.getTotal(),param.getPageNumber(),param.getPageSize());
        page.setList(list);
        return page;
    }

    @Override
    public PageUtil guan(ParameUtil param) {
        PageHelper.startPage(param.getPageNumber(),param.getPageSize());
        List<Order> list=da.guan(param);
        PageInfo<Order> pa=new PageInfo<>(list);
        PageUtil page=new PageUtil((int) pa.getTotal(),param.getPageNumber(),param.getPageSize());
        page.setList(list);
        return page;
    }

    @Override
    public PageUtil tui(ParameUtil param) {
        PageHelper.startPage(param.getPageNumber(),param.getPageSize());
        List<Order> list=da.tui(param);
        PageInfo<Order> pa=new PageInfo<>(list);
        PageUtil page=new PageUtil((int) pa.getTotal(),param.getPageNumber(),param.getPageSize());
        page.setList(list);
        return page;
    }



    @Override
    public PageUtil kuan(ParameUtil parame) {
        PageHelper.startPage(parame.getPageNumber(),parame.getPageSize());
        List<Refund> list=da.kuan(parame);
        PageInfo<Refund> pa=new PageInfo<>(list);
        PageUtil page=new PageUtil((int) pa.getTotal(),parame.getPageNumber(),parame.getPageSize());
        page.setList(list);
        return page;
    }

    @Override
    public List<Details> xiang(Integer id) {
        return da.xiang(id);
    }


}
