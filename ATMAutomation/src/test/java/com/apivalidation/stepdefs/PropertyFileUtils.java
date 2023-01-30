package com.apivalidation.stepdefs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import junit.framework.Assert;

public class PropertyFileUtils {
	
	Properties properties;
	String filePath;
	
	
	/**
	 * This Constructor load property File
	 * @param propertyFilePath
	 */
	
	
	public PropertyFileUtils(String propertyFilePath) {
		BufferedReader reader;
		this.filePath=propertyFilePath;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties= new Properties();
			reader.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			Assert.fail();
		}catch(IOException e1) {
			e1.printStackTrace();
			Assert.fail();
		}
	}
	
	/**
	 * @return Properties
	 */
	public String getProperty(String propertyname) {
		return properties.getProperty(propertyname);
	}
	
	

}
