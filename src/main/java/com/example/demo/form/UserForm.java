package com.example.demo.form;

public class UserForm {

	private String name;
	private String password;
	private String loginErr;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginErr() {
		return loginErr;
	}

	public void setLoginErr(String loginErr) {
		this.loginErr = loginErr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}