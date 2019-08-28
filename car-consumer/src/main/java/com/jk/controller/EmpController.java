package com.jk.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Emp;
import com.jk.model.Menu;
import com.jk.model.Role;
import com.jk.service.EmpService;
import com.jk.util.ParameUtil;
import com.jk.util.TreeNoteUtil;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;


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
    private AmqpTemplate amqpTemplate;

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
        List<Menu> listTree=new ArrayList<Menu>();
        String key ="treeAll"+user.getId();
        if (redisTemplate.hasKey(key)) {
            listTree=(List<Menu>) redisTemplate.opsForValue().get(key);
            System.out.println("缓存");
        }else {
            listTree=empService.getTreeAll(user.getId());
            listTree = TreeNoteUtil.getFatherNode(listTree);
            redisTemplate.opsForValue().set(key, listTree);
            redisTemplate.expire(key, 1, TimeUnit.MINUTES);
            System.out.println("数据库");
        }
        return listTree;
       /* List<Menu> list = empService.getTreeAll(user.getId());
        list = TreeNoteUtil.getFatherNode(list);
        return list;*/
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
    //RabbitListener
    @RequestMapping("register")
    @ResponseBody
    public void register(Emp emp){
       //return empService.register(emp);
        amqpTemplate.convertAndSend("Rabbitmq",emp);
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

    @RequestMapping("toEmpLog")
    public String toEmpLog(){
        return "empLog";
    }
    @RequestMapping("queryEmpLog")
    @ResponseBody
    public HashMap<String,Object>  queryEmpLog(@RequestBody ParameUtil pu){
        return empService.queryEmpLog(pu);
    }

    /*@RequestMapping("setDep")
    @ResponseBody
    public  List<Role>  setDep(Integer id){
        List<Role> list = empService.setDep(id);
        return list;
    }*/

    @RequestMapping("setRole")
    public String  setRole(Integer id, Model model, HttpServletRequest request){
        List<Role> list1=new ArrayList<>();
        String key = "RoleAll"+id;
        if (redisTemplate.hasKey(key)) {
            list1=(List<Role>) redisTemplate.opsForValue().get(key);
            System.out.println("角色缓存");
        }else {
            list1=empService.setDep(id);
            redisTemplate.opsForValue().set(key, list1);
            System.out.println("角色数据库");
        }
         //List<Role> list = empService.setDep(id);
       // List<Integer> list1 = empService.queryRoleById(id);
       // request.getSession().setAttribute("roleId",list1.get(0));
        model.addAttribute("id",id);
        model.addAttribute("list",list1);
        return "updateRole";
    }

    //没用到
    @RequestMapping("queryRole")
    @ResponseBody
    public List<Role> queryRole(){
        List<Role> list=new ArrayList<>();
        String key = "RoleAll";
        if(redisTemplate.hasKey(key)){
            list=(List<Role>) redisTemplate.opsForValue().get(key);
            System.out.println("角色缓存");
        }else {
            list=empService.queryRole();
            redisTemplate.opsForValue().set(key, list);
            System.out.println("角色数据库");
        }
        return list;
    }
    @RequestMapping("updateRole")
    @ResponseBody
    public void updateRole(Integer uid,Integer rid,HttpServletRequest request) {
       // Integer i = (Integer)request.getSession().getAttribute("roleId");
        empService.updatero(uid,rid);
    }

    @RequestMapping("toEmpPost")
    public String toEmpPost(){
        return "postEmp";
    }
    @RequestMapping("queryRoleAll")
    @ResponseBody
    public HashMap<String,Object> queryRoleAll(@RequestBody ParameUtil parameUtil){
        return empService.queryRoleAll(parameUtil);
    }

    @RequestMapping("toUpdateMenu")
    public String toUpdateMenu(Integer id ,Model model){
        model.addAttribute("id",id);
        return "updateMenu";
    }

    @RequestMapping("queryMenuByRid")
    @ResponseBody
    public List<Menu> queryMenuByRid(Integer id){
        String key="updateTree"+id;

        Integer pid=0;
        List<Menu> list =new ArrayList<Menu>();
        if(redisTemplate.hasKey(key)){
            list=(List<Menu>) redisTemplate.opsForValue().get(key);
            System.out.println("权限缓存"+id);
        }else {
            list = empService.queryMenuByRid(id,pid);
            redisTemplate.opsForValue().set(key, list);
            System.out.println("权限数据库"+id);
        }
        //return empService.queryMenuByRid(id,pid);
        return list;
    }

    //绑定权限
    @RequestMapping("updateMenu")
    @ResponseBody
    public void updateMenu(Integer[] ids,Integer roleid){
        empService.updateMenu(ids,roleid);
        Integer pid=0;
        Integer id=roleid;
        String key="updateTree"+roleid;

        System.out.println(roleid);
        List<Menu> list= empService.queryMenuByRid(id,pid);
        redisTemplate.delete(key);

       redisTemplate.opsForValue().set(key, list);

    }

    @RequestMapping("logOut")
    @ResponseBody
    public void logOut(HttpServletRequest request){

        request.getSession().removeAttribute("u");


    }

    @RequestMapping("toLogin1")
    public String toLogin1(){
        return  "Login1";
    }











}
