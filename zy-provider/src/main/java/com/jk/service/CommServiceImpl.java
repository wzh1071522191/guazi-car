package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jk.dao.CommDao;
import com.jk.model.Comment;
import com.jk.model.Details;
import com.jk.model.Order;
import com.jk.model.Refund;
import com.jk.util.PageUtil;
import com.jk.util.ParameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Component
public class CommServiceImpl implements CommService {
  @Autowired
    private CommDao da;

    @Override
    public Map cha(ParameUtil params) {
   /*     SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
        s.format(params.getQian());
        s.format(params.getHo());*/
       Integer count=da.czong(params);
            Integer page=(params.getPageNumber()-1)*params.getPageSize();
        List<Order> list=da.cha(page,params.getPageSize(),params);
           Map ma=new HashMap();
           ma.put("total",count);
           ma.put("rows",list);
    return ma;
    }

    @Override
    public Map dai(ParameUtil param) {
        Integer count=da.dzong(param);
        Integer page=(param.getPageNumber()-1)*param.getPageSize();
        List<Order> list=da.dai(page,param.getPageSize(),param);
        Map ma=new HashMap();
        ma.put("total",count);
        ma.put("rows",list);
        return ma;
    }

    @Override
    public Map fa(ParameUtil param) {
        Integer count=da.fzong(param);
        Integer page=(param.getPageNumber()-1)*param.getPageSize();
        List<Order> list=da.fa(page,param.getPageSize(),param);
        Map ma=new HashMap();
        ma.put("total",count);
        ma.put("rows",list);
        return ma;
    }

    @Override
    public Map yi(ParameUtil param) {
        Integer count=da.yzong(param);
        Integer page=(param.getPageNumber()-1)*param.getPageSize();
        List<Order> list=da.yi(page,param.getPageSize(),param);
        Map ma=new HashMap();
        ma.put("total",count);
        ma.put("rows",list);
        return ma;
    }

    @Override
    public Map wan(ParameUtil param) {
        Integer count=da.wzong(param);
        Integer page=(param.getPageNumber()-1)*param.getPageSize();
        List<Order> list=da.wan(page,param.getPageSize(),param);
        Map ma=new HashMap();
        ma.put("total",count);
        ma.put("rows",list);
        return ma;
    }

    @Override
    public Map guan(ParameUtil param) {
        Integer count=da.gzong(param);
        Integer page=(param.getPageNumber()-1)*param.getPageSize();
        List<Order> list=da.guan(page,param.getPageSize(),param);
        Map ma=new HashMap();
        ma.put("total",count);
        ma.put("rows",list);
        return ma;
    }

    @Override
    public Map tui(ParameUtil param) {
        Integer count=da.tzong(param);
        Integer page=(param.getPageNumber()-1)*param.getPageSize();
        List<Order> list=da.tui(page,param.getPageSize(),param);
        Map ma=new HashMap();
        ma.put("total",count);
        ma.put("rows",list);
        return ma;
    }



    @Override
    public Map kuan(ParameUtil parame) {
        Integer count=da.kzong(parame);
        Integer page=(parame.getPageNumber()-1)*parame.getPageSize();
        List<Refund> list=da.kuan(page,parame.getPageSize(),parame);
        Map ma=new HashMap();
        ma.put("total",count);
        ma.put("rows",list);
        return ma;
    }

    @Override
    public void tong(Integer sum, Integer id) {
         if (sum==1){
              da.tong(id);
         }else{
           da.jj(id);
         }
    }

    @Override
    public Map ping(ParameUtil param) {
        Integer count=da.pzong(param);
        Integer page=(param.getPageNumber()-1)*param.getPageSize();
        List<Comment> list=da.ping(page,param.getPageSize(),param);
        Map ma=new HashMap();
        ma.put("total",count);
        ma.put("rows",list);
        return ma;
    }

    @Override
    public void dindanxin(Order o,String color) {
       Details s=new Details();
       s.setKuaidifei(30);
       s.setGuige(color);
       s.setSpprice(1200);
       s.setYuhui(200);
        da.xiangqing(s);
        System.err.println(s.getId());
  /*      o.setDataid(d.getId());*/
         da.didanxin(o);

    }


    @Override
    public List<Details> xiang(Integer id) {
        return da.xiang(id);
    }


}