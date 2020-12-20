package com.learnautomation.framework.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.learnautomation.framework.helper.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	
	public WebDriver getDriver()
	{
		return driver;
	}
	
	
	@Parameters({"Browser","stagingURL"})
	@BeforeClass
	public WebDriver startBrowser(String browser,String appURL)
	{
		
		
		
		System.out.println("********** Starting Session **********");
		
		System.out.println("Test is running on "+browser);
		System.out.println("URL "+appURL);
		
		//String browser=ConfigReader.getProperty("Browser");
		//String appURL=ConfigReader.getProperty("stagingURL");
	
		String huburl = "https://" + ConfigReader.getProperty("BSUSERNAME") + ":" + ConfigReader.getProperty("BSAUTOMATE_KEY") +"@"+ConfigReader.getProperty("HUBURL");
		
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
		else if(browser.equalsIgnoreCase("RemoteChromeMAC"))
		{
			System.out.println("LOG:INFO- Test Running on Browserstack-MAC");
			 DesiredCapabilities caps = new DesiredCapabilities();
			 caps.setCapability("os", "OS X");
			 caps.setCapability("os_version", "Big Sur");
			 caps.setCapability("browser", "Chrome");
			 caps.setCapability("browser_version", "latest");
			 try {
					driver=new RemoteWebDriver(new URL(huburl), caps);
				} catch (MalformedURLException e) {
					System.out.println("HUB URL is invalid "+e.getMessage());
				}
		}
		else if(browser.equalsIgnoreCase("RemoteChromeWin"))
		{
			System.out.println("LOG:INFO- Test Running on Browserstack-Windows");
			 DesiredCapabilities caps = new DesiredCapabilities();
			 caps.setCapability("os", "Windows");
			 caps.setCapability("os_version", "10");
			 caps.setCapability("browser", "Chrome");
			 caps.setCapability("browser_version", "latest");
			 try {
				driver=new RemoteWebDriver(new URL(huburl), caps);
			} catch (MalformedURLException e) {
				System.out.println("HUB URL is invalid "+e.getMessage());
			}
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
