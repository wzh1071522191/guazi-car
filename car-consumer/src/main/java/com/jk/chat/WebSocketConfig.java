package com.jk.chat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author ： xueqitao
 * @date ：Created in 2019/8/25 0025 11:11
 * @description：扫描和注册所有携带ServerEndPoint注解的实例。
 * @package ：com.jk.chat
 * @version: 1.0
 */

@Configuration
public class WebSocketConfig {
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {

        return new ServerEndpointExporter();
    }
}
