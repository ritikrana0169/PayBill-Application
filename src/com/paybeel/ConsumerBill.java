package com.paybeel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ConsumerBill {
private	String ConsumerName="";
private String Status = "";

private int Amount;
private int Adjustment;
private String AdjustmentStatus;

private int Unit;
private LocalDate fromDate;
private LocalDate toDate;



public String getConsumerName() {
	return ConsumerName;
}


public void setConsumerName(String consumerName) {
	ConsumerName = consumerName;
}


public String getStatus() {
	return Status;
}


public void setStatus(String status) {
	Status = status;
}


public int getAmount() {
	return Amount;
}


public void setAmount(int amount) {
	Amount = amount;
}


public int getAdjustment() {
	return Adjustment;
}


public void setAdjustment(int adjustment) {
	Adjustment = adjustment;
}


public String getAdjustmentStatus() {
	return AdjustmentStatus;
}


public void setAdjustmentStatus(String adjustmentStatus) {
	AdjustmentStatus = adjustmentStatus;
}


public int getUnit() {
	return Unit;
}


public void setUnit(int unit) {
	Unit = unit;
}


public LocalDate getFromDate() {
	return fromDate;
}


public void setFromDate(LocalDate fromDate) {
	this.fromDate = fromDate;
}


public LocalDate getToDate() {
	return toDate;
}


public void setToDate(LocalDate toDate) {
	this.toDate = toDate;
}


public ConsumerBill(String consumerName,String AdjustmentStatus,int Adjustment,LocalDate fromDate,LocalDate toDate) {
	this.ConsumerName=consumerName;
	this.Status="pending";
	this.Unit =(int) ((Math.random() * (100 - 50)) + 50);
	this.AdjustmentStatus=AdjustmentStatus;
	if(AdjustmentStatus.equals("overPaid")) {
		this.Adjustment=(Adjustment)*-1;
	}
	else {
		this.Adjustment=(Adjustment);
	}
	this.Amount=((this.Unit)*10)+(this.Adjustment);
	this.fromDate=fromDate;
	this.toDate=toDate;
	
}


public ConsumerBill(String consumerName,String status,String unit,String Adjustment,String AdjustmentStatus,
		String fromDate,String toDate) {
	
	this.ConsumerName=consumerName;
	this.Status=status;
	this.Unit=Integer.parseInt(unit);
	this.AdjustmentStatus=AdjustmentStatus;
	if(AdjustmentStatus.equals("overPaid")) {
		this.Adjustment=Integer.parseInt(Adjustment)*-1;
	}
	else {
		this.Adjustment=Integer.parseInt(Adjustment);
	}
	this.Amount=((this.Unit)*10)+(this.Adjustment);
	try {
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		  
		this.fromDate =LocalDate.parse(fromDate, formatter);
				
		this.toDate =LocalDate.parse(toDate, formatter);
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e);
	}
	
}

public String toStringForPrint() {
	return "----------------------\n"+
"UserName :- "+this.ConsumerName+
"\n Status :- "+this.Status+
"\n Unit :- "+this.Unit+
"\n Previous Amount "+this.Adjustment+
"\n Current  Amount "+this.Amount+
"\n From "+dateToString(this.fromDate)+
"\n To"+dateToString(this.toDate)+
"\n------------------------------------";

}
public String toString() {
	return this.Status+"'"+this.Unit+"'"+this.Adjustment+"'"+
this.AdjustmentStatus+"'"+dateToString(this.fromDate)+"'"+dateToString(this.toDate);
}
public String dateToString(LocalDate dateEntry) {
	  
	  DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    String strDate = dateEntry.format(formatters);
	
   
    
    return strDate;
}

}
