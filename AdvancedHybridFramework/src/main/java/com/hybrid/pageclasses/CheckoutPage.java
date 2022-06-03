package com.hybrid.pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	public WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	private String billing_fname = "billing_first_name";
	private String billing_lname = "billing_last_name";
	private String address = "billing_address_1";
	private String city = "billing_city";
	private String code = "billing_postcode";
	private String emailAdd = "billing_email";
	private String placeOrder = "place_order";

	public CheckoutPage billingfName(String name) {
		driver.findElement(By.id(billing_fname)).sendKeys(name);
		return this;
	}

	public CheckoutPage billinglName(String name) {
		driver.findElement(By.id(billing_lname)).sendKeys(name);
		return this;
	}

	public CheckoutPage addressLine(String name) {
		driver.findElement(By.id(address)).sendKeys(name);
		return this;
	}

	public CheckoutPage city(String name) {
		driver.findElement(By.id(city)).sendKeys(name);
		return this;
	}

	public CheckoutPage zipCode(String name) {
		driver.findElement(By.id(code)).sendKeys(name);
		return this;
	}

	public CheckoutPage emailAddress(String email) {
		driver.findElement(By.id(emailAdd)).sendKeys(email);
		return this;
	}

	public Successpage placeOrder() {
		driver.findElement(By.id(placeOrder)).click();
		return new Successpage(driver);
	}

}
