package com.liuly.cloud.feignClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liuly.cloud.entity.User;

import java.util.List;

//feignclient 注解还可以加其它的属性，例如url（前面必加name属性），configuration属性跟ribbon类似，控制访问规则是轮询或者随机。
@FeignClient("microserver-provider-user")
public interface UserFeignClient {

    @RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id);   //feign 有两个坑，第一个是@pathvariablel
    //里面必须要有值，2，它不支持getmapping 和  postmapping 这样的注解

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User postUser(@RequestBody User user);

    // 该请求不会成功，只要参数是复杂对象，即使指定了是GET方法，feign依然会以POST方法进行发送请求。可能是我没找到相应的注解或使用方法错误。
    // 如勘误，请@lilizhou2008  eacdy0000@126.com
    @RequestMapping(value = "/get-user", method = RequestMethod.GET)
    public User getUser(User user);

    @RequestMapping(value = "/list-all", method = RequestMethod.GET)
    public List<User> listAll();
}
