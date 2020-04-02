package com.liuly.cloud.feignClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.liuly.config.Configuration2;

import feign.RequestLine;

@FeignClient(name = "xxxx", url = "http://localhost:8761/", configuration = Configuration2.class)
public interface FeignClient2 {
	//访问 eureka 需要认证，在configuration 文件里面添加账户密码进行认证。
	 @RequestMapping(value = "/eureka/apps/{serviceName}")
	 public String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName);


}
