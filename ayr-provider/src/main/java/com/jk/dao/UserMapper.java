package com.jk.dao;

import com.jk.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer
                                   userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer
                                    userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User queryLoginPhone(@Param("phone")String phone);

    void addUser(User user);




}