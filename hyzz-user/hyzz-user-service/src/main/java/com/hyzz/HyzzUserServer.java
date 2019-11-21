package com.hyzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@EnableEurekaClient
@SpringBootApplication
@MapperScan(value = "com.hyzz.mapper")
public class HyzzUserServer {
    public static void main(String[] args) {
        SpringApplication.run(HyzzUserServer.class,args);
    }
}
