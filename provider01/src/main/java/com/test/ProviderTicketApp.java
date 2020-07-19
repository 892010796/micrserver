package com.test;


import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @EnableDiscoveryClient表示当前服务是一个 Eureka 的客户端
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.test.mapper")
public class ProviderTicketApp {
    public static void main(String[] args) {
        SpringApplication.run(ProviderTicketApp.class, args);
    }
}
