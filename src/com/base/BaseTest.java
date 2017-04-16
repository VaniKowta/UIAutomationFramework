package com.base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.util.ConfigUtils;
import com.util.PageDriver;
import com.util.WblBy;

public abstract class BaseTest {
	
protected PageDriver driver;
	
	@BeforeSuite
	public void setUp(){
		
		ConfigUtils _config = new ConfigUtils();
		
		WblBy.loadProperties();
		
		driver = new PageDriver(_config);
		
		}
	@AfterSuite
	public void close(){
		
		driver.close();
	}


}
