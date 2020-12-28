package com.proj.model;

import java.io.Serializable;

public class UserInfo implements Serializable{
	private String name;
	private String email;
	private String mobileno;
	private String address;
	private String password;
	private String gender;
	private String dob;
	private String city;
	private String pin;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
		
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	 
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		 this.address=address;
	}
	public String getPIN() {
		return pin;
	}
	public void setPIN(String pin) {
		 this.pin=pin;
	}

}
