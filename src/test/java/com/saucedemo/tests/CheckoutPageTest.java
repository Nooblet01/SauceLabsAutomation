package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.utility.MyUtilities;

public class CheckoutPageTest extends BaseClass {
	@Test(priority=1)
	public void cancelVerification() {
		String link = chp.cancelVerify();
		Assert.assertTrue(link.contains("cart"));
		cp.checkoutVerification();

	}

	@Test(priority=2)
	public void processVerification() {
		MyUtilities.addWait();
		Assert.assertTrue(chp.addInfo("Mark", "Brown", "234123").contains("step-two"));
		MyUtilities.addWait();
		MyUtilities.takeSnap(driver);
	}
}
