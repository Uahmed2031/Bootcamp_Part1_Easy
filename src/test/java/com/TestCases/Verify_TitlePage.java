package com.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Verify_TitlePage {
		
		public WebDriver driver;
		
	@BeforeMethod
	public void titlePageSetup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://tutorialsninja.com/demo/");
	
	}
	
	@Test 
	public void verifyTitleOfThePage() {
		String ExpectedTitle = "Your Store";
		String ActualTitle = driver.getTitle();
		Assert.assertTrue(ActualTitle.contains(ExpectedTitle));
	}
	
	@AfterMethod
	public void tearDown() {
			driver.quit();

	}
	
}	
	

