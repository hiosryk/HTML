package com.kitri.jdbctest;

import java.io.*;
import java.util.Properties;

public class PropertiesTest {
	
	public static void main(String[] args) {
		Properties prop = new Properties();
		try {
			prop.load(new FileReader(new File("src\\com\\kitri\\jdbctest\\test.properties")));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		String name = prop.getProperty("name_kor");
		System.out.println(name);
	}
	
		
	
}

