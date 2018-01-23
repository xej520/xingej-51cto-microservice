package com.itmuch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class ConsumerMovieRibbonApplication {

    // 方法名：restTemplate
    // 最好跟MovieController里的 private RestTemplate restTemplate;
    // restTemplate 保持一致哦
    @Bean
    //添加下面这个注解，就可以使得RestTemplate，具备了负载均衡的能力
    //就整合了ribbon插件
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ConsumerMovieRibbonApplication.class, args);

        String[] allBeanNames = context.getBeanDefinitionNames();

        for (String key : allBeanNames) {
            System.out.println("-------->:\t" + key);
        }

    }
}
