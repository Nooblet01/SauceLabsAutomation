package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage {

	private WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//button[text()='Remove']")
	WebElement rembtn;
	@FindBy(xpath = "//button[@id='continue-shopping']")
	WebElement contshop;
	@FindBy(xpath = "//button[@id='checkout']")
	WebElement cout;

	public void removeCheck() {
		rembtn.click();
	}

	public void continueShoppingCheck() {
		contshop.click();
	}

	public String checkoutVerification() {
		cout.click();
		return driver.getCurrentUrl();
	}
}
