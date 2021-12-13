package com.aaptad.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadFromNotePad {
	public static void main(String[] args) {
		setName("pyaari");
		setName("umesh");
		
	}
	static void setName(String name) {
		BufferedReader br;
		String st;
		File file=new File("D:\\testingfile.txt");
		try {
			br=new BufferedReader(new FileReader(file));
			while((st=br.readLine())!=null) {
				System.out.println(st);
			}
			FileWriter fw=new FileWriter(file,true);
			//for(int i=1;i<10;i++)
				fw.write("\n"+name);
			fw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
