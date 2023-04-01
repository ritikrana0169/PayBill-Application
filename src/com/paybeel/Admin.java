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
	
	
	
	

	
	public void adminLoginSuccess() throws IOException {
		boolean isAvail=!conHandler.newConsumerList.isEmpty();
		logginStatus=true;
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
			System.out.println("---------------------------------------");
			
			Scanner sc=new Scanner (System.in);
			int res=sc.nextInt();
			switch (res) {
			
			case 5:
				if(isAvail) {
					System.out.println("New Register");
					conHandler.newConsumerRegister();
				}else {
					System.out.println("No New consumer found");
				}
				break;
			case 1:
				System.out.println("View all consumer");
				
				break;
			case 2:
				System.out.println("View all bill of consumer ");
				break;
			case 3:
				System.out.println("view all bills with status");
				break;
			case 4:
				System.out.println("Delete consumer");
				break;
			case 6:
				System.out.println("Back");
				logginStatus=false;
				
				break;}
		}
		}
	
	public void adminMethod(ConsumerHandler conHandler) throws IOException {
		
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
				this.adminLoginSuccess();
			}else {
				System.out.println("Wrong Password");
			}
		}else {
			System.out.println("Wrong Admin User Name");
		}
	}
	
}
