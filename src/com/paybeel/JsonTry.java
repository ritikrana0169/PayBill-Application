package com.paybeel;
import java.io.*;
public class JsonTry {

	public static void main(String[] args) throws IOException {
//	       FileReader fr=new FileReader("billing.txt");    
//	          int i;    
//	          while((i=fr.read())!=-1)    
//	          System.out.print((char)i);    
//	          fr.close();    
		try {
			FileReader fw = new FileReader("resourse//df4.txt");

	        BufferedReader br = new BufferedReader(fw);

	        String line=br.readLine();

	        String[] consumerArray=line.split(":");
	        Consumer crr=new Consumer(consumerArray[0],consumerArray[1],consumerArray[2],consumerArray[3]
	        		,consumerArray[4],consumerArray[5],consumerArray[6]);
	        
	        System.out.println(crr.getAddress().getCity());
//	    crr.setFirstName("Billu");
//	    crr.setLastName("baber");
//	    crr.getAddress().setCity("nallapur");
	        br.close();
				FileWriter nF=new FileWriter("resourse//df5.txt");
				BufferedWriter fileCreate=new BufferedWriter(nF);
				
				fileCreate.write(crr.toString());
				fileCreate.flush();
				fileCreate.close();
				
				
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("error");
			e.printStackTrace();
		}
		
	    }    
		
	}
