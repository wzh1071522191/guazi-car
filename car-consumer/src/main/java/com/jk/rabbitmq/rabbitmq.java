package com.jk.rabbitmq;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ： 朱友
 * @date ：Created in 2019/8/21 19:34
 * @description：1
 * @package ：com.jk.rabbitmq
 * @version: 1
 */
@Configuration
public class rabbitmq {
 @Bean
    public Queue Rabbitmq(){
     return new Queue("Rabbitmq");
 }
}
