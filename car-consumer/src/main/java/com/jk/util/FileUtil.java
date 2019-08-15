/** 
 * <pre>项目名称:tupian 
 * 文件名称:FileUtil.java 
 * 包名:com.jk.controller 
 * 创建日期:2019-4-28下午6:54:47 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;








public class FileUtil {
	  
		//图片新增上传
		
			public static String upload(MultipartFile file,HttpServletRequest request){
			
				//获取 文件上传的绝对路径
				String savePath = request.getServletContext().getRealPath("")+"//upload";
				File saveFile = new File(savePath);
				
				if(!saveFile.exists()){  //判断文件夹是否存在  不存在就创建
				saveFile.mkdirs();
				}
				
				
				//获取图片原名
				String fileName = file.getOriginalFilename();
				//获取后缀名 abc.jpg         .jpg
				String suffix = fileName.substring(fileName.lastIndexOf("."));
				
				//重命名图片名 有两种：  时间戳   UUID
				//1 时间戳
				String Name1= System.currentTimeMillis()+suffix;
				
				//2 UUID
				//String Name1 = UUID.randomUUID()+suffix;
				//去除UUID生成随机码的‘-’ 也可做替换
				String Name2 = (UUID.randomUUID()+suffix).replaceAll("-", "");

				//转存（将图片存到项目创建文件夹）
				try {
					file.transferTo(new File(savePath+"//"+Name2));
				} catch (IllegalStateException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
				
					e.printStackTrace();
				}
				
				//入库写在Conteroller（存入数据库）
			
				
				return Name2;
		
		}
			
   /* @RequestMapping("add")  //上传格式
     public  String  add(emp m,MultipartFile file,HttpServletRequest request){
    	 if(!file.isEmpty()){
    		 String upload = FileUtil.upload(file, request);
    		 m.setEimg(upload);
    	 }
    	 empserivce.add(m);
		return "redirect:";
    	 
     }*/			
		
			
		//图片下载  
			@RequestMapping("xiazai")
			public static ResponseEntity<byte[]> xiazai(String img,HttpServletRequest request){
				
				//获取服务器绝对路径
				String savePath = request.getServletContext().getRealPath("")+"//upload";
				
				//将文件转成字节数组
				byte[] arr = null;
				try {
				arr	 = FileUtils.readFileToByteArray(new File(savePath+"//"+img));
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
				//设置HTTP请求头信息
				HttpHeaders headers = new HttpHeaders();
				//设置文件类型
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				//设置文件名
				headers.setContentDispositionFormData("attachment", img);
				
				return   new ResponseEntity<byte[]>(arr,headers,HttpStatus.CREATED); 
			
	
		}

    //  jsp页面写法 form里增加enctype="multipart/form-data"
  //<form action="<%=path%>/user/upload.do" method="post" enctype="multipart/form-data">  
			
	/*
	 	@RequestMapping("xiazai")  //下载格式
	public ResponseEntity<byte[]> xiazai(String img,HttpServletRequest request){
		
		return FileUtil.xiazai(img, request);		
	} 
	*/
			
}
