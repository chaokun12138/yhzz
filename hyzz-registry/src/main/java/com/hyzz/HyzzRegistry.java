package com.hyzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class HyzzRegistry {
    public static void main(String[] args) {
        SpringApplication.run(HyzzRegistry.class,args);
    }
}
