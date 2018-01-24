package com.itmuch.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
@RibbonClient(name="microservice-provider-user",configuration=TestConfiguration.class)
public class TestConfiguration {
    
    @Autowired
    IClientConfig config;
    
    @Bean
    public IRule ribbonRule(IClientConfig config){
        
        //设置负载均衡策略是随机
        return new RandomRule();
    }
    
}
