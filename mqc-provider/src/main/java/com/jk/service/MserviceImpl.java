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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(version="1.0")
@Component
public class MserviceImpl implements Mservice {

    @Autowired
    private Mdao mdao;


    @Override
    public Map querycar(ParameUtil parm) {


       Integer sum=mdao.sumcount();
        Integer page=parm.getPageNumber();
        parm.setPageNumber((page-1)*parm.getPageSize());

        List<Car> list=mdao.querycar(parm);
        Map<String,Object>list2=new HashMap<>();
        list2.put("rows",list);
        list2.put("total",sum);
        return list2;
    }
}
