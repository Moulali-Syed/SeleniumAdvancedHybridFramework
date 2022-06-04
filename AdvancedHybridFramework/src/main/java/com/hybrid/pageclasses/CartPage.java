package com.hybrid.pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hybrid.base.BasePage;

public class CartPage extends BasePage {

	public WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	private String proceed_checkout = "//a[contains(@href,'checkout')]";

	public CheckoutPage proceedToCheckOut() {
		driver.findElement(By.xpath(proceed_checkout)).click();
		return new CheckoutPage(driver);
	}
}
