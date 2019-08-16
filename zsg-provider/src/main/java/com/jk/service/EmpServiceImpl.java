package com.jk.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.jk.dao.EmpDao;
import com.jk.model.Emp;
import com.jk.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ： 张松光
 * @date ：Created in 2019/8/15 19:05
 * @description：
 * @package ：
 * @version: 1.0.0
 */
@Service(version = "1.0")
@Component
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDao empDao;


    @Override
    public Emp queryUserName(String username) {
        Emp st=empDao.queryUserName(username);
        return st;
    }

    @Override
    public List<Menu> getTreeAll(Integer id) {
        return empDao.getTreeAll(id);
    }

    @Override
    public String checkName(String username) {
        Emp st=empDao.queryUserName(username);
        if (st!=null){
            return "1";
        }else {
            return "0";
        }

    }

    @Override
    public String register(Emp emp) {
        Emp st=empDao.queryUserName(emp.getUserName());
        if (st==null){
            emp.setUserStatus(0);
            empDao.register(emp);
            return "0";
        }else {
            return "1";
        }

    }

    @Override
    public String updateEmp(Emp emp) {
        Emp st=empDao.queryUserName(emp.getUserName());
        if(st!=null){
            empDao.updateEmp(emp);
            return "0";
        }else {
            return "1";
        }

    }
}
