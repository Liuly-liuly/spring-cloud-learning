package com.liuly.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

import feign.Contract;
import feign.Logger;

@Configuration
public class testconfiguration {

        @Bean
		public IRule irule() {
			return new RandomRule();
		}
        
        @Bean
        public Contract feignContract() {
          return new feign.Contract.Default();
        }
        
        @Bean
        Logger.Level feignLoggerLevel() {
          return Logger.Level.FULL;
        }
}
