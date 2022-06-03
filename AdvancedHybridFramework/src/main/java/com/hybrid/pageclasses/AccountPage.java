package com.hybrid.pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {

	public WebDriver driver;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
	}

	private String Email_Field = "username";
	private String Password_Field = "password";
	private String Log_In_Btn = "login";
	private String homePageLink = "//*[@id='menu-item-1226']/a";

	public void signIn(String email, String password) {
		WebElement emailField = driver.findElement(By.id(Email_Field));
		emailField.clear();
		emailField.sendKeys(email);

		WebElement passwordField = driver.findElement(By.id(Password_Field));
		passwordField.clear();
		passwordField.sendKeys(password);

		WebElement loginBtn = driver.findElement(By.name(Log_In_Btn));
		loginBtn.click();
	}

	public HomePage goToHomePage() {

		driver.findElement(By.xpath(homePageLink)).click();
		return new HomePage(driver);
	}
}
