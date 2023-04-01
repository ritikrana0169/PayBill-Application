package com.paybeel;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConsumerBill {
	String consumerName="";
String status = "";

int Amount;

int unit;
Date fromDate =new SimpleDateFormat("dd/MM/yyyy").parse(sDate1); ; 



public ConsumerBill(String consumerName,String status,String unit,String fromDate,String toDate) {
	
	this.consumerName=consumerName;
	this.status=status;
	this.unit=Integer.parseInt(unit);
	
	
}
}
