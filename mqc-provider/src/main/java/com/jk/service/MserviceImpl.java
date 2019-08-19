package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jk.dao.Mdao;


import com.jk.model.Car;
import com.jk.model.CarType;
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


       int sum=mdao.sumcount();
        Integer page=parm.getPageNumber();
        parm.setPageNumber((page-1)*parm.getPageSize());

        List<Car> list=mdao.querycar(parm);
        Map<String,Object>list2=new HashMap<>();
        list2.put("rows",list);
        list2.put("total",sum);
        return list2;
    }

    @Override
    public List<CarType> querytype() {


        return mdao.querytye();
    }

    @Override
    public void deleteUser(String ids) {
        String[] split = ids.split(",");
        for (String id:split) {
            mdao.deleteUser(id);
        }


    }

    @Override
    public Map querycartype(ParameUtil parm) {
        int sum=mdao.sumcount2();
        String name = parm.getTypename();
        parm.setTypename("%"+(name)+"%");
        Integer page=parm.getPageNumber();
        parm.setPageNumber((page-1)*parm.getPageSize());

        List<CarType> list=mdao.querycartype(parm);
        Map<String,Object>map=new HashMap<>();
        map.put("rows",list);
        map.put("total",sum);
        return map;
    }

    @Override
    public void upx(Integer id) {
        mdao.upx(id);
    }

    @Override
    public Map querycar2(ParameUtil parm) {
        int sum=mdao.sumcount12();
        Integer page=parm.getPageNumber();
        parm.setPageNumber((page-1)*parm.getPageSize());

        List<Car> list=mdao.querycar2(parm);
        Map<String,Object>map=new HashMap<>();
        map.put("rows",list);
        map.put("total",sum);
        return map;
    }

    @Override
    public void addcar(Car c) {
        mdao.addcar(c);
    }

    @Override
    public void ups(Integer id) {
        mdao.ups(id);
    }

    @Override
    public Car toup(Integer id) {

        return mdao.toup(id);
    }

    @Override
    public void upcar(Car c) {
        mdao.upcar(c);
    }

    @Override
    public void deleteUser2(String ids) {
        String[] split = ids.split(",");
        for (String id:split) {
            mdao.deleteUser2(id);
        }
    }


}
