package com.paybeel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataClass {
	
	
public void showAllConsumer() throws IOException {
	FileReader f=new FileReader("C:\\Users\\Ritik Rana\\Desktop\\holy-whip-3101\\resourse\\df4.txt");
	BufferedReader br=new BufferedReader(f);
	String line=br.readLine();
	
        System.out.println("|---------All Consumer List----------|");
        System.out.println();
    while(line != null){
//        System.out.println(line);
        String[] str= line.split(":");
        String[] addr=str[2].split(",");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("| Name"+"-"+str[0]+" "+str[1]);
        System.out.println("| ---------Address-----------------|");
        System.out.println("| Building -"+addr[0]+" "+addr[1]);
        System.out.println("| LandMark/Street -"+addr[2]+" "+addr[3]);
        System.out.println("| City/State/Pin  -"+addr[4]+" "+addr[5]+" "+addr[6]);
        System.out.println("| ---------------------------------|");
        System.out.println();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
        line=br.readLine();
    }
    br.close();
    System.out.println("-------------------------------------|");
//    System.out.println("0 : Exit"); 
}
	public static void main(String[] args) throws IOException {
		DataClass dC=new DataClass();
		dC.showAllConsumer();
	}
	
	
}
