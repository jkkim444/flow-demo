package com.encocns.enfra.core.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

@Configuration
public class ServiceConfiguration {

	//Service Manager
	@Bean
	@Scope(WebApplicationContext.SCOPE_REQUEST)
	public ServiceBeanManager serviceManager()
	{
		return new ServiceBeanManager(); 
	}
	
	//Code
	@Bean
	public CommonCode commonCode()
	{
		return new CommonCode(); 
	}	
	
}
