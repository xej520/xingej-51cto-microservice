package com.itmuch.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.itmuch.cloud.entity.User;

@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    //测试ribbon时，注释掉
    //并且，将配置文件里user.userServicePath 属性注释掉
//    @Value("${user.userServicePath}")
//    private String userServicePath;
    
    
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    
    
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
        // 存在的问题？
        // 如果是旧的框架是没有问题的，但是，
        // 如果是云环境的话，可能会有问题
        // 如果服务提供者的IP，和端口，可能要经常变
        // 是动态变化的
        // 因此，这里写死了，是有问题的
//        return this.restTemplate.getForObject(this.userServicePath + id, User.class);
        //其实，下面的也算是硬编码，万一，应用名称变了呢
        //其实，这是VIP virtual IP
        
        ServiceInstance choose = this.loadBalancerClient.choose("microservice-provider-user");
        
        System.out.println("===0===>:\t" + choose.getHost() +":" + choose.getPort() +":" + choose.getServiceId());
        
        
        return this.restTemplate.getForObject("http://microservice-provider-user/simple/" + id, User.class);
    }

    @GetMapping("/test")
    public String test(){
        ServiceInstance choose = this.loadBalancerClient.choose("microservice-provider-user");
       
        System.out.println("===1===>:\t" + choose.getHost() +":" + choose.getPort() +":" + choose.getServiceId());
        
        
        ServiceInstance choose2 = this.loadBalancerClient.choose("microservice-provider-user-2");
        
        System.out.println("===2===>:\t" + choose2.getHost() +":" + choose2.getPort() +":" + choose2.getServiceId());
        
        return "1";
    }
    
}
