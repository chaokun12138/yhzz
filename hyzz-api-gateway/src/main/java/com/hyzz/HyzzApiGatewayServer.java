package com.hyzz;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 网关
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class HyzzApiGatewayServer {
    public static void main(String[] args) {
        SpringApplication.run(HyzzApiGatewayServer.class,args);
    }
}
