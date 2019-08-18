package com.jk.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Emp;
import com.jk.model.Menu;
import com.jk.service.EmpService;
import com.jk.util.ParameUtil;
import com.jk.util.TreeNoteUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;


/**
 * @author ： 张松光
 * @date ：Created in 2019/8/15 20:14
 * @description：后台管理控制层,员工
 * @package ：
 * @version: 1.0
 */
@Controller
@RequestMapping("emp")
public class EmpController {

    @Reference(version = "1.0")
    private EmpService empService;

    @Autowired
    private RedisTemplate redisTemplate;

    //跳转员工登录页面
    @RequestMapping("toEmpLogin")
    public String toEmpLogin(){
        return "empLogin";
    }

    //验证登录
    @RequestMapping("loginUser")
    @ResponseBody
    public Integer loginUser(Emp emp, HttpServletRequest request) {
        Emp loginUser=empService.queryUserName(emp.getUserName());

        if (loginUser==null) {
            return 3;
        }
        if(loginUser.getUserStatus()!=0){
            return 4;
        }

       /* String key = "lockuser"+loginUser.getUserName();
        if (redisTemplate.hasKey(key)) {
            String str = (String) redisTemplate.opsForValue().get(key);
            int count =Integer.parseInt(str);
            if (count==3) {
                return 0;
            }
        }*/
        if (!loginUser.getUserPwd().equals(emp.getUserPwd())) {
            /*if (!redisTemplate.hasKey(key)) {
                redisTemplate.opsForValue().set(key, "1");
                redisTemplate.expire(key, 5, TimeUnit.MINUTES);
            }else {
                Long inc = redisTemplate.opsForValue().increment(key, 1);
                if (inc==3) {
                    redisTemplate.expire(key, 5, TimeUnit.MINUTES);
                }
            }*/
            return 1;
        }
        //redisTemplate.delete(key);
        request.getSession().setAttribute("u", loginUser);
        return 2;
    }

    //树 页面
    @RequestMapping("toTreePage")
    public String toTreePage(){
        return "tree";
    }

    //根据登录用户查权限树
    @RequestMapping("getAllTree")
    @ResponseBody
    public List<Menu> getAllTree(HttpServletRequest request){
        Emp user = (Emp) request.getSession().getAttribute("u");

        List<Menu> list = empService.getTreeAll(user.getId());
        list = TreeNoteUtil.getFatherNode(list);
        return list;
    }

    //用户页面
    @RequestMapping("toEmp")
    public String toEmp(){
        return "emp";
    }



    //跳转注册页面
    @RequestMapping("toRegistery")
    public String toRegistery(){
        return "empRegistery";
    }

    //注册验重
    @RequestMapping("checkName")
    @ResponseBody
    public String checkName(String userName){
        return empService.checkName(userName);
    }
    //注册，新增
    @RequestMapping("register")
    @ResponseBody
    public String register(Emp emp){
       return empService.register(emp);
    }
    //跳转修改登录信息页面
    @RequestMapping("toUpdate")
    public String toUpdate(){
        return "updateEmp";
    }
    //修改
    @RequestMapping("updateEmp")
    @ResponseBody
    public String updateEmp(Emp emp){
        return empService.updateEmp(emp);
    }

    /**
     * @author :张松光
     * @method : queryEmp
     * @description : 查询登录用户(员工),分页展示
     * @date: 2019/8/18 9:02
     * @param: [pu]
     * @return java.util.HashMap<java.lang.String,java.lang.Object>
     */
    @RequestMapping("queryEmp")
    @ResponseBody
    public HashMap<String,Object>  queryEmp(@RequestBody ParameUtil pu){

        return empService.queryEmp(pu);
    }

    /**
     * @author :张松光
     * @method : updateEmpStatus
     * @description : 修改审核状态
     * @date: 2019/8/18 10:45
     * @param: [id]
     * @return void
     */
    @RequestMapping("updateEmpStatus")
    @ResponseBody
    public void updateEmpStatus(Integer id){
        empService.updateEmpStatus(id);

    }




}
