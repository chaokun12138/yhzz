package com.hyzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.hyzz.car.mapper")
public class HyzzBusinessService {
    public static void main(String[] args) {
        SpringApplication.run(HyzzBusinessService.class,args);
    }
}
