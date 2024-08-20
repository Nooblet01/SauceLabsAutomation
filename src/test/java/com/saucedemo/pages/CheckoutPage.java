package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage {

	private WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(id = "first-name")
	WebElement fname;
	@FindBy(id = "last-name")
	WebElement lname;
	@FindBy(name = "postalCode")
	WebElement pcode;
	@FindBy(id = "cancel")
	WebElement cabtn;
	@FindBy(id = "continue")
	WebElement cobtn;

	public String cancelVerify() {
		cabtn.click();
		return driver.getCurrentUrl();
	}

	public String addInfo(String firstname, String lastname, String postalcode) {
		fname.sendKeys(firstname);
		lname.sendKeys(lastname);
		pcode.sendKeys(postalcode);
		cobtn.click();
		return driver.getCurrentUrl();
	}

}
