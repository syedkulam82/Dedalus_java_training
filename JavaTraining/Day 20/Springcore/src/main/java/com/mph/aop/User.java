package com.mph.aop;

public class User {

	private String userName;
	private Car car;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUserName() {
	
		return userName;
	}

	public void setUserName(String userName) {
		System.out.println("From setter username");
		this.userName = userName;
		throw new RuntimeException();
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", car=" + car + "]";
	}

}
