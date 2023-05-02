package com.mph.lc.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LCAnnoMainClass {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spr-anno-lc.xml");
		School sc = (School) context.getBean("school");
		System.out.println(sc.getId());
		System.out.println(sc.getSchoolName());
		System.out.println(sc.getDept());
		System.out.println(sc.getAddress());
		
		context.registerShutdownHook();  // used to shutdown the container gracefully
	}

}
