package com.ey.vehicleadv.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
@Configuration
public class AppConfig {
	 @Bean
	    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) 
	    {
	        return restTemplateBuilder
	           .setConnectTimeout(Duration.ofMillis(5000))
	           .setReadTimeout(Duration.ofMillis(50000))
	           .build();
	    }	
}
