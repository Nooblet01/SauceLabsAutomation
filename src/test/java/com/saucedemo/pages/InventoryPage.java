package com.saucedemo.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage {

	private WebDriver driver;

	public InventoryPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//div[@class='inventory_list']//div[@class='inventory_item']")
	List<WebElement> plist;
	@FindBy(xpath = "//div[@class='inventory_item_name ']")
	List<WebElement> pname;
	@FindBy(xpath = "//button[text()='Add to cart']")
	List<WebElement> addcart;
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	WebElement cartbtn;

	public int getProductCount() {
		return plist.size();
	}

	public void getProductDetails() {
		for (WebElement i : pname) {
			System.out.println(i.getText());
		}
	}

	public String addToCart(String product) {
		for (WebElement i : addcart) {
			if (i.getAttribute("name").contains(product)) {
				i.click();
				break;
			}
		}
		cartbtn.click();
		return driver.getCurrentUrl();
	}

}
