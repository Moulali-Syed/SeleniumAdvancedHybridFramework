package com.hybrid.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.hybrid.base.BaseTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo extends BaseTest{

	@Test
	public void demo() {
		
		
		driver.findElement(By.xpath("//a[contains(@href,'account')]")).click();
	}
}
