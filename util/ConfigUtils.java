package com.util;

import java.io.FileReader;
import java.util.Properties;

public class ConfigUtils {
	
private static final String CONFIG_PATH ="C:\\Users\\rkowt\\workspace\\AutomationWhiteboxQa\\resources\\config.properties";
	
	public String BROWSER;
	public String URL;
	
	public ConfigUtils(){
		
		Properties  prop = new Properties();
	
		
		try {
			prop.load(new FileReader(CONFIG_PATH));
			
			BROWSER=(String)prop.get("browser");
			
			URL=(String)prop.getProperty("url");
		 
		} catch (Exception e) {
			
			e.getMessage();
		}
		
		
		
	}

}
