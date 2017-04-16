package com.util;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class PageDriver {
	
	ConfigUtils configutils;
	
	WebDriver driver;
	
	public PageDriver(ConfigUtils config){
		
	this.configutils  = config;
	
	initializeBrowser();
	}
	
	public void initializeBrowser(){
		
		String browser = configutils.BROWSER;
		
		switch(browser){
		
		case "firefox":
			startFirefox();
			break;
		case "chrome":
			startChrome();
			break;
		case" ie":
			startIE();
			break;
		default:
			startHTML();
			break;
		}
		driver.get(configutils.URL);

		}
	
	public void startFirefox(){
		
		this.driver = new FirefoxDriver();
	}
	
	public void startChrome(){
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rkowt\\workspace\\AutomationWhiteboxQa\\resources\\chromedriver.exe");
		this.driver = new ChromeDriver();
	}
	
	public void startIE(){
		
		System.setProperty("webdriver.ie.driver", "C:\\Users\\rkowt\\workspace\\AutomationWhiteboxQa\\resources\\IEDriverServer.exe");
		this.driver = new InternetExplorerDriver();
	}
	
	public void startHTML(){
		
		this.driver = new HtmlUnitDriver();
	}
	
	public void get(String url){
		
	driver.get(url);	
	}
	
	public WebElement findElement(By by){
		
	return driver.findElement(by);	
	}
	
	public List<WebElement> findElements(By by){
		
		return driver.findElements(by);
	}
	
	public String getCurrentUrl(){
		
		return driver.getCurrentUrl();
	}

	public String getWindowHandle() {
		return driver.getWindowHandle();
	}

	public Set<String> getWindowHandles() {
		return driver.getWindowHandles();
	}

	public Object switchToWindow(String window) {
		return driver.switchTo().window(window);
	}
	
	public void implicitWait(){
		
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
	}
	
	
	

	/*public void mouseHover(){
		
		Actions action = new Actions(driver);
		
        WebElement resourceElement = driver.findElement(WblBy.getByObject("class-ppage-resources"));
		
		implicitWait();
		
		action.moveToElement(resourceElement).build().perform();
	}*/
	
	  public Actions initializeAction()
	    {
	        return new Actions(driver);
	    }
	
   public void takeScreenshot(String screenShotName){
	
	   TakeScreenshotUtil.captureScreenShot(driver, screenShotName);
		
	}
	
	public void close(){
		
		driver.close();
	}

}
