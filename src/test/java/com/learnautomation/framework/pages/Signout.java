package com.learnautomation.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.learnautomation.framework.helper.Utility;

public class Signout {

	WebDriver driver;
	
	By logout=By.xpath("//a[text()='Logout']");
	By welcomeLink=By.xpath("//a[@id='welcome']");
	
	public Signout(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void logOut()
	{
		Utility.waitAndClick(driver, welcomeLink, "Click on Welcome Link");
		Utility.waitAndClick(driver, logout, "Click on logout");
	}
	
}
