package com.learnautomation.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.learnautomation.framework.helper.Utility;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	By username=By.id("txtUsername");
	By password=By.name("txtPassword");
	By loginButton=By.xpath("//input[@value='LOGIN']");
	
	
	public void enterUsername(String user)
	{
		driver.findElement(username).sendKeys(user);
	}
	
	public void enterPassword(String pass)
	{
		driver.findElement(password).sendKeys(pass);
	}
	

	public void clickOnLoginButton()
	{
		driver.findElement(loginButton).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
	}
	
	
	public void loginToApplication(String user,String pass)
	{
		Utility.waitAndType(driver, username, user, "Enter username");
		Utility.waitAndType(driver, password, pass, "Enter password");
		Utility.waitAndClick(driver, loginButton, "press login button");
		/*driver.findElement(username).sendKeys(user);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginButton).click();*/
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
	}
	
}
