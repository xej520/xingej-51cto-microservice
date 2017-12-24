package com.itmuch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MicroserviceSimpleConsumerMovieApplication {

    // 方法名：restTemplate
    // 最好跟MovieController里的 private RestTemplate restTemplate;
    // restTemplate 保持一致哦
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MicroserviceSimpleConsumerMovieApplication.class, args);

        String[] allBeanNames = context.getBeanDefinitionNames();

        for (String key : allBeanNames) {
            System.out.println("-------->:\t" + key);
        }

    }
}
