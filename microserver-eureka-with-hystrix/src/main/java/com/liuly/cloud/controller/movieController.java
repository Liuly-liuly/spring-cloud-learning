package com.liuly.cloud.controller;

import com.liuly.cloud.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

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
import org.springframework.web.context.annotation.SessionScope;

@RestController
//@SessionScope  使用策略出现异常再使用  //当出现上下文运行异常是，要么配置 hystrix.shareSecurityContext=true 或 @requestsession 等价。
public class movieController {

    @Autowired
    public RestTemplate restTemplate;
    
    @Autowired
    private LoadBalancerClient loadBalancerClient;

 
    //commandProperties 中如果采用SEMAPHORE表示请求的线程与这个hystrixcommand命令在同一个线程里面运行，默认线程隔离
    @HystrixCommand(fallbackMethod="findByidFallback",commandProperties=@HystrixProperty(name="execution.isolation.strategy",value="SEMAPHORE"))
    @GetMapping("/movie/{id}")
    //@HystrixCommand(fallbackMethod="findByidFallback")
    public User getUsers(@PathVariable Long id){
        ResponseEntity<User> forEntity = this.restTemplate.
        		getForEntity("http://microserver-provider-user/simple/" + id, User.class);
        return forEntity.getBody();
    }
    
    public User findByidFallback (Long id) {
    	
    	User user=new User();
    	user.setId(0L);
    	user.setUsername("fallback");
    	user.setName("this is hystrix");
    	return user;
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
