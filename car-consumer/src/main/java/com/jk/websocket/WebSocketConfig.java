package com.jk.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author ： xueqitao
 * @date ：Created in 2019/8/23 0023 22:04
 * @description：用于扫描和注册所有携带ServerEndPoint注解的实例
 * @package ：com.jk.websocket
 * @version: 1.0
 */
@Configuration
public class WebSocketConfig {
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {

        return new ServerEndpointExporter();
    }
}
