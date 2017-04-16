package com.test;

import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.Ppage;

public class PpageTest extends BaseTest {
	
private Ppage pp;
	
	@BeforeClass
	public void beforeClass(){
		
		pp = new Ppage(driver);
	}
	@Parameters({"username","password"})
	@Test
	public void testLoginPage(String uName,String pwd){
		
     pp.getLoginPage(uName, pwd);
     
     driver.takeScreenshot("user login");
     
		
	}
	@Test
	public void testPresentationPage(String username,String password){
		
		boolean actual = pp.presentationPage(username, password);
		
		assertTrue(actual);
		
		driver.takeScreenshot("presentationPage");
	}
	}


