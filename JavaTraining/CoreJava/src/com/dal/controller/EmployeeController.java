package com.dal.controller;

import java.util.Scanner;

import com.dal.model.Employee;

public class EmployeeController {
	Employee emp = new Employee();
	public void addEmployee()
	{		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Eid");
		int eid= sc.nextInt();
		emp.setEid(eid);
		
		System.out.println("Enter Ename");
		String ename= sc.next();
		emp.setEname(ename);
		System.out.println("Employee Added Succesfully");
	}
	
	public void viewEmployee() {
		System.out.println(emp);
	}
}
