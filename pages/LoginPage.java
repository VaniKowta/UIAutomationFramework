package com.pages;



import com.base.BasePage;
import com.pages.HomePage;
import com.util.PageDriver;
import com.util.WblBy;

public class LoginPage extends BasePage {
	
	
	HomePage hp;

	public LoginPage(PageDriver driver) {
		super(driver);
		hp = new HomePage(driver);
	}
	
    public void clickLogin(){
    	
    	//hp.clickLogin();
		
		driver.findElement(WblBy.getByObject("xpath-loginpage-link")).click();
		
	}
	
	public String userLogin(String Uname,String pwd){
		
		
	    driver.findElement(WblBy.getByObject("xpath-loginpage-link")).click();
		
		driver.implicitWait();
		
		driver.findElement(WblBy.getByObject("id-loginpage-user")).sendKeys(Uname);
		
		driver.findElement(WblBy.getByObject("id-loginpage-pwd")).sendKeys(pwd);
		
		driver.findElement(WblBy.getByObject("id-loginpage-btn")).click();
		
		String getCurrentUrl=driver.getCurrentUrl();
		
		
		return getCurrentUrl;
		}	

}
