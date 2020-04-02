package com.liuly.cloud;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
@ExcludeFromComponentScan
public class RandomConfiguration {

	@Bean
	public IRule randomRule() {
		return new RandomRule();
	}
	
}
