package com.liuly.cloud.controller;

import com.liuly.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class movieController {

    @Autowired
    public RestTemplate restTemplate;

    @GetMapping("/movie/{id}")
    public User getUsers(@PathVariable Long id){
        ResponseEntity<User> forEntity = this.restTemplate.getForEntity("http://localhost:8760/simple/" + id, User.class);
        return forEntity.getBody();
    }



}
