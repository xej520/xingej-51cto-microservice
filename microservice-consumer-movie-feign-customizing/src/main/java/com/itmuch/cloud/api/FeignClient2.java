package com.itmuch.cloud.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itmuch.config.FeignConfiguration2;

//当配置了url后，name的值，就无所谓了
@FeignClient(name = "xxxx",url="http://localhost:8761/",configuration = FeignConfiguration2.class)
public interface FeignClient2 {
    
    @RequestMapping(value = "/eureka/apps/{serviceName}")
    public String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName);
    
}
