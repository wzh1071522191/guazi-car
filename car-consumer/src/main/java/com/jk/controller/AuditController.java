package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.Audit;
import com.jk.service.AuditService;
import com.jk.util.AlYunOssUtil;
import com.jk.util.ParameUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author ： 张松光
 * @date ：Created in 2019/8/20 19:18
 * @description：审核车辆控制层
 * @package ：com.jk.controller
 * @version: 1.0.0
 */
@Controller
@RequestMapping("audit")
public class AuditController {

    @Reference(version = "1.0")
    private AuditService auditService;

    @RequestMapping("toAuditPage")
    public String toAuditPage(){
        return "auditCar";
    }

    @RequestMapping("queryAuditCar")
    @ResponseBody
    public HashMap<String,Object> queryAuditCar(@RequestBody ParameUtil pu){
        return auditService.queryAuditCar(pu);
    }

    @RequestMapping("updateStatus")
    @ResponseBody
    public String updateStatus(Integer id,Integer flag){
        return  auditService.updateStatus(id,flag);
    }

    @RequestMapping("toEventCar")
    public ModelAndView toEventCar(Integer id){
        ModelAndView mv=new ModelAndView();
        mv.addObject("id",id);
        mv.setViewName("carEvent");
        return mv;
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

    @RequestMapping("upMessage")
    @ResponseBody
    public void upMessage(Audit audit){
        auditService.upMessage(audit);
    }
}
