package com.paybeel;

public class Consumer {
	private String firstName;
	private String lastName;
	private Address address;
	private String email;
	private int mobileNumber;
	private String userName;
	private String password;
	//address
	public String getAddress() {
		return address.toString();
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	//email
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	//mobile
	public int getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	//firstname 
	public void setFirstName(String firstName) {
		this.firstName=firstName;
	}
	public String getFirstName() {
		return firstName;
	}
	//lastName 
	public void setLastName(String lastName) {
		this.lastName=lastName;
	}
	public String getLastName() {
		return lastName;
	}
	
	//username
	public void setUserName(String userName) {
		this.userName=userName;
	}
	public String getUserName() {
		return userName;
	}
	//password
	public void setPassword(String password) {
		this.password=password;
	}
	public String getPassword() {
		return password;
	}
	
	
	
	
	

	
	
}
