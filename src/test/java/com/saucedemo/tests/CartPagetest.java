package com.saucedemo.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.saucedemo.utility.MyUtilities;

public class CartPagetest extends BaseClass {
	@Test(priority=1)
	public void verifyRemove() {
		cp.removeCheck();
	}

	@Test(priority=2)
	public void verifyContinue() {
		cp.continueShoppingCheck();
		MyUtilities.addWait();
		Assert.assertTrue(ip.addToCart("bike-light").contains("cart"), "Cart page didn't open.");
		System.out.println("Redirected to cart page again!");
	}

	@Test(priority=3)
	public void verifyCheckout() {
		MyUtilities.addWait();
		Assert.assertTrue(cp.checkoutVerification().contains("checkout"), "Checkout functionality failed.");
		System.out.println("Succesfuly redirected to checkout page!");
		
	}
}
