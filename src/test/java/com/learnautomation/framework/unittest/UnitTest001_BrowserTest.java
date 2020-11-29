package com.learnautomation.framework.unittest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.learnautomation.framework.base.BaseClass;

public class UnitTest001_BrowserTest extends BaseClass{

	@Test
	public void checkBrowser()
	{
		Assert.assertTrue(driver.findElement(By.id("txtUsername")).isDisplayed());
	}
	
}
