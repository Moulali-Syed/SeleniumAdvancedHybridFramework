package com.hybrid.pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.hybrid.base.BasePage;

public class AccountPage extends BasePage {

	public WebDriver driver;

	public AccountPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	private String Email_Field = "id=>username";
	private String Password_Field = "id=>password";
	private String Log_In_Btn = "name=>login";
	private String homePageLink = "xpath=>//*[@id='menu-item-1226']/a";

	public void signIn(String email, String password) {
		
		//WebElement emailField = getElement(Email_Field,"mailIdField");
//		WebElement emailField = driver.findElement(By.id(Email_Field));
		sendData(Email_Field,email,"mailId",true);
//		emailField.clear();
//		emailField.sendKeys(email);

		WebElement passwordField = getElement(Password_Field,"PasswordField");
//		WebElement passwordField = driver.findElement(By.id(Password_Field));
		sendData(passwordField,password,"password",true);
//		passwordField.clear();
//		passwordField.sendKeys(password);
		WebElement loginBtn = getElement(Log_In_Btn,"LogInBtn");
//		WebElement loginBtn = driver.findElement(By.name(Log_In_Btn));
		elementClick(loginBtn,"ClickOnLoginBtn");
	}

	public HomePage goToHomePage() {
		WebElement loginBtn = getElement(homePageLink,"HomePageLink");
		elementClick(loginBtn,"ClickOnHomePage");
//		driver.findElement(By.xpath(homePageLink)).click();
		return new HomePage(driver);
	}
}
