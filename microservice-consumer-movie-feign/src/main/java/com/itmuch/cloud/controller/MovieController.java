package com.itmuch.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.itmuch.cloud.api.UserFeignClient;
import com.itmuch.cloud.entity.User;

@RestController
public class MovieController {
    
    
    @Autowired
    private UserFeignClient userFeignClient;
    
    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id) {
        return userFeignClient.findById(id);
    }
    
}
