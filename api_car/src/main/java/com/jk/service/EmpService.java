package com.jk.service;

import com.jk.model.Emp;

import com.jk.model.Menu;
import com.jk.model.Role;
import com.jk.util.ParameUtil;


import java.util.HashMap;
import java.util.List;

public interface EmpService {
    Emp queryUserName(String username);

    List<Menu> getTreeAll(Integer id);

    String checkName(String userName);

    String register(Emp emp);

    String updateEmp(Emp emp);


    HashMap<String, Object> queryEmp(ParameUtil pu);

    void updateEmpStatus(Integer id);

    HashMap<String, Object> queryEmpLog(ParameUtil pu);

    List<Role> setDep(Integer id);

    List<Integer> queryRoleById(Integer id);

    List<Role> queryRole();

    void updatero(Integer uid, Integer rid);

    HashMap<String, Object> queryRoleAll(ParameUtil parameUtil);

    List<Menu> queryMenuByRid(Integer id, Integer pid);

    void updateMenu(Integer[] ids, Integer roleid);
}
