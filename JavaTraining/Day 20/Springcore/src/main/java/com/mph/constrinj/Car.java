package com.mph.constrinj;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Car {

	@Value("Tata")
	private String name;
	@Value("Nexon")
	private String model;

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Car(String name, String model) {
		super();
		this.name = name;
		this.model = model;
	}

	public String getName() {
		return name;
	}

	public String getModel() {
		return model;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", model=" + model + "]";
	}

}
