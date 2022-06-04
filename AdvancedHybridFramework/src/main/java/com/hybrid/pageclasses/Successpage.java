package com.hybrid.pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hybrid.base.BasePage;

public class Successpage extends BasePage {

	public WebDriver driver;

	public Successpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	private String msg = "//p[contains(@class,'thankyou')]";

	public String getSuccessmsg() {
		return driver.findElement(By.xpath(msg)).getText();
	}
}
