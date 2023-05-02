package com.mph.welcome;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WelcomeMainClass {

	public static void main(String[] args) {
		
			ApplicationContext context = new ClassPathXmlApplicationContext("spr-welcome.xml");
			Welcome w = (Welcome) context.getBean("welcome");														// Dependency Injection
			System.out.println(w.sayWelcome());
	}

}
