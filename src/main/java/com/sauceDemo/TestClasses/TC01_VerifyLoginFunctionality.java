package com.sauceDemo.TestClasses;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC01_VerifyLoginFunctionality extends TestBaseClass
{	
	@Test
	public void verifyLoginFunctionality()
	{
//		SoftAssert soft = new SoftAssert();
//		soft.assertTrue(false); 
		
		String actual = driver.getTitle();
		String expected = "Swag Labs";
		
		Assert.assertEquals(actual, expected);
		
//		soft.assertAll();
	}
}
