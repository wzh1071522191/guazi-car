package com.jk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
@SpringBootApplication


@Configuration

@RestController
public class CarConsumerApplication {
    /**
     * 登陆界面
     */
    @GetMapping("/")
    public ModelAndView login() {
        return new ModelAndView("/login");
    }
    /**
     * 聊天界面
     */
    @GetMapping("/index")
    public ModelAndView index(String username, String password, HttpServletRequest request) throws UnknownHostException {
        if (StringUtils.isEmpty(username)) {
            username = "匿名用户";
        }
        ModelAndView mav = new ModelAndView("/chat");
        mav.addObject("username", username);
        mav.addObject("webSocketUrl", "ws://"+ InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/chat");
        return mav;
    }

    public static void main(String[] args) {
        SpringApplication.run(CarConsumerApplication.class, args);
    }

    @Bean

    public MultipartConfigElement multipartConfigElement() {

        MultipartConfigFactory factory = new MultipartConfigFactory();

        //单个文件最大

        factory.setMaxFileSize("10240KB"); //KB,MB

        /// 设置总上传数据总大小

        factory.setMaxRequestSize("102400KB");

        return factory.createMultipartConfig();

    }




}
