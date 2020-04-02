package com.liuly.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class TestConfigration {

    @Bean
	public IRule irule() {
		return new RandomRule();
	}
	
}
