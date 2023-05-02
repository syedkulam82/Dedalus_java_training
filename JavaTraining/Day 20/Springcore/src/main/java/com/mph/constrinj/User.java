package com.mph.constrinj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class User {

	@Value("Nirbhay")
	private String userName;
	
	@Autowired
	private Car car;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String userName, Car car) {
		super();
		this.userName = userName;
		this.car = car;
	}

	public String getUserName() {

		return userName;
	}

	public Car getCar() {
		return car;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", car=" + car + "]";
	}

}
