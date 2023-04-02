package com.paybeel;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Admin {
	ConsumerHandler conHandler=null;

	final String adminUserName="admin";
	final String adminPassword="password";
	
	boolean logginStatus=false;
	boolean loop=true;
	
	
	
	

	
	public boolean adminLoginSuccess() throws IOException {
		boolean isAvail=!conHandler.newConsumerList.isEmpty();
		logginStatus=true;
		boolean isExit =false;
		while(logginStatus) {
			
			System.out.println("------------Admin Panel----------------");
			
			System.out.println("|   1 : View All Consumers            |");
			System.out.println("|   2 : View All The Bill Of Consumer |");
			System.out.println("|   3 : View All The Bills            |");
			System.out.println("|   4 : Delete Consumer Account       |");
           if(isAvail) {
        	System.out.println("|   5 : Register New Consumer         |");
			}
			System.out.println("|   6 : Back                          |");
			System.out.println("|   7 : Generate Bill         |");
			System.out.println("|   8 : View All The Bills Paid & pending        |");
			System.out.println("|   0 : Exit                     |");
			System.out.println("---------------------------------------");
			
			Scanner sc=new Scanner (System.in);
			int res=sc.nextInt();
			switch (res) {
			
			case 5:
				if(isAvail) {
					System.out.println("New Register");
					logginStatus=  conHandler.newConsumerRegister();
					if(!logginStatus) {
						isExit=true;
					}
				}else {
					System.out.println("No New consumer found");
				}
				break;
			case 1:
		
				conHandler.printAllConsumer();
				
				break;
			case 2:
				conHandler.viewAllBillOfConsumer();
				break;
			case 3:
				conHandler.viewAllBill();
				break;
			case 4:
				conHandler.deleteConsumer();
				break;
			case 7:
				conHandler.generateBillForAllConsumer();
				System.out.println("All Bills Generated");
				break;
			case 8:
				conHandler.viewAllBillPaidAndPending();
				break;
			case 6:
				System.out.println("Back");
				logginStatus=false;
				
				break;
				default:
					conHandler.consumerFileSaver("resourse//newConsumer.txt");
					conHandler.consumerFileSaver("resourse//Consumer.txt");
					isExit=true;
					logginStatus=false;
					}
		}
		if(isExit){
			return logginStatus;
		}
		else {
			return true;
		}
		
		}
	
	public boolean adminMethod(ConsumerHandler conHandler) throws IOException {
		
		System.out.println(" ------------------");
		System.out.println("| Admin User Name |");
		System.out.println(" ------------------");
		Scanner sc=new Scanner (System.in);
		
		String inputUserName=sc.nextLine();
		if(inputUserName.equals(this.adminUserName)) {
			 System.out.println(" ---------------");
			System.out.println("| Admin Password |");
			 System.out.println(" ---------------");
			String inputUserPassword=sc.nextLine();
			if(inputUserPassword.equals(this.adminPassword)) {
				this.conHandler=conHandler;
				return adminLoginSuccess();
			}else {
				System.out.println("Wrong Password");
				return true;
			}
		}else {
			System.out.println("Wrong Admin User Name");
			return true;
		}
	}
	
}
