package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.log.OSSClientUtil;
import com.jk.model.Audit;
import com.jk.model.Car;
import com.jk.model.CarType;
import com.jk.model.jiameng;
import com.jk.service.Mservice;
import com.jk.util.ParameUtil;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("mqc")
public class Mqccontroller {
    @Reference(version="1.0")
    private Mservice Mservice;

   @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

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
        List<CarType>list=   Mservice.querytype();

         return list;
    }

    @RequestMapping("deleteUser")
    @ResponseBody
public  void shan(String ids){
    Mservice.deleteUser(ids);

}
    //

    @RequestMapping("deletecartype")
    @ResponseBody
    public  void shan2(String ids){
        Mservice.deleteUser2(ids);

    }

    //分类
    @RequestMapping("querytypelist")
    public String cartype(){
        return "mqcquerytype";
    }



    //汽车类型查询type
    @RequestMapping("querycartype")
    @ResponseBody
    public Map querycartyvgpe(@RequestBody ParameUtil parm){
        return Mservice.querycartype(parm);
    }

     //下架
    @RequestMapping("upx")
    @ResponseBody
    public  void upx(Integer id){
        Mservice.upx(id);
    }
    //上架
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


//上传图片
@RequestMapping("updaloadImg")
@ResponseBody
public String uploadImg(MultipartFile imgg)throws IOException {
    if (imgg == null || imgg.getSize() <= 0) {
        throw new IOException("file不能为空");
    }
    OSSClientUtil ossClient=new OSSClientUtil();
    String name = ossClient.uploadImg2Oss(imgg);
    String imgUrl = ossClient.getImgUrl(name);
    String[] split = imgUrl.split("\\?");
    //System.out.println(split[0]);
    return split[0];
}
///新增
   @RequestMapping("toAddUserPage")

   public String toAddUserPage(){
       return "addcarpage";
   }

    @RequestMapping("addcar")
    @ResponseBody
    public void  addcar(Car c){
       // System.out.println(c);
        amqpTemplate.convertAndSend("Rabbitmq",c);
        // Mservice.addcar(c);
    }



    @RequestMapping("toup")
    @ResponseBody
    public void upcar(Car c){
        Mservice.upcar(c);

    }
//querymaiche 跳转查询待审核车辆
@RequestMapping("maiche")
public String querymai(){
    return "mqctiaojiexx";
}



    //查询待审核车辆
    @RequestMapping("querymaiche")
    @ResponseBody
    public Map querymaiche(@RequestBody ParameUtil parm){
         return Mservice.querymaiche(parm);
    }


//toaddxia 分给线下页面
    @RequestMapping("toaddxia")
    public String toaddxia(Integer id, HttpServletRequest request){

        Audit a= Mservice.querymai(id);
        request.getSession().setAttribute("a",a);
        return "toaddxia";
}

//addxianxia
@RequestMapping("addxianxia")
@ResponseBody
public void  addxianxia(String id ,HttpServletRequest request){
    Audit a= (Audit) request.getSession().getAttribute("a");
    Mservice.addxianxia(a,id);
}

//前台传来的值

    @RequestMapping("addaudit")
    @ResponseBody
public void addaudit(Car a){

        Mservice.addaudit(a);
    }

    @RequestMapping("addyes")
    @ResponseBody
    public void addyes(Integer id){

        Mservice.addyes(id);
    }

    @RequestMapping("addno")
    @ResponseBody
    public void addno(Integer id){

        Mservice.addno(id);
    }


    @RequestMapping("querykehu")
    public String querykh()
    {
        return "mqckh";
    }



    //查询待审核车辆
    @RequestMapping("querykh")
    @ResponseBody
    public Map querykk(@RequestBody ParameUtil parm){
        return Mservice.querykk(parm);
    }


@RequestMapping("upku")
@ResponseBody
public void upku(Integer id){
    Mservice.cv(id);

}


    @RequestMapping("hei")
    public String tohei( ){
       return "hei";

    }

    //queryhei
    @RequestMapping("queryhei")
    @ResponseBody
    public Map queryhei(@RequestBody ParameUtil parm){
        return Mservice.queryhei(parm);
    }

    //huifu

    @RequestMapping("huifu")
    @ResponseBody
    public void huifu(Integer id){
        Mservice.huifu(id);

    }

    //审青加盟
    @RequestMapping("jiameng")
    public String jiameng( ){
        return "jiameng";

    }

    //queryhei
    @RequestMapping("jm")
    @ResponseBody
    public Map jm(@RequestBody ParameUtil parm){

         return Mservice.jm(parm);
    }


    @RequestMapping("sh")
    @ResponseBody
    public void sh(Integer id  ){
        Mservice.sh(id);

    }
    @RequestMapping("sh2")
    @ResponseBody
    public void sh2(Integer id  ){
        Mservice.sh2(id);

    }

    @RequestMapping("dsds")
    public  String csdc(){
         return "guazi/index";
    }


    //新增至加盟表
    @RequestMapping("addjiameng")
    @ResponseBody
     public void addjm(jiameng aa){
        Mservice.addjm(aa);
    }

}
