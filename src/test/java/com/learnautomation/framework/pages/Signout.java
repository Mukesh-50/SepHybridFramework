package com.learnautomation.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

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
		driver.findElement(welcomeLink).click();
		driver.findElement(logout).click();
	}
	
}
