package com.hybrid.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	protected String baseURL;

	@BeforeClass
	@Parameters({"browser"})
	public void commonSetup(String browser) {
		driver = WebDriverFactory.getInstance().getDriver(browser);
		baseURL = "https://askomdch.com/";
		driver.get(baseURL);
	}

	@AfterClass
	public void commonTearDown() {
//		driver.quit();
		WebDriverFactory.getInstance().quitDriver();
	}

}
