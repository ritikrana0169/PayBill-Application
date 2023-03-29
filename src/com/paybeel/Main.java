package com.paybeel;
import java.util.*;
public class Main {
	List<Consumer> newConsumer=new ArrayList<>();
	
	
	
	
	Admin admin=new Admin();
	
	private void adminMethod() {
		System.out.println("Admin User Name");
		Scanner sc=new Scanner (System.in);
		String inputUserName=sc.nextLine();
		System.out.println("Admin Password");
		String inputUserPassword=sc.nextLine();
		if(inputUserName==admin.adminUserName) {
			if(inputUserPassword==admin.adminPassword) {
				adminLoginSuccess();
			}
		}
	}
	
	
public static void main(String[] args) {
	boolean loop=true;
	While(loop){
		System.out.println("--------------------");
		System.out.println("       1     : Admin Login");
		System.out.println("       2     : User Login");
		System.out.println("Press Any Key: Exit");
		Scanner sc=new Scanner (System.in);
		int response=sc.nextInt();
		if(response==1) {
			adminMethod();
		}else if(response==2) {
			userMethod();
		}else {
			loop=false;
		}
	}
}
}
