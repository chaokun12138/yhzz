package com.hyzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 配置中心
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class HyzzConfigServer {
    public static void main(String[] args) {
        SpringApplication.run(HyzzConfigServer.class,args);
    }
}
