package com.itmuch.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itmuch.cloud.api.FeignClient2;
import com.itmuch.cloud.api.UserFeignClient;
import com.itmuch.cloud.entity.User;

import net.minidev.json.JSONArray;

@RestController
public class MovieController {
    
    @Autowired
    private UserFeignClient userFeignClient;
    
    @Autowired
    private FeignClient2 feignClient2;
    
    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id) {
        return userFeignClient.findById(id);
    }
    
    @GetMapping("/{serviceName}")
    public String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName){
        return this.feignClient2.findServiceInfoFromEurekaByServiceName(serviceName);
    }
    
}
