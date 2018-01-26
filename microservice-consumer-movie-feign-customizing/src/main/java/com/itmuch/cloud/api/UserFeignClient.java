package com.itmuch.cloud.api;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.itmuch.config.FeignConfiguration;

import feign.Param;
import feign.RequestLine;

import com.itmuch.cloud.entity.User;

@FeignClient(name = "microservice-provider-user", configuration=FeignConfiguration.class)
public interface UserFeignClient {
    
    //feign 默认的注解@RequestLine
    @RequestLine("GET /simple/{id}")
    public User findById(@Param("id") Long id);
    
    
}
