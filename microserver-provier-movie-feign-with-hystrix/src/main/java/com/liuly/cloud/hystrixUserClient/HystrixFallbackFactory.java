package com.liuly.cloud.hystrixUserClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.liuly.cloud.entity.User;
import com.liuly.cloud.feignClient.FeignClientUser;
import com.liuly.cloud.feignClient.UserFeignClientFallbackFactory;

import feign.hystrix.FallbackFactory;

@Component
public class HystrixFallbackFactory implements FallbackFactory<FeignClientUser>{

	private static final Logger logger=LoggerFactory.getLogger(HystrixFallbackFactory.class);
	
	@Override
	public FeignClientUser create(Throwable cause) {
	
		logger.info("this is ------- meesage"+cause.getMessage());
		
		
		//以下的两种情况都适合，只是一种多增加了一个接口去继承了原先的接口
		//这种情况可以适用于以后做开的时候的一种设计方式
		// 如果只是简单的进行处理我们可以直接时候匿名内部类的方式
//		return new UserFeignClientFallbackFactory() {
//			@Override
//			public User findById(Long id) {
//				User user=new User();
//				user.setId(-2l);
//				user.setUsername("this is feign fallbackfactory"+cause.getMessage());
//				return user;
//			}
//		};
		
		return new FeignClientUser() {
			
			@Override
			public User findById(Long id) {
				User user=new User();
				user.setId(-2l);
				user.setUsername("this is feign fallbackfactory"+cause.getMessage());
				return user;
			}
		};
		
	}

}
