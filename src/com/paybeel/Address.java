package com.paybeel;

import java.util.Scanner;

public class Address {
private String flatNum;
private String buildingName;
private String landmark;
private String street;
private String city;
private String state;
private String pin;
public String getFlatNum() {
	return flatNum;
}
public void setFlatNum(String flatNum) {
	this.flatNum = flatNum;
}
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
public String getLandmark() {
	return landmark;
}
public void setLandmark(String landmark) {
	this.landmark = landmark;
}
public String getBuildingName() {
	return buildingName;
}
public void setBuildingName(String buildingName) {
	this.buildingName = buildingName;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getPin() {
	return pin;
}
public void setPin(String pin) {
	this.pin = pin;
}
public Address() {
	
}
public Address(String flatNum, String buildingName, String landmark, String street, String city, String state,
		String pin) {
	super();
	this.flatNum = flatNum;
	this.buildingName = buildingName;
	this.landmark = landmark;
	this.street = street;
	this.city = city;
	this.state = state;
	this.pin = pin;
}

public String toString() {
	return this.flatNum+","+this.buildingName+","+this.landmark+","+this.street+","+this.city+","+this.state+","+this.pin;
}
public void addressEntry() {
	Scanner mc=new Scanner(System.in);
	System.out.println("Enter Flat no");
	this.flatNum=mc.nextLine();
	System.out.println("Building Name");
	this.buildingName=mc.nextLine();
	System.out.println("Enter Landmark");
	this.landmark=mc.nextLine();
	System.out.println("Enter Street");
	this.street=mc.nextLine();
	System.out.println("Enter City");
	this.city=mc.nextLine();
	System.out.println("Enter State");
	this.state=mc.nextLine();
	System.out.println("Enter Pin");
	this.pin=mc.nextLine();
//	mc.close();
}
	
}
