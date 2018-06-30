package com.curves.account;

import com.github.pagehelper.PageHelper;
import org.modelmapper.ModelMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.util.Properties;


@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.curves.account.services.mapper")
public class CurvesAccountApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(CurvesAccountApplication.class);
        application.run(args);
    }


    /**
     * 配置mybatis的分页插件pageHelper
     * @return PageHelper 分页帮助类
     */
    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum","true");
        properties.setProperty("rowBoundsWithCount","true");
        properties.setProperty("reasonable","true");
        properties.setProperty("dialect","mysql");
        pageHelper.setProperties(properties);
        return pageHelper;
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
