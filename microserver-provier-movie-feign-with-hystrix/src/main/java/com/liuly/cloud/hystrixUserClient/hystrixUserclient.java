package com.liuly.cloud.hystrixUserClient;

import org.springframework.stereotype.Component;

import com.liuly.cloud.entity.User;
import com.liuly.cloud.feignClient.UserFeignClient;

@Component
public class hystrixUserclient implements UserFeignClient {

	@Override
	public User findById(Long id) {
		  User user1=	new User();
		    user1.setId(-1l);
		    user1.setUsername("this is feign hystrix");
			return user1;
	}

	@Override
	public User postUser(User user) {
		// TODO Auto-generated method stub
	    User user1=	new User();
	    user1.setId(-1l);
	    user1.setUsername("this is feign hystrix");
		return user1;
	}

	@Override
	public User getUser(User user) {
		    User user1=	new User();
		    user1.setId(-1l);
		    user1.setUsername("this is feign hystrix");
			return user1;
	}
	
	

}
