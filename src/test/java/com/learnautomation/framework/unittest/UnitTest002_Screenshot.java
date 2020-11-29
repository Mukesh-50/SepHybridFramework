package com.learnautomation.framework.unittest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.learnautomation.framework.base.BaseClass;

public class UnitTest002_Screenshot extends BaseClass{

	@Test
	public void checkBrowser()
	{
		Assert.assertTrue(driver!=null);
	}

}
