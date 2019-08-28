package com.jk.service;

import com.jk.model.Emp;
import com.jk.model.Menu;
import com.jk.model.Role;
import com.jk.util.ParameUtil;

import java.util.HashMap;
import java.util.List;

/**
 * @author ： 安雅茹
 * @date ：Created in 2019-08-21 14:10
 * @description：
 * @package ：com.jk.service
 * @version:
 */
public class EmpServiceImpl implements  EmpService {

    @Override
    public Emp queryUserName(String username) {
        return null;
    }

    @Override
    public List<Menu> getTreeAll(Integer id) {
        return null;
    }

    @Override
    public String checkName(String userName) {
        return null;
    }

    @Override
    public String register(Emp emp) {
        return null;
    }

    @Override
    public String updateEmp(Emp emp) {
        return null;
    }

    @Override
    public HashMap<String, Object> queryEmp(ParameUtil pu) {
        return null;
    }

    @Override
    public void updateEmpStatus(Integer id) {

    }

    @Override
    public HashMap<String, Object> queryEmpLog(ParameUtil pu) {
        return null;
    }

    @Override
    public List<Role> setDep(Integer id) {
        return null;
    }

    @Override
    public List<Integer> queryRoleById(Integer id) {
        return null;
    }

    @Override
    public List<Role> queryRole() {
        return null;
    }

    @Override
    public void updatero(Integer uid, Integer rid) {

    }

    @Override
    public HashMap<String, Object> queryRoleAll(ParameUtil parameUtil) {
        return null;
    }

    @Override
    public List<Menu> queryMenuByRid(Integer id, Integer pid) {
        return null;
    }

    @Override
    public void updateMenu(Integer[] ids, Integer roleid) {

    }
}

