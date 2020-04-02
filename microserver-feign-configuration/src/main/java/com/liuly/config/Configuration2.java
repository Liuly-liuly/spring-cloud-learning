package com.liuly.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class Configuration2 {
  @Bean
  public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
    return new BasicAuthRequestInterceptor("user", "123");
  }
  
  
  @Bean
	public IRule irule() {
		return new RandomRule();
	}
  
  @Bean
  Logger.Level feignLoggerLevel() {
    return Logger.Level.FULL;
  }
  
}

