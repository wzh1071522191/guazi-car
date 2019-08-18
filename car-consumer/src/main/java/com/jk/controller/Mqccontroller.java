package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Car;
import com.jk.model.CarType;
import com.jk.service.Mservice;
import com.jk.util.DataGridResult;
import com.jk.util.PageUtil;
import com.jk.util.ParameUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("mqc")
public class Mqccontroller {
    @Reference(version="1.0")
    private Mservice Mservice;


    //跳转到汽车页面
     @RequestMapping("query")
      public String car1(){
        return "mqcquerycar";
      }

    //汽车查询
     @RequestMapping("querycar")
     @ResponseBody
     public Map querycar(@RequestBody ParameUtil parm){


         return Mservice.querycar(parm);
     }
//查询下拉  querytype
    @RequestMapping("querytype")
    @ResponseBody
   public List<CarType> querytype(){

         return Mservice.querytype();
    }

    @RequestMapping("deleteUser")
    @ResponseBody
public  void shan(String ids){
    Mservice.deleteUser(ids);

    }

//分类

    @RequestMapping("querytypelist")

    public String cartype(){
        return "mqcquerytype";
    }

    //汽车类型查询type
    @RequestMapping("querycartype")
    @ResponseBody
    public Map querycartype(@RequestBody ParameUtil parm){


        return Mservice.querycartype(parm);
    }

    @RequestMapping("upx")
    @ResponseBody
    public  void upx(Integer id){
        Mservice.upx(id);
    }

    @RequestMapping("ups")
    @ResponseBody
    public  void ups(Integer id){
        Mservice.ups(id);
    }





//跳转到仓库

    @RequestMapping("ck")
    public String ck(){
        return "mqcquerycar2";
    }
    @RequestMapping("querycar2")
    @ResponseBody
    public Map querycar2(@RequestBody ParameUtil parm){


        return Mservice.querycar2(parm);
    }

///新增
   @RequestMapping("toAddUserPage")

   public String toAddUserPage(){
       return "addcarpage";
   }

    @RequestMapping("addcar")
    @ResponseBody
    public void  addcar(Car c){
        System.out.println(c);

      Mservice.addcar(c);
    }


}
