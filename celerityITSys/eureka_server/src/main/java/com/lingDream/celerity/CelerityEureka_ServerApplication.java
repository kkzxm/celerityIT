package com.lingDream.celerity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class CelerityEureka_ServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CelerityEureka_ServerApplication.class, args);
    }
}
