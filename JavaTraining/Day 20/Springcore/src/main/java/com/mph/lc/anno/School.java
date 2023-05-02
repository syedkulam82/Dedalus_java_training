package com.mph.lc.anno;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class School {

	private int id;
	private String schoolName;
	private List<String> dept;
	private Map<Integer,String> address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public List<String> getDept() {
		return dept;
	}

	public void setDept(List<String> dept) {
		this.dept = dept;
	}
	
	
	

	public Map<Integer, String> getAddress() {
		return address;
	}

	public void setAddress(Map<Integer, String> address) {
		this.address = address;
	}

	/*
	 * @PostConstruct public void hi() { System.out.println("From hi method"); }
	 * 
	 * @PreDestroy public void bye() {
	 * 
	 * System.out.println("From bye method"); }
	 */
	@Override
	public String toString() {
		return "School [id=" + id + ", getId()=" + getId() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
