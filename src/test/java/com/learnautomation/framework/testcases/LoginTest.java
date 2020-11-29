package com.learnautomation.framework.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.learnautomation.framework.base.BaseClass;
import com.learnautomation.framework.helper.DataGenerator;
import com.learnautomation.framework.pages.LoginPage;
import com.learnautomation.framework.pages.Signout;

public class LoginTest extends BaseClass{
	
	LoginPage login;
	Signout signout;
	
	@BeforeMethod
	public void setup()
	{
		login=new LoginPage(driver);
		signout=new Signout(driver);
	}
	
	
	@Test(dataProvider="LoginData",dataProviderClass=DataGenerator.class)
	public void loginWithAdmin(String uname,String pass)
	{
		login.loginToApplication(uname,pass);	
		signout.logOut();
	}
	
	/*@Test(dataProvider="SingleLogin",dataProviderClass=DataGenerator.class)
	public void loginWithAdmin(String uname,String pass,String prod,String quan,String description)
	{
		login.loginToApplication(uname,pass);	
		shop.addProduct(prod, quan, description);
		signout.logOut();
	}*/
	
}
