package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass {

	@Test(priority=1)
	public void verifyURL() {
		Assert.assertTrue(lp.urlVerify().contains("sauce"), "URL not matched.");
		System.out.println("URL matched!");
	}

	@Test(priority=2)
	public void verifyTitle() {
		Assert.assertTrue(lp.titleVerify().contains("Swag"), "Title not matched.");
		System.out.println("Title matched!");
	}

	@Test(priority=3)
	public void verifyLogin() {
		lp.doLogin("standard_user", "secret_sauce");
		Assert.assertTrue(driver.getCurrentUrl().contains("inventory"),"Login failed");
		System.out.println("Login succesfull!");
	}
}
