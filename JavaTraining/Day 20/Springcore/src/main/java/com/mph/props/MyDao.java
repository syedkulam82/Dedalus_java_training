package com.mph.props;

public class MyDao {
	private String dbname;
	private String uname;
	private String password;

	public MyDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyDao(String dbname, String uname, String password) {
		super();
		this.dbname = dbname;
		this.uname = uname;
		this.password = password;
	}

	public String getDbname() {
		return dbname;
	}

	public void setDbname(String dbname) {
		this.dbname = dbname;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "MyDao [dbname=" + dbname + ", uname=" + uname + ", password=" + password + "]";
	}

}
