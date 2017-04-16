package com.pages;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.base.BasePage;
import com.util.PageDriver;
import com.util.WblBy;

public class HomePage extends BasePage {
	
	
private static Logger log = Logger.getLogger(HomePage.class);	
	
   public HomePage(PageDriver driver) {
		
		super(driver);
	}

   public int getSocialIcons(){
		
	int count = 0;
	try{
		
	List <WebElement> sociallinks = driver.findElements(WblBy.getByObject("css-homepage-icons"));
		
	if(!sociallinks.isEmpty()){
			
	 count = sociallinks.size();
	}
	}
	catch(Exception e){
		log.error(e);
	}
	return count;
		/*int icons = driver.findElements(WblBy.getByObject("css-homepage-icons")).size();
		
		return icons;*/
	}
	
	public boolean isSliderPresent(){
		
	
	boolean isSliderPresent = driver.findElements(WblBy.getByObject("id-homepage-slides")).isEmpty() ? false : true;
	
	return isSliderPresent;
	
	}
	
	public int countSliders(){
		
		int sliders = 0;
		
		try{
			
	   sliders = driver.findElements(WblBy.getByObject("xpath-homepage-slidescount")).size();
	}
	catch(NoSuchElementException e){
		
	log.error(e);	
	}
		return sliders;
	}
	public boolean getFaceBookPage(){
		
		 boolean status = false;
		 
     driver.findElement(WblBy.getByObject("xpath-homepage-facebooklink")).click();
     
     String parentWindow = driver.getWindowHandle();
     
    Set<String> handles = driver.getWindowHandles();
    
    for(String childWindow : handles){
    	
    	if(!handles.equals(parentWindow)){
    		
    	driver.switchToWindow(childWindow);
    		
    	status = driver.getCurrentUrl().contains("facebook")?true:false;
    	
    	driver.implicitWait();
    	
    	driver.switchToWindow(parentWindow);

    	}
    }
		 return status;
	}
	
  public String clickLogin(){
	  
  driver.findElement(WblBy.getByObject("id-homepage-clicklogin"));
  
  return driver.getCurrentUrl();
}
	
	
}


