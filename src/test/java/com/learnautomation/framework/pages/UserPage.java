package com.learnautomation.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UserPage {

	WebDriver driver;
	
	public UserPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	By adminTab=By.xpath("//b[text()='Admin']");
	By addButton=By.xpath("//input[@value='Add']");
	By empName=By.xpath("//*[text()='Employee Name']//following::input[1]");
	By userName=By.xpath("//*[text()='Username']//following::input[1]");
	By password =By.xpath("//*[text()='Password']//following::input[1]");
	By confirmPassword =By.xpath("//*[text()='Confirm Password']//following::input[1]");
	By userRole=By.xpath("//*[text()='User Role']//following::select[1]");
	By status=By.xpath("//*[text()='Status']//following::select[1]");
	By saveButton=By.xpath("//input[@value='Save']");
	
	public void addUser()
	{
		driver.findElement(adminTab).click();
		driver.findElement(addButton).click();
		new Select(driver.findElement(userRole)).selectByVisibleText("Admin");
		driver.findElement(empName).sendKeys("John Smith");
		driver.findElement(userName).sendKeys("Aswini_52");
		driver.findElement(password).sendKeys("Aswini_52");
		driver.findElement(confirmPassword).sendKeys("Aswini_52");
		driver.findElement(saveButton).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
}
