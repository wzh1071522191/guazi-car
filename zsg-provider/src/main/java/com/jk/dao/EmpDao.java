package com.jk.dao;


import com.jk.model.Emp;
import com.jk.model.Menu;
import com.jk.util.ParameUtil;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface EmpDao {



    Emp queryUserName(String username);

    List<Menu> getTreeAll(Integer id);

    void register(Emp emp);

    @Update("UPDATE t_str s SET s.username=#{userName} ,s.userpwd=#{userPwd} , s.userStatus=2 WHERE s.username=#{userName}")
    void updateEmp(Emp emp);

   // @Select("select count(*) from t_str")
    Integer queryEmpCount();

   // @Select("select * from t_str limit #{pageNumber},#{pageSize}")
    List<Emp> queryEmpList(ParameUtil pu);

    @Update("UPDATE t_str s SET  s.userStatus=0 WHERE s.id=#{id}")
    void updateEmpStatus(Integer id);
}
