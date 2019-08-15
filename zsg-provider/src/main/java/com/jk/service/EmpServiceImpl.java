package com.jk.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.jk.dao.EmpDao;
import com.jk.model.Strator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    public Strator queryUserName(String username) {
        Strator st=empDao.queryUserName(username);
        return st;
    }
}
