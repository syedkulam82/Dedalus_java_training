package com.mph.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigMainClass {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spr-xmlconfig.xml");
		GreetingService gs1 = (GreetingService) context.getBean("greetingService");
		gs1.sayHi();
		

	}

}
