package com.emp;

public class Employee {
	int eid = 101;
	String ename = "Syed";
	
	public int getEID() {
		return this.eid;
	}
	
	public String getEName() {
		return this.ename;
	}
	
	public void setEID(int eid) {
		this.eid = eid;
	}
	
	public void setEName(String ename) {
		this.ename = ename;
	}
	
	public void addEmployee() {
		this.setEID(1554099);
		this.setEName("Syed Kulam A");
	}
	
	public void viewEmployee() {
		System.out.println("Employee ID is " + this.getEID());
		System.out.println("Employee Name is " + this.getEName());
	}
}
