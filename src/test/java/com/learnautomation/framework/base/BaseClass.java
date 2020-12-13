package com.learnautomation.framework.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	
	@Parameters({"Browser","stagingURL"})
	@BeforeClass
	public WebDriver startBrowser(String browser,String appURL)
	{
		
		System.out.println("********** Starting Session **********");
		
		System.out.println("Test is running on "+browser);
		System.out.println("URL "+appURL);
		
		//String browser=ConfigReader.getProperty("Browser");
		//String appURL=ConfigReader.getProperty("stagingURL");
	
		if(browser.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("FF"))
		{
			System.setProperty("webdriver.gecko.driver", "");
			driver=new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println("********** Starting Session **********");
		
		return driver;
	}
	
	@AfterClass
	public void closeBrowser()
	{
		System.out.println("********** Closing Session **********");
		driver.quit();
		System.out.println("********** Session Closed **********");
	}
	
}
