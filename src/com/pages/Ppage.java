package com.pages;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.base.BasePage;
import com.util.PageDriver;
import com.util.WblBy;

public class Ppage extends BasePage {
	
	private static Logger log = Logger.getLogger(Ppage.class);

	LoginPage lp;

	public Ppage(PageDriver driver) {
		super(driver);
		lp = new LoginPage(driver);
    }
	
	public boolean getLoginPage(String uname,String pwd){
		
		boolean status = false;
		
		this.lp = new LoginPage(driver);
		
		lp.clickLogin();
		
		driver.implicitWait();
		
		driver.findElement(By.id("username")).sendKeys(uname);
		
		driver.findElement(By.id("password")).sendKeys(pwd);
		
		driver.findElement(By.id("login")).click();
		
		driver.implicitWait();
	
		return status;
	}
		
	public boolean presentationPage(String uname,String pwd){
		
		boolean status = false;
        
		try
		{
			
		Ppage pp = new Ppage(driver);
		
		status = pp.getLoginPage(uname, pwd);
		
		if(status){

		Actions actions = driver.initializeAction();
		
        WebElement resourceElement = driver.findElement(WblBy.getByObject("xpath-ppage-resources"));
        
        actions.moveToElement(resourceElement).perform();
		
		driver.implicitWait();
		
		driver.findElement(WblBy.getByObject("xpath-ppage-presentation")).click();
	      
	    }
		}
		catch(Exception e){
			
		status = false;	
		
		log.equals(e);
	    
		}
		return status;
	}
}
	
	
	
