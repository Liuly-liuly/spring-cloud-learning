package com.liuly.cloud.controller;

import com.google.common.collect.Lists;
import com.liuly.cloud.entity.GoodsInfo;
import com.liuly.cloud.entity.User;
import com.liuly.cloud.repository.UserRepository;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class userController {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private EurekaClient client;

    @Autowired
    private DiscoveryClient discoveryClient;
    
    @GetMapping(value="/simple/{id}",produces=MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    public User findById(@PathVariable Long id) {
//        Optional<User> byId = this.userRepository.findById(id);
//        System.out.print(byId.get());
        return   this.userRepository.findOne(id);
    }

    @GetMapping("/eureka-instance")
    public String serviceUrl() {
      InstanceInfo instance = this.client.getNextServerFromEureka("MICROSERVER-SIMPLE-PROVIDER-USER", false);
      return instance.getHomePageUrl();
    }
    
    @GetMapping("/eureka-info")
    public ServiceInstance servive() {
    	
    	return this.discoveryClient.getLocalServiceInstance();
 
    }
    
    @PostMapping("/user")
    public User postUser(@RequestBody User user) {
      return user;
    }

    // 该请求不会成功
    @GetMapping("/get-user")
    public User getUser(User user) {
      return user;
    }
    
    @GetMapping("list-all")
    public List<User> listAll() {
      ArrayList<User> list = Lists.newArrayList();
      User user = new User(1L, "zhangsan");
      User user2 = new User(2L, "zhangsan");
      User user3 = new User(3L, "zhangsan");
      list.add(user);
      list.add(user2);
      list.add(user3);
      return list;

    }

    @PostMapping(value="/simple",produces=MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    public List findById( @RequestBody GoodsInfo info) {
        System.out.print("----->"+info.toString());
        GoodsInfo in = new GoodsInfo();
        in.setCpCode("12345");
        in.setCpCode("1234");
        in.setCrgoArrngNoteId("54321");
        in.setCrgoTypeName("刘力");
        List<GoodsInfo> list =new ArrayList<>();
        list.add(in);
        return list;
    }
    
}
