package designpattern;

import designpattern.SingletonA;

public class Singleton {

	public static void main(String[] args) {

		SingletonA singleton = SingletonA.getInstance();
		singleton.setMessage("Hello, World!");

		System.out.println(singleton.getMessage()); // Output: "Hello, World!"

		// To prove that it is the single instance
		System.out.println(singleton);
		Singleton singleton1 = Singleton.getInstance();
		System.out.println(singleton1);
	}

}