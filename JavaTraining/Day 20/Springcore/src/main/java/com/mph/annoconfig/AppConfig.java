package com.mph.annoconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean(name = "gs1")
	public GreetingServiceImpl getGs1()
	{
		GreetingServiceImpl gs = new GreetingServiceImpl();
		gs.setGreeting("Good Day");					// property
		return gs;
	}
	
	@Bean(name = "gs2")
	public GreetingServiceImpl getGs2()
	{
		GreetingServiceImpl gs = new GreetingServiceImpl("Great Year Ahead");		
		return gs;
	}

}
