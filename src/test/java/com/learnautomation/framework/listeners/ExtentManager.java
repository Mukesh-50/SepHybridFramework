package com.learnautomation.framework.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager 
{
	
	 private static ExtentReports extent;
	    
	    public static ExtentReports getInstance() 
	    {
	    	if (extent == null)
	    	{
	    		createInstance(System.getProperty("user.dir")+"/Reports/Report"+System.currentTimeMillis()+".html");
	    	}
	    	
	        return extent;
	    }
	    
	    public static ExtentReports createInstance(String fileName)
	    {
	        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
	        htmlReporter.config().setTheme(Theme.DARK);
	        htmlReporter.config().setDocumentTitle("Automation Report");
	        htmlReporter.config().setEncoding("utf-8");
	        htmlReporter.config().setReportName("Automation Report");
	        
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        
	        return extent;
	    }

}
