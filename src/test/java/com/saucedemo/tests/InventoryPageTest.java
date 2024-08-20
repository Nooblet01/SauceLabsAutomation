package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class InventoryPageTest extends BaseClass {
	@Test(priority=1)
	public void verifyProductCount() {
		int pcount = ip.getProductCount();
		Assert.assertTrue(pcount == 6, "Product count didn't match.");
		System.out.println("Product count matched!" + "(" + pcount + ")");
	}

	@Test(priority=2)
	public void printProductDetails() {
		ip.getProductDetails();
	}

	@Test(priority=3)
	public void verifyCart() {
		Assert.assertTrue(ip.addToCart("bolt-t-shirt").contains("cart"), "Cart page didn't open");
		System.out.println("Redirected to cart page succesfully");
	}
}
