package com.itmuch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients //添加feign依赖
public class ConsumerMovieFeignApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ConsumerMovieFeignApplication.class, args);

        String[] allBeanNames = context.getBeanDefinitionNames();

        for (String key : allBeanNames) {
            System.out.println("-------->:\t" + key);
        }

    }
}
