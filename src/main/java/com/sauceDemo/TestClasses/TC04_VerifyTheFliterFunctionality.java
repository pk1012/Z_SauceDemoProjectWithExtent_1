package com.sauceDemo.TestClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sauceDemo.POMClasses.POM_1_Home;

public class TC04_VerifyTheFliterFunctionality extends TestBaseClass
{
	@Test
	public void verifyTheFliterFunctionality() throws IOException
	{
		POM_1_Home hp = new POM_1_Home(driver);
		
		hp.clickOnFilter();
		log.info("Clicked on filter dropDown");

		hp.selectAt2(driver);
		log.info("Selected element at index 2");
		
		String actual = hp.getFilterText();
		String expected = "";
		
		Assert.assertEquals(actual, expected);
		
	}
}
