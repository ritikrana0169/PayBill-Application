package com.paybeel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsumerHandler {
	
	public List<Consumer> newConsumerList= getConsumerList("resourse//newConsumer.txt");
	public List<Consumer> consumerList=getConsumerList("resourse/Consumer.txt");	
	
	public void newConsumerRegister() {
		boolean loop1=true;
		while (loop1) {
			Scanner sc=new Scanner(System.in);
			
			System.out.println("--------------------------");
			System.out.println("1: Register New Consumer");
			System.out.println("2: Back");
			System.out.println("0: Exit");
			System.out.println("--------------------------");
			int n=sc.nextInt();
			if(n==1) {
				System.out.println("newRegist");
				if(newConsumerList.size()>0) {
					boolean isRegistered = registerMethod(newConsumerList.get(newConsumerList.size()-1));
					if(isRegistered) {
						newConsumerList.remove(newConsumerList.size()-1);
					}
				}
				else {
					System.out.println("All Consumer are registered");	
				}
			}else if(n==2) {
				System.out.println("Back");
			}else {
				System.out.println("Exit");
			}
			
		}
	}
	
	public boolean  registerMethod(Consumer consumer) {
		System.out.println("here are details of Consumer");
		System.out.println(consumer.getFirstName() + "--" + consumer.getLastName());
		System.out.println(consumer.getAddress().toString());
		System.out.println(consumer.getEmail());
		System.out.println(consumer.getMobileNumber());
		
		System.out.println("1 : Approve Consumer Request and Provide user name");
		System.out.println("2 : Reject Consumer Request");
		
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		if(n==1) {
			boolean loop = true;
			while(loop) {
				
			}
			
			return true;
		}
		else if (n==2) {
			
			
			return true;
		}
		else {
			System.out.println("wrong Selection");
			return false;
		}
		
		
	}
	
	
	public List<Consumer> getConsumerList(String fileLocation){
		List<Consumer> consumerList=new ArrayList<>();
		
		try {
			
			FileReader fw = new FileReader(fileLocation);
			
			BufferedReader br = new BufferedReader(fw);
			
			String line=br.readLine();
			
			while (line !=null) {
				String[] consumerArray=line.split(":");
//				System.out.println(consumerArray.toString());
				Consumer crr=new Consumer(consumerArray[0],consumerArray[1],consumerArray[2],consumerArray[3]
						,consumerArray[4],consumerArray[5],consumerArray[6]);
				line=br.readLine();
                consumerList.add(crr);				
			}
			
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			System.out.println("Error");
		}
        
		return consumerList;
	}
	
	
//public Consumer verifyConsumer(List<Consumer> consList) {
//		
//	}
public boolean consumerFunction() {
	boolean loop=true;
	while(loop) {
		System.out.println("------------------------");
		System.out.println("1: User Login");
		System.out.println("2: User SignUp");
		System.out.println("9: Back/SignOut");
		System.out.println("0: Exit ");
    	System.out.println("-------------------------");
		Scanner sc=new Scanner (System.in);
		int n=sc.nextInt();
		if(n==0) {
			consumerFileSaver("resourse//newConsumer.txt");
			consumerFileSaver("resourse//Consumer.txt");
			loop=false;
			
		}else if(n==9) {
			break;
		}else if(n==2) {
			Consumer consumerD1=new Consumer();
			consumerD1.consumerEntry(); 
			newConsumerList.add(consumerD1);
//			userSignIn();
		}
//		else if(n==1) {
//			userLogIn();
//		}
			
		
	}
	return loop;
}

public void printAllConsumer() {
	for(int i=0; i<consumerList.size();i++ ) {
		System.out.println(consumerList.get(i).toStringSecure());
	}
}

public void consumerFileSaver(String location) {
	try {
		
		File f=new File(location);
		boolean loop=true;
		while(loop) {
			
			if(f.exists()) {
//		        PrintWriter fileCreate=new PrintWriter("resourse//newConsumer.txt");
		        FileWriter fr = new FileWriter(f, true);
		        BufferedWriter fileCreate = new BufferedWriter(fr);
		       
//		        pr.println("data");
				if(location.contains("newConsumer")) {
					for(int i =0; i<newConsumerList.size();i++) {
						fileCreate.write(newConsumerList.get(i).toString());
						fileCreate.write("\n");
					}
				}
				else {
					for(int i =0; i<consumerList.size();i++) {
						fileCreate.write(consumerList.get(i).toString());
						fileCreate.write("\n");
						}
				}
				
				fileCreate.flush();
				fileCreate.close();
				fr.close();
				loop=false;
				
				
				
				
				
			}else {
				f.createNewFile();
			}
		}
		
	} catch (Exception e) {
		System.out.println("Error while Saving File");
		System.out.println(e);
	}
	
}

}
