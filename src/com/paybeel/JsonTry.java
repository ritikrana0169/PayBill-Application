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
			File myfile=new File("resourse\\df2.txt");
			if(myfile.createNewFile()) {
				System.out.println("File Created"+myfile.getName());
			}else {
				System.out.println("file Already hai");
			}
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("error");
			e.printStackTrace();
		}
		
	    }    
		
	}
