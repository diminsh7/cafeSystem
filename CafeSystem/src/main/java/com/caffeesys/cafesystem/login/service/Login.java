package com.caffeesys.cafesystem.login.service;

public class Login {
	private String division;
	private String id;
	private String pw;
	
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	@Override
	public String toString() {
		return "Login [division=" + division + ", id=" + id + ", pw=" + pw + "]";
	}
}
