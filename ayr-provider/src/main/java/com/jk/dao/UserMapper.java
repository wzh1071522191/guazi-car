package com.jk.dao;

import com.jk.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer
                                    userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User queryPhone(String phone);

    void addUser(User user);
}