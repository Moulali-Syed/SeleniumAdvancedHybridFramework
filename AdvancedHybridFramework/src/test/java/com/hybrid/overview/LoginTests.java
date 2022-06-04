package com.hybrid.overview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hybrid.base.BaseTest;

public class LoginTests extends BaseTest {

	@Test
	public void testLogin() {

		driver.findElement(By.xpath("//a[contains(@href,'account')]")).click();
		driver.findElement(By.cssSelector("input#username")).clear();
		driver.findElement(By.cssSelector("input#username")).sendKeys("demosite@gmail.com");

		WebElement passwordElement = driver.findElement(By.cssSelector("input#password"));
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
