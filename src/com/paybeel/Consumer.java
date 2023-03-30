package com.paybeel;

public class Consumer {
	private String firstName;
	private String lastName;
	private Address address;
	private String email;
	private String mobileNumber;
	private String userName;
	private String password;
	//address
	public Address getAddress() {
		return address;
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
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
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
	
	public String toString() {
		return this.firstName+":"+this.lastName+":"+this.address.toString()+":"
	+this.email+":"+this.mobileNumber+":"+this.userName+":"+this.password;
	}
	
	
	public Address addressSetter(String address) {
		String[] str=address.split(",");
		Address adr=new Address(str[0],str[1],str[2],str[3],str[4],str[5],str[6]);
		return  adr;
	}
	public Consumer(String firstName, String lastName, String address, String email,String mobileNumber, String userName,
			String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address =addressSetter(address);
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.userName = userName;
		this.password = password;
	}
	

	
	
}
