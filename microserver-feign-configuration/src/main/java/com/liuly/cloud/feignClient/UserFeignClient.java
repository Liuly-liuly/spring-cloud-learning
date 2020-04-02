package com.liuly.cloud.feignClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liuly.config.testconfiguration;
import com.liuly.cloud.entity.User;

import feign.Param;
import feign.RequestLine;
//feignclient 注解还可以加其它的属性，例如url（前面必加name属性），configuration属性跟ribbon类似，控制访问规则是轮询或者随机。
@FeignClient(name="microserver-provider-user",configuration=testconfiguration.class)
public interface UserFeignClient {
	  @RequestLine("GET /simple/{id}")
	  public User findById(@Param("id") Long id);
	
	  //@RequestBody和@ResponseBody 是把传过来实体变为json数据格式进行http传输
	  @RequestLine("POST /user")
	  public User postUser(@RequestBody User user);
}
