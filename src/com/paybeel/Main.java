package com.paybeel;
import java.util.*;
public class Main {
//	List<Consumer> newConsumer=new ArrayList<>();
	

public static void main(String[] args) {

	boolean loop=true;
	while(loop){
		System.out.println("-----------Login Panel------");
		System.out.println("|  1 : Admin Login         |");
		System.out.println("|  2 :  User Login         |");
		System.out.println("|  Press Any Key:Exit      |");
		System.err.println("----------------------------");
		Scanner sc=new Scanner (System.in);
		try {
			int response=sc.nextInt();
			if(response==1) {
				Admin admin = new Admin();
				admin.adminMethod();
			}else if(response==2) {
				System.out.println("Program 2");
			}else {
				loop=false;
				System.out.println("Program Exited");
			}
		} catch (Exception e) {
			// TODO: handle exception
//			System.out.println(e);
			
			System.err.println("Program Ended");
			loop=false;
		}
		
		
	}
	
	
}






}
