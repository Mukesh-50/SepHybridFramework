package com.learnautomation.framework.testcases;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.learnautomation.framework.helper.Utility;

public class GridDemo  {
	
	@Test
	public void loginWithAdmin()
	{
		   String USERNAME = "mukeshotwani3";
		   String AUTOMATE_KEY = "s4GTbs4fFzQxJxzpzp2f";
		   String huburl = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";	
		   
		   DesiredCapabilities caps = new DesiredCapabilities();
	        
		   caps.setCapability("browserName", "iPhone");
		   caps.setCapability("device", "iPhone 12");
		   caps.setCapability("realMobile", "true");
		   caps.setCapability("os_version", "14");
		   caps.setCapability("name", "Test on IPhone 12 New");
		   caps.setCapability("browserstack.console", "errors");
		   caps.setCapability("browserstack.networkLogs", true);
		   
		   
		   WebDriver driver = null;
		   try 
		   {
			driver=new RemoteWebDriver(new java.net.URL(huburl), caps);
		} catch (MalformedURLException e) {
			System.out.println("LOG:FAIL- please check hub url again "+e.getMessage());
		}
		   
		   driver.get("http://www.google.com");
		   driver.findElement(By.name("q")).sendKeys("Selenium Grid 4.0");
		   Utility.wait(5);
		   driver.quit();
		   
	}

}
