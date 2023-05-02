package com.mph.xmlconfig;

public class GreetingServiceImpl implements GreetingService {

	private String greeting;

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	@Override
	public void sayHi() {
		System.out.println("Hi " + greeting);
	}

}
