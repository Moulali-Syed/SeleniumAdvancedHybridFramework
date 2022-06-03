package com.hybrid.overview;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTests {

	WebDriver driver;
	String baseURL;

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		baseURL = "https://askomdch.com/account/";
		driver.get(baseURL);
	}

	@Test
	public void testLogin() {
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("demosite@gmail.com");

		WebElement passwordElement = driver.findElement(By.id("password"));
		passwordElement.clear();
		passwordElement.sendKeys("demosite@gmail.com");

		driver.findElement(By.name("login")).click();

		WebElement LogoutBtn = null;
		try {
			LogoutBtn = driver.findElement(By.linkText("Logout"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		Assert.assertNotNull(LogoutBtn);
		LogoutBtn.click();
	}
}
