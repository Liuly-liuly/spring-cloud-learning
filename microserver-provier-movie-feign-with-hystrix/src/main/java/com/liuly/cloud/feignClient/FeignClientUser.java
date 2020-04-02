package com.liuly.cloud.feignClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.liuly.cloud.entity.User;
import com.liuly.cloud.hystrixUserClient.HystrixFallbackFactory;
import com.liuly.cloud.hystrixUserClient.hystrixUserclient;

import feign.hystrix.FallbackFactory;
//这里如果fallback和fallbackfactory联合使用会有问题，因为factory是他的一个增强版，二者只能使用一种
@FeignClient(name="microserver-provider-user"/*,fallback=hystrixUserclient.class*/,fallbackFactory=HystrixFallbackFactory.class)
public interface FeignClientUser {

	@RequestMapping(value="/simple/{id}",method=RequestMethod.GET)
	public User findById(@PathVariable("id") Long id);   //feign 有两个坑，第一个是@pathvariablel
	//里面必须要有值，2，它不支持getmapping 和  postmapping 这样的注解
	
}
