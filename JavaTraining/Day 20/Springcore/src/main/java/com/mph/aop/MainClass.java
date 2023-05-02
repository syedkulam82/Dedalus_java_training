package com.mph.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spr-aop.xml");
		Car c = (Car) context.getBean("car");
		//System.out.println(c.getName());

		//System.out.println(c.getModel());

		User u = (User) context.getBean("user");
		//u.setUserName("Deeps");
		c.setName("Tata");
		//c.setModel("Indica");
		//u.setCar(c);

		System.out.println(c.getName());
		u.setUserName("Akash");
		
		System.out.println(u.getUserName());
		//System.out.println(u.getUserName() + "  has   " + u.getCar().getName() + "  " + u.getCar().getModel());
	}

}
