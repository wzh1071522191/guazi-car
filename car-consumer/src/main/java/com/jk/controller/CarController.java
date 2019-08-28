package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Car;
import com.jk.model.CarType;
import com.jk.service.CarService;
import com.jk.util.ParamQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.*;

@Controller
@RequestMapping("car")
public class CarController {
    /**
     * Copyright (C), 2015-2019, jk
     * FileName: CarController
     * Author:
     * Date:     2019-08-16 09:26
     * Description:
     * History:
     * <author>          <time>          <version>          <desc>
     * 安安          修改时间           版本号              描述
     */
    @Resource
    private RedisTemplate<String,Car> redisTemplate;
    @Reference(version = "1.0")
    private CarService carservice;
    //car 展示页面------安安
    @RequestMapping("showcar")
    public String showcar(){
        return "showcar";
    }
    //首页关于热卖车型的条查  ------安安
    @RequestMapping("queryCar")
    public List<Car> queryCar(ParamQuery param){
        return carservice.queryCar(param);
    }
    //关于评估车价计算价格
    @RequestMapping("testCarPrice")
    public Double testCarPrice(Car car, HttpSession session){
        Double price =carservice.testCarPrice(car);
        session.setAttribute("car", car);
        session.setAttribute("price",price);
        return price;
    }
    //图表
    @RequestMapping("showHightcharts")
    @ResponseBody
    public  Map<String, Object>  showHightcharts(HttpSession session){
        Object price = session.getAttribute("price");
        Double reponseprice=Double.parseDouble(price.toString());
        String[] xtitle = new String[]{"个人成交区间","车商收购区间"};
        Map<String,Object> map =new HashMap<>();
        Double[] pricearr=new Double[]{reponseprice,reponseprice*0.95,reponseprice*0.90};
        map.put("xtitle",xtitle);
        map.put("pricearr","pricearr");
        if(reponseprice>=60){
            map.put("status","车况良好");
        }
        if(reponseprice>=30 && reponseprice<60){
            map.put("status","车况一般");
        }
        if(reponseprice>=0 && reponseprice<30){
            map.put("status","车况较差");
        }
        return map;
    }
   /* @RequestMapping("queryCarList")
    @ResponseBody
    public  List<Car> queryCarList(ParamQuery param, Model model){
        return carservice.queryCarList(param);
    }*/
    @RequestMapping("showCar")
    @ResponseBody
    public Map showCar(Integer page,Integer rows,Integer uid){
        System.out.println("88888888888888888888888"+uid);
        Map map =new HashMap();
        String key="usergwc"+uid;
        List<Car> list=new ArrayList<Car>();
        long count=0;
        if(redisTemplate.hasKey(key)){
            list=redisTemplate.opsForList().range(key,(page-1)*rows,rows);
            count=redisTemplate.opsForList().size(key);
        }else{
            list=null;
            count=0;
        }
        map.put("rows", list);
        map.put("total",count);
        return map;
    }

    @RequestMapping("addImgJsp")
    public String addImgJsp(){
        return "addImgJsp";
    }
    //买车时 条查
    @RequestMapping("queryCarAll")
    public String queryCarAll(Car car,Model model){
        List<Car> list=carservice.queryCarAll(car);
        model.addAttribute("list", list);
        return "list";
    }

    @RequestMapping("showabout")
    public String showabout(){
        System.out.println("----------------------------------------------");
        return "about";
    }
    @RequestMapping("index")
    public String index(){
        System.out.println("----------------------------------------------");
        return "index";
    }
    @RequestMapping("infor")
    public String infor(){
        System.out.println("----------------------------------------------66666666666666666666666666666666666");
        return "aaaaaaaaaaaa";
    } @RequestMapping("list")
    public String list(){

        return "list";
    } @RequestMapping("medialist")
    public String medialist(){
        System.out.println("----------------------------------------------");
        return "medialist";
    } @RequestMapping("newsinfor")
    public String newsinfor(){
        System.out.println("----------------------------------------------");
        return "newsinfor";
    } @RequestMapping("shop")
    public String shop(){
        System.out.println("----------------------------------------------");
        return "shop";
    }
    @RequestMapping("shoper")
    public String shoper(){
        System.out.println("----------------------------------------------");
        return "shoper";
    }
    @RequestMapping("wymc")
    public String wymc(){
        System.out.println("----------------------------------------------");
        return "wymc";
    }
    @RequestMapping("showorder")
    public String showorder(){
        System.out.println("----------------------------------------------");
        return "showorder";
    }
    @RequestMapping("divjsp")
    public String divjsp(){
        return "divjsp";
    }
    @RequestMapping("showThisCarJsp")
    public String  showThisCarJsp(Integer carid,Model model,HttpSession session){
        System.out.println("6666666666666666666666666666666666666");
        Car car=carservice.showThisCarJsp(carid);
        model.addAttribute("car",car);
        // session.setAttribute("car",car);
        System.out.println("++++ssssssssssssssssssssssssssssss"+car);
        return "addJsp";
    }
    @RequestMapping("addGwd")
    @ResponseBody
    public void addGwd(Integer carid,HttpSession session,Integer userid){
        Car car=carservice.showThisCarJsp(carid);
        String key="usergwc"+userid;
        // if(redisTemplate.haKsey(key)){
        redisTemplate.opsForList().leftPush(key, car);
        //  }



    }
    @RequestMapping("mycomment")
    public String mycomment(){
        return "mycomment";
    }
    @RequestMapping("youhui")
    public String youhui(){
        return "youhui";
    }
    @RequestMapping("addJsp")
    public String addJsp(){
        System.out.println("----------------------------------------------");
        return "addJsp";
    }
    @RequestMapping("mygwd")
    public String mygwd(Integer uid,Model model){
        String key="usergwc"+uid;
        List<Car> list=new ArrayList<Car>();

        if(redisTemplate.hasKey(key)){
            list=redisTemplate.opsForList().range(key,0,-1);
        }else{
            list=null;
        }
        model.addAttribute("list",list);
        return "shoper";
    }

    @RequestMapping("upload")
    @ResponseBody
    public  String  upload(MultipartFile carimg, HttpServletRequest request) {
        //1.确定存储文件的磁盘地址（将所有文件放到同一个文件夹下）
        String folderPath = request.getSession().getServletContext().getRealPath("/") + "cimg/";

//	2.判断该文件夹是否存在——>如果不存在，则创建
        File file = new File(folderPath);
        if (!file.exists()) {
            file.mkdir();
        }
//	3.保证文件名的唯一性：uuid、时间戳
//	  	获取原文件名
        String fileName = carimg.getOriginalFilename();
//	  	截取文件名的后缀，得到文件类型
        String hz = fileName.substring(fileName.lastIndexOf("."));
//	  	将uuid拼接文件后缀 得到具有唯一性的文件名
        String newFileName = UUID.randomUUID().toString() + "_" + hz;
//	4.将该文件放到指定文件夹下
        //将原文件中的文件内容 通过io流 放进该容器中
        try {
            FileOutputStream fos = new FileOutputStream(folderPath + newFileName);
            try {
                fos.write(carimg.getBytes());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "cimg/" + newFileName;
    }
    @RequestMapping("addCar")
    @ResponseBody
    public void addCar(Car car){
        carservice.addCar(car);
    }
    @RequestMapping("bar")
    public String bar(){
        return "bar";
    }


   @RequestMapping("queryBrand")
    @ResponseBody
    public List<CarType> queryBrand(){
        return carservice.queryBrand();
   }
    @RequestMapping("queryBrandType")
    @ResponseBody
    public List<CarType> queryBrandType(Integer pid){
        return carservice.queryBrandType(pid);
    }

    @RequestMapping("toSellCar")
    public String toSellCar(){
        System.out.println(12121);
        return "sellCar";
    }

}
