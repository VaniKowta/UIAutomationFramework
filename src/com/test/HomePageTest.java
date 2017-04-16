package com.test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.HomePage;

public class HomePageTest extends BaseTest {
	
private HomePage hp;
	
	@BeforeClass
	public void beforeClass(){
		
		hp = new HomePage( driver);
		
	}
	@Test
	public void testSocialLinks(){
		
    assertEquals(4,hp.getSocialIcons());
    
    //TakeScreenshotUtil.takeScreenshot("SocialIcons");
    driver.takeScreenshot("SocialIcons");
    
	}
	
	@Test
	public void testIsSliderPresent(){
		
		assertTrue(hp.isSliderPresent());
	}
	
	@Test
	public void testCountSliders(){
		
		assertEquals(hp.countSliders(),6);
		
		driver.takeScreenshot("sliders");
		
	}
	
	/*@Test
	public void testLoginLink(){
		
		assertEquals(hp.clickLogin(),"http://whiteboxqa.com/login.php");
	}*/
	@Test
	public void testFbPageLink(){
		
		boolean fbPage = hp.getFaceBookPage();
		
		assertTrue(fbPage);
		
		driver.takeScreenshot("fbpage");
		
		
		
		
	}

}
