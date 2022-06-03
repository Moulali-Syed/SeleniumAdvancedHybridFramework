package com.hybrid.pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

	public WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	private String proceed_checkout = "//a[contains(@href,'checkout')]";

	public CheckoutPage proceedToCheckOut() {
		driver.findElement(By.xpath(proceed_checkout)).click();
		return new CheckoutPage(driver);
	}
}
