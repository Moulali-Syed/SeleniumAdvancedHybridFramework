package com.hybrid.testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hybrid.base.BaseTest;
import com.hybrid.pageclasses.AccountPage;
import com.hybrid.pageclasses.CartPage;
import com.hybrid.pageclasses.CheckoutPage;
import com.hybrid.pageclasses.HomePage;
import com.hybrid.pageclasses.Successpage;

import io.github.bonigarcia.wdm.WebDriverManager;


public class AllProductsTest extends BaseTest{

	HomePage h;
	AccountPage a;
	@Test
	public void selectProduct() throws InterruptedException {

		 h = new HomePage(driver);
//		 boolean result = h.verifyContent();
//		 System.out.println(result);
		a = h.openContactPage();
		a.signIn("demosite@gmail.com", "demosite@gmail.com");

		h = a.goToHomePage();
		System.out.println(h.productName());
		h.selectProduct();

	}

	@Test
	public void purchaseproduct() throws InterruptedException {
//		HomePage h = new HomePage(driver);
//		h.selectProduct();
		h = new HomePage(driver);
		h.selectProduct();
		CartPage c = h.gotoCart();
		CheckoutPage cp = c.proceedToCheckOut();
		Successpage sp = cp.billingfName("Apple").billinglName("Apple").addressLine("asdfn").city("ndsdf")
				.zipCode("90011").emailAddress("askomdch@gmail.com").placeOrder();
		String SuccessMSG = sp.getSuccessmsg();
		Assert.assertEquals(SuccessMSG, "Thank you. Your order has been received.");

	}

}
