package com.mph.annoconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigMainClass {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		GreetingService gs1 = (GreetingService) context.getBean("gs1");
		gs1.sayHi();		

		GreetingService gs2 = (GreetingService) context.getBean("gs2");
		gs2.sayHi();		
	}

}
