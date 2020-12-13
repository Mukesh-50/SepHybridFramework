package com.learnautomation.framework.pages;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class EmployeePage {

WebDriver driver ;

public EmployeePage(WebDriver driver)
{
this.driver=driver;
PageFactory.initElements(driver,this);
}

//Locators of Web Elements used in Employee Page
//WebElement addEmployee = driver.findElement(By.xpath("//input[@value='Add']"));
WebElement firstName =  driver.findElement(By.xpath("//*[text()='Full Name']//following::input[1]"));
WebElement middleName = driver.findElement(By.xpath("//*[text()='Full Name']//following::input[2]"));
WebElement lastName = driver.findElement(By.xpath("//*[text()='Full Name']//following::input[3]"));
WebElement empID = driver.findElement(By.xpath("//*[text()='Employee Id']//following::input[1]"));
//addEmployee.click();
WebElement photo =driver.findElement(By.id("photofile"));
WebElement checkbox = driver.findElement(By.cssSelector("input[type='checkbox']") );
WebElement userNameCreation = driver.findElement(By.xpath("//*[text()='User Name']//following::input[1]"));
WebElement passwordCreation = driver.findElement(By.xpath("//*[text()='Password']//following::input[1]"));
WebElement passwordConfirmation = driver.findElement(By.xpath("//*[text()='Confirm Password']//following::input[1]"));
WebElement status = driver.findElement(By.id("status"));
String status_in_dropdown ="enabled" ;
java.util.List<WebElement> options = status.findElements(By.tagName("option"));
WebElement saveButton = driver.findElement(By.id("btnSave"));
WebElement PIM_Tab = driver.findElement(By.id("menu_pim_viewPimModule")) ;

public void navigate_to_EmployeePage(){
PIM_Tab.click();
}

public void selectDropdown(String status_to_pass){


for(WebElement ele:options)
{
if(ele.getText().equals(status_to_pass))
{
ele.click();
break;
}
}

}

public void addEmployee(String first_name, String middle_name,String last_name,String emp_ID,String photo_file,String user_name_creation,String password_creation, String status_dropdown){

firstName.sendKeys(first_name);
middleName.sendKeys(middle_name);
lastName.sendKeys(last_name);
empID.sendKeys(emp_ID);
photo.sendKeys(System.getProperty("user.dir")+ photo_file);
//photo.sendKeys(System.getProperty("user.dir")+"/Capture.png");
checkbox.click();
userNameCreation.sendKeys(user_name_creation);
passwordCreation.sendKeys(password_creation);
passwordConfirmation.sendKeys(password_creation);
selectDropdown(status_in_dropdown);
saveButton.submit();

}
}

