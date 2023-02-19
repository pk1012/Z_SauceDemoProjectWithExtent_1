package com.sauceDemo.TestClasses;


import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.sauceDemo.POMClasses.POM_0_Login;
import com.sauceDemo.POMClasses.POM_1_Home;

public class TestBaseClass 
{
	WebDriver driver;
	Logger log = Logger.getLogger("SauceDemoProject");
	
	@Parameters("browserName")
	@BeforeClass
	public void beforeClass(String browserName)
	{
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", 
				"./DriverFolder/chromedriver.exe");
		
			driver = new ChromeDriver();
			System.out.println("opened browser");
		}
		else if (browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", 
					"./DriverFolder/geckodriver.exe");
			
			driver = new FirefoxDriver();
			System.out.println("opened browser");
		}
		else
		{
			System.setProperty("webdriver.edge.driver", 
					"./DriverFolder/msedgedriver.exe");
			
			driver = new EdgeDriver();
			System.out.println("opened browser");
		}
		
		PropertyConfigurator.configure("log4j.properties");
		
		driver.manage().window().maximize();
		log.info("maximized browser");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.saucedemo.com/");
		log.info("opened website");
	}
	
	@BeforeMethod
	public void setUp()
	{
		POM_0_Login lp = new POM_0_Login(driver);
		
		lp.sendUsername("standard_user");
		log.info("entered username");
		
		lp.sendPassword("secret_sauce");
		log.info("entered password");
		
		lp.clickLoginBtn();
		log.info("clicked on login button");
		
	}

	@AfterMethod
	public void tearDown()
	{
		POM_1_Home hp = new POM_1_Home(driver);
		
		hp.clickSettingBtn();
		log.info("Clicked on setting btn");
		
		hp.clickLogoutBtn();
		log.info("Clicked on logout btn");
	}
	
	@AfterClass
	public void afterClass()
	{
		driver.quit();
		log.info("Closed browser");
	}
	
}
