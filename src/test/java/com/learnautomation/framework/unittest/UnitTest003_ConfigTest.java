package com.learnautomation.framework.unittest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.learnautomation.framework.helper.ConfigReader;

public class UnitTest003_ConfigTest  {

	@Test
	public void checkConfig()
	{
		Assert.assertTrue(ConfigReader.getProperty("Browser")!=null);
		
		//Assert.assertFalse(ConfigReader.getProperty("Browser")==null);
	}

}
