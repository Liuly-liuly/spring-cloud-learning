package com.liuly.cloud.controller;

import com.liuly.cloud.entity.User;
import com.liuly.cloud.feignClient.FeignClientUser;
import com.liuly.cloud.feignClient.UserFeignClient;
import com.netflix.discovery.converters.Auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class movieController {

	@Autowired
	private UserFeignClient userFeignClient;
	
	@Autowired
	private FeignClientUser feignfallbak;
	
    @GetMapping("/movie/{id}")
    public User getUsers(@PathVariable Long id){
       return this.feignfallbak.findById(id);
    }
    
    @GetMapping("/test")
    public User testPost(User user) {
      return this.userFeignClient.postUser(user);
    }

    @GetMapping("/test-get")
    public User testGet(User user) {
      return this.userFeignClient.getUser(user);
    }

}
