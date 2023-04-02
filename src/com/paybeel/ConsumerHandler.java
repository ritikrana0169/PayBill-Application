package com.paybeel;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

public class ConsumerHandler {
	
	public List<Consumer> newConsumerList= getConsumerList("resourse//newConsumer.txt");
	public List<Consumer> consumerList=getConsumerList("resourse/Consumer.txt");	
	
	public boolean newConsumerRegister() {
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
				
				break;
			}else {
				consumerFileSaver("resourse//newConsumer.txt");
				consumerFileSaver("resourse//Consumer.txt");
			loop1 = false;
			
			}
			
		}
		return loop1;
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
		
				consumer=setUserNameByAdmin(consumer);
				consumerList.add(consumer);
			
			
			return true;
		}
		else if (n==2) {
			System.out.println("Consumer Rejected and deleted");
			
			return true;
		}
		else {
			System.out.println("wrong Selection");
			return false;
		}
		
		
	}
	
	public Consumer setUserNameByAdmin(Consumer consumer) {
		String user="";
		boolean loop = true;
		while(loop) {
		Integer num =(int) ((Math.random() * (9999 - 1000)) + 1000);
		user=consumer.getFirstName()+consumer.getLastName()+num.toString();
		loop=uniqueChecker(user);
		}
		consumer.setUserName(user);
		Integer num =(int) ((Math.random() * (9999 - 1000)) + 1000);
		user=consumer.getLastName()+consumer.getFirstName()+num.toString();
		consumer.setPassword(user);
		consumer.setStatus("active");
		
		return consumer;
		
	}
	
	public boolean uniqueChecker(String user) {
		for(int i=0;i<consumerList.size();i++) {
			if(consumerList.get(i).getUserName().equals(user)) {
				return true;
			}
			
		}
		return false;
	
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
						,consumerArray[4],consumerArray[5],consumerArray[6],consumerArray[7],consumerArray[8],consumerArray[9]);
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
	Consumer loginConsumer=null;
	boolean loop=true;
	boolean islogIn=false;
	while(loop) {
		System.out.println("------------------------");
		if(!islogIn) {
			System.out.println("1: User Login");
			System.out.println("2: User SignUp");
		}
		else {
			System.out.println("3: Pay Bill");
			System.out.println("4: transaction history");
		}
		
	
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
		else if(n==3) {
			ConsumerBill conBill =loginConsumer.getConsumerBillList()
					.get(loginConsumer.getConsumerBillList().size()-1);
			if(conBill.getStatus().equals("pending")) {
				System.out.println("1: Pay");
				System.out.println("2: Skip");
				int opt=sc.nextInt();
				if(opt==1) {
					conBill.setStatus("paid");
				}
			
			}
			else {
				System.out.println("Bill is Already Paid");
			}
			
		}
		else if(n==4) {
for(int i=0;i<loginConsumer.getConsumerBillList().size();i++) {
	System.out.println(loginConsumer.getConsumerBillList().get(i).toString());
}
		}
		else if(n==1) {
			loginConsumer=userLogIn();
			if(null!=loginConsumer) {
				islogIn=true;
			}
		}
			
		
	}
	return loop;
}

public Consumer userLogIn() {

	
	System.out.println(" ------------------");
	System.out.println("| Consumer User Name |");
	System.out.println(" ------------------");
	Scanner sc=new Scanner (System.in);
	
	String inputUserName=sc.nextLine();
	
		 System.out.println(" ---------------");
		System.out.println("| User Password |");
		 System.out.println(" ---------------");
		String inputUserPassword=sc.nextLine();
		for(int i=0;i<consumerList.size();i++) {
			if(consumerList.get(i).getUserName().equals(inputUserName) 
					&& consumerList.get(i).getPassword().equals(inputUserPassword)) {
				return consumerList.get(i);
			}

		}
		
		return null;

}

public void printAllConsumer() {
	for(int i=0; i<consumerList.size();i++ ) {
		System.out.println("-----------------------------------------------");
		System.out.println(consumerList.get(i).toStringSecure());
		System.out.println("-----------------------------------------------");
	}
}


public void generateBillForAllConsumer() {
	
	
	for(int i=0; i<consumerList.size();i++ ) {
	
		
		
		LocalDate d1 =  LocalDate.now();
		  LocalDate d2 = LocalDate.now();
		
		String[] daysInAMonth = {"31", "28", "31", "30", "31", "30", "31", "31", "30", "31", "30", "31" };
	    HashMap<String, String> months = new HashMap<String, String>();

	    // Add keys and values (Country, City)
	    months.put("JANUARY", "01");
	    months.put("FEBRUARY", "02");
	    months.put("MARCH", "03");
	    months.put("APRIL", "04");
	    months.put("MAY", "05");
	    months.put("JUNE", "06");
	    months.put("JULY", "07");
	    months.put("AUGUST", "08");
	    months.put("SEPTEMBER", "09");
	    months.put("OCTOBER", "10");
	    months.put("NOVEMBER", "11");
	    months.put("DECEMBER", "12");
	    
	    boolean isLeapYear = new GregorianCalendar().isLeapYear(d1.getYear());
		Month month = d1.getMonth();
		Integer monthInt= Integer.parseInt(months.get(month.toString()));
		String date="";
		Integer year = d1.getYear();
		  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		  

		  //convert String to LocalDate
		
		
		try{
			d1 = LocalDate.parse("01/"+months.get(month.toString())+"/"+year.toString(), formatter);
					
			
			if(isLeapYear && monthInt ==2) {
			  date = daysInAMonth[monthInt-1] +1;
			}
			else {
				 date = daysInAMonth[monthInt-1];
			}
			
			d2 =LocalDate.parse(date+"/"+months.get(month.toString())+"/"+year.toString(), formatter);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		if(consumerList.get(i).getConsumerBillList().isEmpty()) {


			
			ConsumerBill conBill = new ConsumerBill(consumerList.get(i).getFirstName()+" "+consumerList.get(i).getLastName(),"clear",0,d1,d2);
			
			consumerList.get(i).getConsumerBillList().add(conBill);
		}
		else {
			ConsumerBill prevBill = consumerList.get(i).getConsumerBillList().get(consumerList.get(i).getConsumerBillList().size()-1);
			ConsumerBill conBill;
			if(prevBill.getStatus().equals("pending")) {
				prevBill.setStatus("Dismissed");
				 conBill = new ConsumerBill(consumerList.get(i).getFirstName()+" "+consumerList.get(i).getLastName(),
						prevBill.getConsumerName(),prevBill.getAmount(),d1,d2);
			}
			else {
				 conBill = new ConsumerBill(consumerList.get(i).getFirstName()+" "+consumerList.get(i).getLastName(),
						prevBill.getConsumerName(),0,d1,d2);
			}
			
			
			
			
			
		
			consumerList.get(i).getConsumerBillList().add(conBill);
			
		}
	}
}
public void viewAllBillOfConsumer() {
	Consumer consumer = null;
	Scanner sc=new Scanner (System.in);
	 System.out.println("Enter user Name");
		String inputUserName=sc.nextLine();
		for(int i=0;i<consumerList.size();i++) {
			if(consumerList.get(i).getUserName().equals(inputUserName)) {
				consumer=consumerList.get(i);
				break;
			}
		}
		if(null!=consumer) {
			for(int i=0;i<consumer.getConsumerBillList().size();i++) {
				 System.out.println(consumer.getConsumerBillList().get(i).toStringForPrint());
			}
		}
}

public void deleteConsumer() {
	boolean isSet=false;
	Scanner sc=new Scanner (System.in);
	 System.out.println("Enter user Name");
		String inputUserName=sc.nextLine();
		for(int i=0;i<consumerList.size();i++) {
			if(consumerList.get(i).getUserName().equals(inputUserName)) {
				consumerList.get(i).setStatus("inactive");
				 System.out.println(consumerList.get(i).getUserName()+"Consumer is set to inactive");
				isSet=true;
				 break;
			}
		}
		if(!isSet) {
			 System.out.println("No User By this User name");
		}
		
}

public void viewAllBill() {
	
	
		
		for(int i=0;i<consumerList.size();i++) {
	

		if(!consumerList.get(i).getConsumerBillList().isEmpty()) {
			
			for(int j=0;j<consumerList.get(i).getConsumerBillList().size();j++) {
				 System.out.println(consumerList.get(i).getConsumerBillList().get(j).toStringForPrint());
			}
		}
		}
}


public void viewAllBillPaidAndPending() {
	List<ConsumerBill> consumerBillPaidList=new ArrayList<>();
	List<ConsumerBill> consumerBillPendingList=new ArrayList<>();
	
	
	for(int i=0;i<consumerList.size();i++) {


	if(!consumerList.get(i).getConsumerBillList().isEmpty()) {
		
		for(int j=0;j<consumerList.get(i).getConsumerBillList().size();j++) {
			 
			if(consumerList.get(i).getConsumerBillList().get(j).getStatus().equals("pending")) {
				consumerBillPendingList.add(consumerList.get(i).getConsumerBillList().get(j));
			}
			else if(consumerList.get(i).getConsumerBillList().get(j).getStatus().equals("paid")) {
				consumerBillPaidList.add(consumerList.get(i).getConsumerBillList().get(j));
			}
				
			
			System.out.println(consumerList.get(i).getConsumerBillList().get(j).toStringForPrint());
		}
	}
	}
	System.out.println("---------------------PAID---------------------------");
	for(int i =0;i<consumerBillPaidList.size();i++) {
		System.out.println(consumerBillPaidList.get(i).toStringForPrint());
		
	}
	
	System.out.println("---------------------PENDING---------------------------");
	for(int i =0;i<consumerBillPendingList.size();i++) {
		System.out.println(consumerBillPendingList.get(i).toStringForPrint());
		
	}
	
}


public void consumerFileSaver(String location) {
	try {
		
		File f=new File(location);
		boolean loop=true;
		while(loop) {
			
			if(f.exists()) {
//		        PrintWriter fileCreate=new PrintWriter("resourse//newConsumer.txt");
		        FileWriter fr = new FileWriter(f,false);
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
