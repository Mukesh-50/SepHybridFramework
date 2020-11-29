package com.learnautomation.framework.helper;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility 
{
	
	public static String captureScreenshot(WebDriver driver)
	{
		String path=System.getProperty("user.dir")+"/Screenshots/"+System.currentTimeMillis()+".png";
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		try 
		{
			FileHandler.copy(src, new File(path));
		} catch (IOException e) 
		{
			System.out.println("Failed to capture screenshot "+e.getMessage());
		}
		
		return path;
	}
	
}
