package com.jk.dao;


import com.jk.model.Emp;
import com.jk.model.Menu;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface EmpDao {



    Emp queryUserName(String username);

    List<Menu> getTreeAll(Integer id);

    void register(Emp emp);

    @Update("UPDATE t_str s SET s.username=#{userName} ,s.userpwd=#{userPwd} , s.userStatus=2 WHERE s.username=#{userName}")
    void updateEmp(Emp emp);
}
