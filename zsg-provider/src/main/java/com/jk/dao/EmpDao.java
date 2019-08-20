package com.jk.dao;


import com.alibaba.dubbo.config.annotation.Service;
import com.jk.model.Emp;
import com.jk.model.Menu;
import com.jk.model.Role;
import com.jk.model.Rolemenu;
import com.jk.util.ParameUtil;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

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

    @Select("select rid from userrole where uid=#{id}")
    List<Integer> queryRoleById(Integer id);

    @Select("select * from role")
    List<Role> queryAllRole();


    @Delete("delete  from userrole where uid=#{uid}")
    void deleteRole(Integer uid);

    @Insert("insert into userrole(uid,rid) values(#{uid},#{rid})")
    void updateRole(Map<String,Object> map);

    @Select("select count(*) from role")
    Integer queryRoleTotal();

    @Select("select * from role limit #{pageNumber},#{pageSize}")
    List<Role> queryListRole(ParameUtil parameUtil);

    @Select("select * from menu where pid=#{pid}")
    List<Menu> queryMenuAll(int pid);

    @Select("select * from menu m,rolemenu rm where m.id=rm.mid and rm.rid=#{id} and m.pid=#{pid}")
    List<Menu> queryMenuAllById(Map<String,Object> map);

    @Delete("delete from rolemenu where rid=#{roleid}")
    void deleteRoleMenu(Integer roleid);

    @Insert("insert into rolemenu(rid,mid) values(#{rid},#{mid})")
    void addRoleMenu(Rolemenu rm);
}
