package com.learnautomation.framework.helper;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility 
{
	
	public static void waitAndType(WebDriver driver,By locator,String text,String logInfo)
	{
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(text);
		System.out.println("LOG:INFO- "+logInfo);
	}
	
	public static void waitAndClick(WebDriver driver,By locator,String logInfo)
	{
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(locator)).click();
		System.out.println("LOG:INFO- "+logInfo);
	}
	
	
	public static void wait(int seconds)
	{
		System.out.println("LOG:INFO- Waiting for "+seconds + " seconds");
		try 
		{
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			
		}
	}
	
	
	public static String captureScreenshot(WebDriver driver)
	{
		String path=System.getProperty("user.dir")+"/Screenshots/"+System.currentTimeMillis()+".png";
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		try 
		{
			FileHandler.copy(src, new File(path));
			
		} 
		catch (IOException e) 
		{
			System.out.println("Failed to capture screenshot "+e.getMessage());
		}
		
		return path;
	}
	
	
	public static String captureScreenshot64(WebDriver driver) {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		String src=ts.getScreenshotAs(OutputType.BASE64);
		
		return "data:image/png;base64,"+src;
	}
	
	
	
}
