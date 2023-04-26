package com.example.demo.form;

public class LoginUserForm {
	private String name;
	private String password;
	 private String loginErr;

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

	public String getLoginErr() {
		return loginErr;
	}

	public void setLoginErr(String loginErr) {
		this.loginErr = loginErr;
	}

}