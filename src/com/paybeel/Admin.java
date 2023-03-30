package com.paybeel;
import java.util.Scanner;
public class Admin {

	final String adminUserName="admin";
	final String adminPassword="password";
	
	boolean logginStatus=false;
	boolean loop=true;
	
	public void adminLoginSuccess() {
		
		logginStatus=true;
		while(logginStatus) {
			
			System.out.println("------------Admin Panel----------------");
			System.out.println("|   1 : Register New Consumer         |");
			System.out.println("|   2 : View All Consumers            |");
			System.out.println("|   3 : View All The Bill Of Consumer |");
			System.out.println("|   4 : View All The Bills            |");
			System.out.println("|   5 : Delete Consumer Account       |");
			System.out.println("|   6 : Back                          |");
			System.out.println("---------------------------------------");
			
			Scanner sc=new Scanner (System.in);
			int res=sc.nextInt();
			switch (res) {
			case 1:
				System.out.println("New Register");
				break;
			case 2:
				System.out.println("View all consumer");
				break;
			case 3:
				System.out.println("View all bill of consumer ");
				break;
			case 4:
				System.out.println("view all bills with status");
				break;
			case 5:
				System.out.println("Delete consumer");
				break;
			case 6:
				System.out.println("Back");
				logginStatus=false;
				
				break;}
		}
		}
	
	public void adminMethod() {
		 Admin admin=new Admin();
		System.out.println(" ------------------");
		System.out.println("| Admin User Name |");
		System.out.println(" ------------------");
		Scanner sc=new Scanner (System.in);
		
		String inputUserName=sc.nextLine();
		if(inputUserName.equals(admin.adminUserName)) {
			 System.out.println(" ---------------");
			System.out.println("| Admin Password |");
			 System.out.println(" ---------------");
			String inputUserPassword=sc.nextLine();
			if(inputUserPassword.equals(admin.adminPassword)) {
				admin.adminLoginSuccess();
			}else {
				System.out.println("Wrong Password");
			}
		}else {
			System.out.println("Wrong Admin User Name");
		}
	}
	
}
