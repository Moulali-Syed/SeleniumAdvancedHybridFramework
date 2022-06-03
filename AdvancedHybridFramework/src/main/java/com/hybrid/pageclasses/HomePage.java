package com.hybrid.pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	private String Contact = "//a[contains(@href,'account')]";
	private String product = "//a[contains(text(),'Add to')][1]";
	private String viewCart = "a[title='View cart']";

	public AccountPage openContactPage() {

		driver.findElement(By.xpath(Contact)).click();
		return new AccountPage(driver);
	}

	public String productName() {
		return driver.findElement(By.xpath(product)).getText();
	}

	public void selectProduct() {
		driver.findElement(By.xpath(product)).click();
	}
	
	public CartPage gotoCart() {
		driver.findElement(By.cssSelector(viewCart)).click();
		return new CartPage(driver);
	}
}
