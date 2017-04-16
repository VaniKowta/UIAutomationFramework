package com.test;

import static org.testng.AssertJUnit.assertEquals;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.LoginPage;
import com.util.ExcelConfig;

public class LoginPageTest extends BaseTest {

private static Logger log = Logger.getLogger(LoginPageTest.class);	
	
private LoginPage lp;

	
	@BeforeClass
	public void beforeClass(){
		
		lp = new LoginPage(driver);
	}
	@DataProvider(name="data")
	public Object[][] getLoginData(){
		
		Object[][]logindata = ExcelConfig.getData("loginData");
		
		return logindata;
		
	}
	
	@Test(dataProvider = "data")
	public void testUserLogin(String username,String password,String expected){
		
	log.info("user login ");	
		
	assertEquals(lp.userLogin(username, password),expected);
	
	driver.takeScreenshot("userlogin");
	}
	

}
