package com.liuly.cloud.controller;

import com.liuly.cloud.entity.User;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class movieController {

    @Autowired
    public RestTemplate restTemplate;
    
    @Autowired
    private LoadBalancerClient loadBalancerClient;


    @GetMapping("/movie/{id}")
    public User getUsers(@PathVariable Long id){
        ResponseEntity<User> forEntity = this.restTemplate.
        		getForEntity("http://microserver-provider-user/simple/" + id, User.class);
        return forEntity.getBody();
    }

    
    @GetMapping("/test")
    public String test() {
    	
      System.out.println("-------------");
    	
      ServiceInstance serviceInstance = this.loadBalancerClient.choose("microserver-provider-user");
      System.out.println("---1---1-" + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort());

      ServiceInstance serviceInstance2 = this.loadBalancerClient.choose("provider-user2");
      System.out.println("---2---2-" + ":" + serviceInstance2.getServiceId() + ":" + serviceInstance2.getHost() + ":" + serviceInstance2.getPort());
      
      System.out.println("-------------");
      
      return "SUCCESS";
    }


}
