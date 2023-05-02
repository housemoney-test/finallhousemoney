package com.example.demo.entity;

public class User {

    private int id;

    private String name;

<<<<<<< HEAD
	private String password;
	
	private String phoneNumber;
	
	private String loginErr;
	
	private int daySpending;
	
	private int income;
	
	private int saving;
=======
    private String password;
    
    private String phoneNumber;
    
    private String loginErr;
    
    private int daySpending;
>>>>>>> origin/master

    public int getDaySpending() {
        return daySpending;
    }

    public void setDaySpending(int daySpending) {
        this.daySpending = daySpending;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

<<<<<<< HEAD
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public int getIncome() {
		return income;
	}
	
	public void setIncome(int income) {
		this.income = income;
	}
	
	public int getSaving() {
		return saving;
	}
	
	public void setSaving(int saving) {
		this.saving = saving;
	}

=======
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
>>>>>>> origin/master

    public String getLoginErr() {
        return loginErr;
    }

    public void setLoginErr(String loginErr) {
        this.loginErr = loginErr;
    }

    
}
