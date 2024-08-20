package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(id = "user-name")
	WebElement usn;
	@FindBy(id = "password")
	WebElement psw;
	@FindBy(id = "login-button")
	WebElement btn;

	public String titleVerify() {
		return driver.getTitle();
	}

	public String urlVerify() {
		return driver.getCurrentUrl();
	}

	public void doLogin(String username, String password) {
		usn.sendKeys(username);
		psw.sendKeys(password);
		btn.click();
	}

}
