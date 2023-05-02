package com.mph.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigMainClass {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spr-annoconfig.xml");
		GreetingService gs1 = (GreetingService) context.getBean("greetingServiceImpl");
		gs1.sayHi();		

	}

}
