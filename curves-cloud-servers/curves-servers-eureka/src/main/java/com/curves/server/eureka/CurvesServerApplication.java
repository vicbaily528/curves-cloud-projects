package com.curves.server.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author vic
 */
@SpringBootApplication
@EnableEurekaServer
public class CurvesServerApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(CurvesServerApplication.class);
        application.run(args);
    }
}
