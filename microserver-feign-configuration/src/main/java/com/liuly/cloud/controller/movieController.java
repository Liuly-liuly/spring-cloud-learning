package com.liuly.cloud.controller;

import com.liuly.cloud.entity.User;
import com.liuly.cloud.feignClient.FeignClient2;
import com.liuly.cloud.feignClient.UserFeignClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class movieController {

	@Autowired
	private UserFeignClient userFeignClient;
	
	@Autowired
	private FeignClient2 feignclient;
	
    @GetMapping("/movie/{id}")
    public User getUsers(@PathVariable Long id){
       return this.userFeignClient.findById(id);
    }
    
    @GetMapping("/test")
    public User testPost(User user) {
      return this.userFeignClient.postUser(user);
    }


    @GetMapping("/{serviceName}")
    public String testPost(@PathVariable String serviceName) {
      return this.feignclient.findServiceInfoFromEurekaByServiceName(serviceName);
    }
    
}
