package com.paybeel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
public class Main {
//	List<Consumer> newConsumer=new ArrayList<>();
	
	
	

public static void main(String[] args) {
	ConsumerHandler consumerHandler=new ConsumerHandler();
	
	boolean loop=true;
	while(loop){
		System.out.println("---------Login Panel--------");
		System.out.println("|  1 : Admin Login         |");
		System.out.println("|  2 :  User Login         |");
		System.out.println("|  Press Any Key:Exit      |");
		System.out.println("----------------------------");
		Scanner sc=new Scanner (System.in);
		try {
			int response=sc.nextInt();
			if(response==1) {
				
				
				Admin admin = new Admin();
				
				admin.adminMethod(consumerHandler);
			}else if(response==2) {
				loop=consumerHandler.consumerFunction();
			}else {
				loop=false;
				consumerHandler.consumerFileSaver("resourse//newConsumer.txt");
				consumerHandler.consumerFileSaver("resourse//Consumer.txt");
				System.out.println("Program Exited");
			}
		} catch (Exception e) {
            System.out.println(e.getMessage());
            consumerHandler.consumerFileSaver("resourse//newConsumer.txt");
			consumerHandler.consumerFileSaver("resourse//Consumer.txt");
			System.err.println("Program Ended");
			loop=false;
		}
		
		
	}
	
	
}






}
