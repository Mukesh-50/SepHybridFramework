package com.learnautomation.framework.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.learnautomation.framework.base.BaseClass;
import com.learnautomation.framework.helper.DataGenerator;
import com.learnautomation.framework.pages.LoginPage;
import com.learnautomation.framework.pages.Signout;

public class LoginTest extends BaseClass{
	
	LoginPage login;
	Signout signout;
	public WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		driver=getDriver();
		login=new LoginPage(driver);
		signout=new Signout(driver);
	}
	
	@Test(dataProvider="SingleLogin",dataProviderClass=DataGenerator.class)
	public void loginWithAdmin(String uname,String pass)
	{
		login.loginToApplication(uname,pass);	
		signout.logOut();
	}

}
