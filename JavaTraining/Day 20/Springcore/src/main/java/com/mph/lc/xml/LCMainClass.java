package com.mph.lc.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LCMainClass {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spr-xml-lc.xml");
	//	School sc = (School) context.getBean("school");
	//	System.out.println(sc.getId());
		
		context.registerShutdownHook();  // used to shutdown the container gracefully
	}

}
