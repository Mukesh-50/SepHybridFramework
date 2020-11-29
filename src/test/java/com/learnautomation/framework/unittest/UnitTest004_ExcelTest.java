package com.learnautomation.framework.unittest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.learnautomation.framework.helper.ExcelReader;

public class UnitTest004_ExcelTest {

	@Test
	public void checkConfig() {
		Assert.assertTrue(new ExcelReader().getCellData("Data1", 0, 0) != null);
	}

}
