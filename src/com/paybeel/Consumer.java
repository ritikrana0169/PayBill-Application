package com.paybeel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Consumer {
	private String firstName;
	private String lastName;
	private Address address;
	private String email;
	private String mobileNumber;
	List<ConsumerBill> consumerBillList=new ArrayList<>();
	private LocalDate connActivationDate=null;
	private String userName="ToBeAssigned";
	private String password="ToBeAssigned";
	private String status="inactive";
	//address
	
	public Address getAddress() {
		return address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<ConsumerBill> getConsumerBillList() {
		return consumerBillList;
	}
	public void setConsumerBillList(List<ConsumerBill> consumerBillList) {
		this.consumerBillList = consumerBillList;
	}
	public LocalDate getConnActivationDate() {
		return connActivationDate;
	}
	public void setConnActivationDate(LocalDate connActivationDate) {
		this.connActivationDate = connActivationDate;
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
	+this.email+":"+this.mobileNumber+":"+consumerBillListToString()+":"+dateToString(this.connActivationDate)+":"+this.userName+":"+this.password+
	":"+this.status;
	}
	
	public String toStringSecure() {
		return "Full Name:- "+this.firstName+" "+this.lastName+"\nADDRESS :- "+this.address.toString()+"\nEMAIL :-"
	+this.email+"\n MOBILE NO. :- "+this.mobileNumber+"\n Activation Date :-" +dateToString(this.connActivationDate)
	+"\n Activation Status :-" +this.status;
	}
	public String consumerBillListToString()
	{
		String temp="";
		for(int i=0;i<this.consumerBillList.size();i++) {
			if(i<this.consumerBillList.size()-1) {
				temp=temp+consumerBillList.get(i).toString()+";";
			}else {
				temp=temp+consumerBillList.get(i).toString();
			}
		}
		return temp;
	}
	
	public Address addressSetter(String address) {
		String[] str=address.split(",");
		Address adr=new Address(str[0],str[1],str[2],str[3],str[4],str[5],str[6]);
		return  adr;
	}
	public Consumer(String firstName, String lastName, String address, String email,String mobileNumber,String consumerBillList,String connActivationDate, String userName,
			String password,String status) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address =addressSetter(address);
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.consumerBillList=consumerBillListFromString(consumerBillList);
		try {
			 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				this.connActivationDate =LocalDate.parse(connActivationDate, formatter);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		this.userName = userName;
		this.password = password;
		this.status = status;
	}
	
public void consumerEntry() {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter First Name");
	this.firstName=sc.nextLine();
	System.out.println("Enter Last Name");
	this.lastName=sc.nextLine();
	System.out.println("Enter Address");
	Address addr=new Address();
	addr.addressEntry();
//	sc.close();
	this.address=addr;
//	Scanner dc=new Scanner(System.in);
	System.out.println("Enter Email");
	this.email=sc.nextLine();
	System.out.println("Enter Mobile No");
	this.mobileNumber=sc.nextLine();
	try {
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.connActivationDate =LocalDate.parse("12/12/9999", formatter);
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e);
	}
//	dc.close();
}
	public Consumer() {
	
	}
public List<ConsumerBill> consumerBillListFromString(String consumerBillList) {
	List<ConsumerBill> cbill=new ArrayList<>();
	if(!consumerBillList.isBlank()) {
	String[] consumerBillStringList=consumerBillList.split(";");
	for(int i=0;i<consumerBillStringList.length;i++) {
		String[] consumerBillArray=consumerBillStringList[i].split("'");
		ConsumerBill cBill=new ConsumerBill(this.firstName+" "+this.lastName,consumerBillArray[0],consumerBillArray[1],
				consumerBillArray[2],consumerBillArray[3],consumerBillArray[4],consumerBillArray[5]);
		cbill.add(cBill);
	}
	}
	return cbill;
}
public String dateToString(LocalDate dateEntry) {
	  
	  DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    String strDate = dateEntry.format(formatters);
	
 
  
  return strDate;
}
}
