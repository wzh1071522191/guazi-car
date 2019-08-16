package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Emp;
import com.jk.model.Menu;
import com.jk.service.EmpService;
import com.jk.util.TreeNoteUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping("toEmpLogin")
    public String toEmpLogin(){
        return "empLogin";
    }

    @RequestMapping("loginUser")
    @ResponseBody
    public Integer loginUser(Emp emp, HttpServletRequest request) {
        Emp loginUser=empService.queryUserName(emp.getUserName());
        if (loginUser==null) {
            return 3;
        }

        /*String key = "lockuser"+loginUser.getName();
        if (redisTemplate.hasKey(key)) {
            String str = redisTemplate.opsForValue().get(key);
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

    @RequestMapping("toTreePage")
    public String toTreePage(){
        return "tree";
    }

    @RequestMapping("getAllTree")
    @ResponseBody
    public List<Menu> getAllTree(HttpServletRequest request){
        Emp user = (Emp) request.getSession().getAttribute("u");

        List<Menu> list = empService.getTreeAll(user.getId());
        list = TreeNoteUtil.getFatherNode(list);
        return list;
    }

    @RequestMapping("toEmp")
    public String toEmp(){
        return "emp";
    }

    @RequestMapping("toRegistery")
    public String toRegistery(){
        return "empRegistery";
    }

    @RequestMapping("checkName")
    @ResponseBody
    public String checkName(String userName){
        return empService.checkName(userName);
    }

    @RequestMapping("register")
    @ResponseBody
    public String register(Emp emp){
       return empService.register(emp);
    }

    @RequestMapping("toUpdate")
    public String toUpdate(){
        return "updateEmp";
    }

    @RequestMapping("updateEmp")
    @ResponseBody
    public String updateEmp(Emp emp){
        return empService.updateEmp(emp);
    }


}
