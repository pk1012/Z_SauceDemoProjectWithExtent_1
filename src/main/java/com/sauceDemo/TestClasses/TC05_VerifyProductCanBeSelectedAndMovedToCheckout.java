package com.sauceDemo.TestClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sauceDemo.POMClasses.POM_1_Home;

public class TC05_VerifyProductCanBeSelectedAndMovedToCheckout extends TestBaseClass
{
	@Test
	public void verifyProductCanBeSelectedAndMovedToCheckout() throws IOException, InterruptedException
	{
		POM_1_Home hp = new POM_1_Home(driver);
		
		hp.clickOnProduct(3);
		log.info("clicked on product at index 3");
		Thread.sleep(2000);
		
		hp.addToCart();
		log.info("Clicked on add to cart");
		
		hp.clickOnCart();
		log.info("Clicked on cart");
		
		String expectedProduct = "Sauce Labs Fleece Jacket";
		String actualProduct = hp.getTextOfProduct(0);
		
		Assert.assertEquals(actualProduct, expectedProduct);
		
	}
}
