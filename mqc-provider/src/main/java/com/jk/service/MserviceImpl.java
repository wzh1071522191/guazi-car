package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jk.dao.Mdao;


import com.jk.model.*;
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


        Integer sum=mdao.sumcount(parm);
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
        int sum=mdao.sumcount2(parm);
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
        int sum=mdao.sumcount12(parm);
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

    @Override
    public Map querymaiche(ParameUtil parm) {
        int sum=mdao.sumcountmc(parm);
        Integer page=parm.getPageNumber();
        parm.setPageNumber((page-1)*parm.getPageSize());

        List<Audit> list=mdao.chamaiche(parm);
        Map<String,Object>map=new HashMap<>();
        map.put("rows",list);
        map.put("total",sum);
        return map;
    }

    @Override
    public Audit querymai(Integer id) {
        Audit a=  mdao.querymai(id);
        return  a;
    }

    @Override
    public void addxianxia(Audit a, String dd) {
        Integer aa=a.getId();
          Map map=new HashMap();
          map.put("aa",aa);
          map.put("dd",dd);
        mdao.addxianxia(map);
    }

    @Override
        public void addaudit(Car a) {

        mdao.addaudit(a);
    }

    @Override
    public void addyes(Integer id) {
        mdao.addyes(id);
    }

    @Override
    public void addno(Integer id) {
        mdao.addno(id);
    }

    @Override
    public Map querykk(ParameUtil parm) {
        int sum=mdao.querykhcon(parm);
        Integer page=parm.getPageNumber();
        parm.setPageNumber((page-1)*parm.getPageSize());

        List<User> list=mdao.queryuser(parm);
        Map<String,Object>map=new HashMap<>();
        map.put("rows",list);
        map.put("total",sum);
        return map;
    }

    @Override
    public void cv(Integer id) {
        mdao.dsa(id);
    }

    @Override
    public Map queryhei(ParameUtil parm) {
        int sum=mdao.querykhcon2(parm);
        Integer page=parm.getPageNumber();
        parm.setPageNumber((page-1)*parm.getPageSize());

        List<User> list=mdao.queryhei(parm);
        Map<String,Object>map=new HashMap<>();
        map.put("rows",list);
        map.put("total",sum);
        return map;
    }

    @Override
    public void huifu(Integer id) {
        mdao.huifu(id);
    }

    @Override
    public Map jm(ParameUtil parm) {
        int sum=mdao.qu(parm);
        Integer page=parm.getPageNumber();
        parm.setPageNumber((page-1)*parm.getPageSize());

        List<jiameng> list=mdao.jm(parm);
        Map<String,Object>map=new HashMap<>();
        map.put("rows",list);
        map.put("total",sum);
        return map;
    }

    @Override
    public void sh(Integer id) {
        mdao.sh(id);
    }

    @Override
    public void sh2(Integer id) {
        mdao.sh2(id);
    }

    @Override
    public void addjm(jiameng jm) {
        mdao.addjm(jm);
    }


}
