package test;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @EnableDiscoveryClient表示当前服务是一个 Eureka 的客户端
 */
@SpringBootApplication
//@EnableEurekaClient
public class ProviderTicketApp {
    public static void main(String[] args) {
        SpringApplication.run(ProviderTicketApp.class, args);
    }
}
