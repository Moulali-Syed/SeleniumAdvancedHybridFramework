package com.hybrid.pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Successpage {

	public WebDriver driver;
	public Successpage(WebDriver driver) {
		this.driver =driver;
	}
	
	private String msg = "//p[contains(@class,'thankyou')]";
	
	public String getSuccessmsg() {
		return driver.findElement(By.xpath(msg)).getText();
	}
}
