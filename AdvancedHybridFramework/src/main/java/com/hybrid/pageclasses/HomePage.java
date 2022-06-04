package com.hybrid.pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.hybrid.base.BasePage;
import com.hybrid.utilities.Util;

public class HomePage extends BasePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	private String Contact = "//a[contains(@href,'account')]";
	private String product = "//a[contains(text(),'Add to')][1]";
	private String viewCart = "//a[contains(@title,'View cart')]";
	private String content = ".alignwide.has-text-align-center";

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

	public CartPage gotoCart() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath(viewCart)).click();
		return new CartPage(driver);
	}

	public boolean verifyContent() {
		WebElement cont = driver.findElement(By.cssSelector(content));
		String text = cont.getText();
		return Util.verifyTextContains(text, "Raining Offers for Hot Summer!");
	}
}
