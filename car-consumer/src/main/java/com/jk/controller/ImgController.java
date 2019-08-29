package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Car;
import com.jk.model.RoundImg;
import com.jk.service.CarService;
import com.jk.service.ImgService;

import com.jk.util.AlYunOssUtil;
import com.jk.util.ParameUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author ： 安雅茹
 * @date ：Created in 2019-08-20 20:14
 * @description：
 * @package ：com.jk.controller
 * @version:
 */
@Controller()
@RequestMapping("img")
public class ImgController {
    @Reference
    private ImgService imgservice;
    @Reference(version = "1.0")
    private CarService carservice;
 /*@RequestMapping("queryImg1")
    @ResponseBody
   // public Map queryImg(Integer page,Integer rows){
     return imgservice.queryImg(page,rows);
 }*/
 @RequestMapping("addImgJsp")
    public String addImgJsp(){
     return "addImgJsp";
 }


    /**
     * OSS阿里云上传图片
     */
    @RequestMapping("upLoadFile")
    @ResponseBody
    public String uploadImg(MultipartFile imgName)throws IOException {
        if (imgName == null || imgName.getSize() <= 0) {
            throw new IOException("file不能为空");
        }
        AlYunOssUtil ossClient=new AlYunOssUtil();
        String name = ossClient.uploadImg2Oss(imgName);
        String imgUrl = ossClient.getImgUrl(name);
        String[] split = imgUrl.split("\\?");
        System.out.println(split[0]);
        return split[0];
    }
    //{"timestamp":"2019-08-21T11:21:40.719+0000","status":500,"error":"Internal Server Error","message":"org/apache/http/conn/ssl/NoopHostnameVerifier","path":"/img/updaloadImg"}
 @RequestMapping("addImg")
    @ResponseBody
    public void addImg(RoundImg roundimg){
      imgservice.addImg(roundimg);
    }
    /*@RequestMapping("showImgList")
    public String showImgList(String lbid){
        String[] arr = lbid.split(",");
      //  int arrlrn=arr.length;
       // int  arrlrn =arr.length%1==0?100:101;
        for (int i=0;i<arr.length;i++) {

            }
        }

            return null;

    }*/
    @RequestMapping("addLbShow")
    @ResponseBody
    public void  addLbShow(String lbid){
        imgservice.addLbShow(lbid);
    }
    @RequestMapping("ShowNowLb")
    public String  ShowNowLb(Model model,Car car){
        List<RoundImg> list=imgservice.ShowNowLb();
       List<Car> list1=carservice.queryCarAll(car);
        System.out.println(list);
        model.addAttribute("list", list);
        model.addAttribute("list1",list1);
        return "index";
    }
    @RequestMapping("ShowNowLb1")
    public String  ShowNowLb1(Model model){
        List<RoundImg> list=imgservice.ShowNowLb();
        List<Car> list1=carservice.queryCar1();
        System.out.println(list);
        model.addAttribute("list", list);
        model.addAttribute("list1",list1);
        return "index";
    }
    @RequestMapping("ShowNowLb2")
    public String  ShowNowLb2(Model model){
        List<RoundImg> list=imgservice.ShowNowLb();
        List<Car> list1=carservice.queryCar2();
        System.out.println(list);
        model.addAttribute("list", list);
        model.addAttribute("list1",list1);
        return "index";
    }
    @RequestMapping("ShowNowLb3")
    public String  ShowNowLb3(Model model){
        List<RoundImg> list=imgservice.ShowNowLb();
        List<Car> list1=carservice.queryCar3();
        System.out.println(list);
        model.addAttribute("list", list);
        model.addAttribute("list1",list1);
        return "index";
    }
    @RequestMapping("ShowNowLb4")
    public String  ShowNowLb4(Model model){
        List<RoundImg> list=imgservice.ShowNowLb();
        List<Car> list1=carservice.queryCar4();
        System.out.println(list);
        model.addAttribute("list", list);
        model.addAttribute("list1",list1);
        return "index";
    }
    @RequestMapping("queryImg")
    @ResponseBody
    public Map querycar(@RequestBody ParameUtil parm){

        return imgservice.queryImgList(parm);
    }
    @RequestMapping("to11jsp")
    public String to11jsp(){
        return "11";
    }
    @RequestMapping("delImg")
    @ResponseBody
    public void delImg(String lbid){
        imgservice.delImg(lbid);
    }
}

