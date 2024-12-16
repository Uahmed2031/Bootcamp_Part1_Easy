package com.TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Successful_Login {
	
	public WebDriver driver;

	@BeforeMethod
	public void loginPageSetup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(1000));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
	}
	
	@Test
	public void verifySuccessfulLoginWithValidCredentials() {
		driver.findElement(By.xpath("//input[@id = 'input-email']")).sendKeys("ummeahmed@gmail.com");
		driver.findElement(By.xpath("//input[@id = 'input-password']")).sendKeys("Umme@2111");
		driver.findElement(By.xpath("//input[@class = 'btn btn-primary']")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());			
	}
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
