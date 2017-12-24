package com.itmuch.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.itmuch.cloud.entity.User;

@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 当你使用页面或者postman的方式，/movie/{id} 时，
     * 
     * 通过restTemplate 去请求微服务，
     * 
     * 然后，查看返回
     * 
     * 消费者movie里的API，消费了提供者provide里的API
     * 
     * @param id
     * @return
     */
    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id) {
        return this.restTemplate.getForObject("http://localhost:7900/simple/" + id, User.class);
    }

}
