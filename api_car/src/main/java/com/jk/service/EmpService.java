package com.jk.service;

import com.jk.model.Emp;
import com.jk.model.Menu;

import java.util.List;

public interface EmpService {
    Emp queryUserName(String username);

    List<Menu> getTreeAll(Integer id);

    String checkName(String userName);

    String register(Emp emp);

    String updateEmp(Emp emp);


}
