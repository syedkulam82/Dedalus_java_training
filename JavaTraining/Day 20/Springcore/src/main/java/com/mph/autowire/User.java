package com.mph.autowire;



public class User {

	private String userName;

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

	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", car=" + car + "]";
	}

}
