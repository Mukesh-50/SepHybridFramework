package com.learnautomation.framework.listeners;

import java.lang.reflect.Field;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.learnautomation.framework.helper.Utility;

public class ExtentTestNGITestListener implements ITestListener{

	ExtentReports extent=ExtentManager.getInstance();
	
	ExtentTest child;
	
	ThreadLocal<ExtentTest> parentTest=new ThreadLocal<ExtentTest>();
	
	
	public synchronized void onTestStart(ITestResult result) {
		System.out.println("********** Starting Test*********");
		ExtentTest parent=extent.createTest(result.getMethod().getMethodName());
		parentTest.set(parent);
		System.out.println("********** Test Started*********");
		
	}

	public synchronized void onTestSuccess(ITestResult result) {
		System.out.println("********** Test Successful*********");
		parentTest.get().pass("Test Completed Successfully");
		
	}

	public void onTestFailure(ITestResult result) 
	{
		
		try {
		System.out.println("********** Test Failed*********"+result.getThrowable().getMessage());
		
			WebDriver driver=null;
		
			Field myField=result.getTestClass().getRealClass().getDeclaredField("driver");
		
			driver=(WebDriver)myField.get(result.getInstance());
			
			System.out.println("Driver value is "+driver);

			parentTest.get().fail("Test Failed "+result.getThrowable().getMessage(),
					
			MediaEntityBuilder.createScreenCaptureFromBase64String(Utility.captureScreenshot64(driver)).build());
			
		} catch (Exception e) {
			
			System.out.println("Failed to attach screenshot in extent report");
		}
		
	}

	public synchronized void onTestSkipped(ITestResult result) {
		System.out.println("********** Test Skipped*********"+result.getThrowable().getMessage());

		parentTest.get().skip("Test Skipped "+result.getThrowable().getMessage());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		
		
	}

	public synchronized void onFinish(ITestContext context) {
		extent.flush();
		System.out.println("********** Writing Result to report*********");
		
	}

	

}
