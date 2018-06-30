package com.curves.front.webapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author vic
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class CurvesFrontWebApiApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(CurvesFrontWebApiApplication.class);
        application.run(args);
    }

    @Bean
    RestTemplate build() {
        return new RestTemplateBuilder().build();
    }
}
