package com.itmuch.cloud.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itmuch.cloud.entity.User;

@FeignClient("microservice-provider-user")
public interface UserFeignClient {
    
    //@GetMapping(value="/simple/{id}")
    //在spring cloud里使用feign的话两个坑：
    //1、不支持GetMapp注解
    //2、@PathVariable 后面，必须添加上参数，如@PathVariable("id")
    @RequestMapping(value="simple/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id);
    
    @RequestMapping(value="/user", method = RequestMethod.POST)
    public User postUser(@RequestBody User user);
    
    //该请求不会成功，只要参数是复杂对象，即使设置了GET方法，feign依然会以POST方式进行发送
    @RequestMapping(value="/get-user", method = RequestMethod.GET)
    public User getUser(User user);
    
}
