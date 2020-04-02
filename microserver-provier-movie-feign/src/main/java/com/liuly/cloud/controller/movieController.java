package com.liuly.cloud.controller;

import com.liuly.cloud.entity.User;
import com.liuly.cloud.feignClient.UserFeignClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class movieController {

	@Autowired
	private UserFeignClient userFeignClient;
	
    @GetMapping("/movie/{id}")
    public User getUsers(@PathVariable Long id){
       return this.userFeignClient.findById(id);
    }
    
    @GetMapping("/test")
    public User testPost(User user) {
      return this.userFeignClient.postUser(user);
    }

    @GetMapping("/test-get")
    public User testGet(User user) {
      return this.userFeignClient.getUser(user);
    }

    @GetMapping("/get-all")
    public List<User> listall(User user) {
        return this.userFeignClient.listAll();
    }

}
