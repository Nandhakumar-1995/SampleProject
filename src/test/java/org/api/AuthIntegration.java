package org.api;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class AuthIntegration {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		FileInputStream stream = new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
		
		
	}

}
