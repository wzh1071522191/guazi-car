package com.jk.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import com.jk.dao.EmpDao;
import com.jk.model.*;
import com.jk.util.ParameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public Emp queryUserName(String username) {
        Emp st=empDao.queryUserName(username);
        return st;
    }

    @Override
    public List<Menu> getTreeAll(Integer id) {
        return empDao.getTreeAll(id);
    }

    @Override
    public String checkName(String username) {
        Emp st=empDao.queryUserName(username);
        if (st!=null){
            return "1";
        }else {
            return "0";
        }

    }

    @Override
    public String register(Emp emp) {
        Emp st=empDao.queryUserName(emp.getUserName());
        if (st==null){
            emp.setUserStatus(0);
            empDao.register(emp);
            return "0";
        }else {
            return "1";
        }

    }

    @Override
    public String updateEmp(Emp emp) {
        Emp st=empDao.queryUserName(emp.getUserName());
        if(st!=null){
            empDao.updateEmp(emp);
            return "0";
        }else {
            return "1";
        }

    }

    /**
     * @author :张松光
     * @method : queryEmp
     * @description : 描述一下方法的作用
     * @date: 2019/8/18 9:13
     * @param: [pu]
     * @return java.util.HashMap<java.lang.String,java.lang.Object>
     */
    @Override
    public HashMap<String, Object> queryEmp(ParameUtil pu) {
        Integer total=empDao.queryEmpCount();
        Integer page = pu.getPageNumber();
        pu.setPageNumber((page-1)*pu.getPageSize());
        List<Emp> queryList = empDao.queryEmpList(pu);
        HashMap<String,Object> hashMap =new HashMap<String,Object>();
        hashMap.put("total",total);
        hashMap.put("rows",queryList);
        return hashMap;

    }

    @Override
    public void updateEmpStatus(Integer id) {
        empDao.updateEmpStatus(id);
    }

    @Override
    public HashMap<String, Object> queryEmpLog(ParameUtil pu) {
        Criteria c = new Criteria();
        Query query=new Query();
        if (pu.getName() != null&&!"".equals(pu.getName())) {
            c.and("userName").is(pu.getName());
        }
        //两者都不为空
        if (pu.getStarDate() != null&&pu.getEndDate()!=null) {
            c.and("logtime").gte(pu.getStarDate()).lte(pu.getEndDate());
        }
        //结束时间为空，开始不空
        if (pu.getStarDate() != null&&pu.getEndDate()==null) {
            c.and("logtime").gte(pu.getStarDate());
        }
        //开始为空，结束不空
        if (pu.getStarDate() == null&&pu.getEndDate()!=null) {
            c.and("logtime").lte(pu.getEndDate());
        }
        query.addCriteria(c);
        Integer total=(int) mongoTemplate.count(query, LogBean.class, "log");

        query.skip((pu.getPageNumber()-1)*pu.getPageSize());
        query.limit(pu.getPageSize());
        query.with(new Sort(Sort.Direction.DESC, "logtime"));
        List<LogBean> find = mongoTemplate.find(query, LogBean.class, "log");
        HashMap<String, Object> hashMap=new HashMap<String, Object>();
        hashMap.put("total", total);
        hashMap.put("rows", find);
        return hashMap;
    }

    @Override
    public List<Role> setDep(Integer id) {
        List<Integer> queryId=empDao.queryRoleById(id);
        List<Role> queryAllRole=empDao.queryAllRole();
        for (int i = 0; i < queryId.size(); i++) {
            for (int j = 0; j < queryAllRole.size(); j++) {
                if (queryAllRole.get(j).getId()==queryId.get(i)) {
                    queryAllRole.get(j).setChecked("true");
                }
            }
        }
        return queryAllRole;
    }

    @Override
    public List<Integer> queryRoleById(Integer id) {

        return empDao.queryRoleById(id);
    }

    @Override
    public List<Role> queryRole() {

        return empDao.queryAllRole();
    }

    @Override
    public void updatero( Integer uid,Integer rid) {
        empDao.deleteRole(uid);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("uid",uid);
        map.put("rid",rid);
        empDao.updateRole(map);


    }

    @Override
    public HashMap<String, Object> queryRoleAll(ParameUtil parameUtil) {
        Integer total=empDao.queryRoleTotal();
        Integer page = parameUtil.getPageNumber();
        parameUtil.setPageNumber((page-1)*parameUtil.getPageSize());
        List<Role> queryList=empDao.queryListRole(parameUtil);
        HashMap<String, Object> hashMap =new HashMap<String, Object>();
        hashMap.put("total",total);
        hashMap.put("rows", queryList);
        return hashMap;
    }

    @Override
    public List<Menu> queryMenuByRid(Integer id,Integer pid) {
        JSONObject json =new JSONObject();
        List <Menu> list =queryOrgAll3(pid);
        List <Menu> list2= queryOrgAll2(id,pid);
        Map map=new HashMap();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if(list.get(i).getId()==list2.get(j).getId()){
                    list.get(i).getId();
                    json.put("checked", true);
                    list.get(i).setState(json);
                }
            }
            if(list.size()>0){
                for (int s = 0; s < list.size(); s++) {
                    List<Menu>list3=queryMenuByRid(id,list.get(s).getId());
                    list.get(s).setNodes(list3);
                }
            }
        }
        return list;

    }



    public List<Menu> queryOrgAll3(int pid) {
        // 根据pid查询子节点
        List<Menu> menu = empDao.queryMenuAll(pid);
        // 如果查询到子节点集合
        if(menu != null && menu.size()>0){
            // 循环集合，将每个机构对象的id作为pid 继续查询子节点集合
            for (int i = 0; i < menu.size(); i++) {
                List<Menu> orgs2 = queryOrgAll3(menu.get(i).getId());
                // 将查询的子节点集合放到该结构对象的children属性中
                menu.get(i).setNodes(orgs2);
            }
        }
        return menu;
    }

    public List<Menu> queryOrgAll2(int id, int pid) {
        // 根据pid查询子节点
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("id",id);
        map.put("pid",pid);
        List<Menu> orgs = empDao.queryMenuAllById(map);
        // 如果查询到子节点集合
        if(orgs != null && orgs.size()>0){
            // 循环集合，将每个机构对象的id作为pid 继续查询子节点集合
            for (int i = 0; i < orgs.size(); i++) {
                List<Menu> orgs2 = queryOrgAll2(id,orgs.get(i).getId());
                // 将查询的子节点集合放到该结构对象的children属性中
                orgs.get(i).setNodes(orgs2);
            }
        }
        return orgs;
    }

    @Override
    public void updateMenu(Integer[] ids, Integer roleid) {
        empDao.deleteRoleMenu(roleid);
        for (int i = 0; i <ids.length ; i++) {
            Rolemenu rm=new Rolemenu();
            rm.setMid(ids[i]);
            rm.setRid(roleid);
            empDao.addRoleMenu(rm);
        }
    }
}
