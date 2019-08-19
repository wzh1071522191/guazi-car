package com.jk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan("com.jk.dao")
@EnableAsync
public class ZsgProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZsgProviderApplication.class, args);
    }

}
