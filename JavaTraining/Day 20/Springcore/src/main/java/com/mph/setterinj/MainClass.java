package com.mph.setterinj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spr-setter.xml");
		//Car c = (Car)context.getBean("car");
		//System.out.println(c.getName() + "    " + c.getModel());

			User u =(User)context.getBean("user");
			
			System.out.println(u.getUserName()+ "  has   " + u.getCar().getName() + "  " +u.getCar().getModel());
	}

}
