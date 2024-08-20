package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OverviewPage {
	
	private WebDriver driver;
	
	public OverviewPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(id="finish")WebElement fbtn;
	@FindBy(id="cancel")WebElement cncbtn;
	
	public void cancelVerify()
	{
		cncbtn.click();
	}

	public String checkFinish()
	{
		fbtn.click();
		return driver.getCurrentUrl();
	}
}
