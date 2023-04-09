package com.dal;

import com.emp.Employee;
import java.util.Scanner;

public class MainClass {
	static int y = 89;
	int z = 700;
	public static void main(String[] args) {
		int x = 100;
		System.out.println("Local variable - " + x);
		System.out.println("Static variable - " + y);
		
		MainClass mc = new MainClass();
		System.out.println("Instance variable - " + mc.z);
		
		//
		
		Employee emp = new Employee();
		System.out.println(emp.getEID());
		System.out.println(emp.getEName());
		
		emp.setEID(102);
		emp.setEName("Kulam");
		System.out.println(emp.getEID());
		System.out.println(emp.getEName());
		
		//
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Eid");

		int eid = sc.nextInt();
		emp.setEID(eid);

		System.out.println("Enter Ename");
		String ename= sc.next();
		emp.setEName(ename);
		
		System.out.println(emp.getEID());
		System.out.println(emp.getEName());
		
		//
	
		
		String choice = null;
		do {
			System.out.println("Enter your choice");
			System.out.println("1. Add Employee");
			System.out.println("2. View Employee");
			
			int ch =sc.nextInt();
			
			switch (ch) {
				case 1:
				{
					emp.addEmployee();
					break;
				}
				case 2:
				{
					emp.viewEmployee();
					break;
				}
				default:
				{
					System.out.println("Enter right choice");
					break;
				}
			};
			
			System.out.println("Do u want to continue Y or y");
			choice= sc.next();
		} while(choice.equals("Y") || choice.equals("y"));
		
		
		
		
		System.out.println("Exited");
		System.exit(0);

		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
