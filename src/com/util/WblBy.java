package com.util;

import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.By;

public class WblBy {
	
	private static final String LOCATORS_FILE = "C:\\Users\\rkowt\\workspace\\AutomationWhiteboxQa\\resources\\locators.properties";
	
	public static Properties prop;
	
	public static void loadProperties(){
		
		 prop = new Properties();
		
		try {
			prop.load(new FileReader(LOCATORS_FILE));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static By getByObject(String locatorkey){
		
		By by = null;
		
		String value = (String)prop.getProperty(locatorkey);
		
		if(locatorkey.startsWith("id")){
			
			by = By.id(value);
			
		}else if(locatorkey.startsWith("xpath")){
			
			by = By.xpath(value);
		
		}else if(locatorkey.startsWith("name")){
			
			by = By.name(value);
			
		}else if(locatorkey.startsWith("class")){
			
			by = By.className(value);
			
		}else if(locatorkey.startsWith("css")){
			
			by = By.cssSelector(value);
			
		}else if(locatorkey.startsWith("link")){
			
			by = By.linkText(value);
			
		}else if(locatorkey.startsWith("plink")){
			
			by = By.partialLinkText(value);
			
		}else if(locatorkey.startsWith("tag")){
			
			by = By.tagName(value);
		}
		else
			by = By.cssSelector(value);
		
		return by;
	}

}
