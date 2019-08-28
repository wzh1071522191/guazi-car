package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.dao.UserMapper;
import com.jk.model.User;
import org.springframework.beans.factory.annotation.Autowired;

@Service(version = "1.0")
public class UserServiceImpl implements  UserService{
    @Autowired
    private UserMapper userMapper;


    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public User queryLoginPhone(String phone) {
        System.out.println("userservice================"+phone);
        return userMapper.queryLoginPhone(phone);
    }


/**
 * Copyright (C), 2015-2019, jk
 * FileName: UserServiceImpl
 * Author:   Lemovo
 * Date:     2019-08-15 11:53
 * Description: 
 * History:
 * <author>          <time>          <version>          <desc>
 * 安安          修改时间           版本号              描述
 */
}

