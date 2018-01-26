package com.itmuch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;
import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class FeignConfiguration2 {
    
    //当你访问的服务，需要验证时，就可以使用下面的方式
    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        //spark 是用户名，
        //123456是密码
        return new BasicAuthRequestInterceptor("spark", "123456");
    }
    
}
