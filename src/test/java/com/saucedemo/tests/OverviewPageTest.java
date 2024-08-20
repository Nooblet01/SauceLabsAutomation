package com.saucedemo.tests;

import org.testng.annotations.Test;

import org.testng.Assert;


public class OverviewPageTest extends BaseClass{
  @Test(priority=1)
  public void cancelVerification() 
  {
	  op.cancelVerify();
  }
  
  @Test(priority=2)
  public void finalVerification() 
  {
	  ip.addToCart("fleece-jacket");
	  cp.checkoutVerification();
	  chp.addInfo("Mark", "Brown", "123456");
	  Assert.assertTrue(op.checkFinish().contains("complete"),"Failed to visit final page");
	  System.out.println("Succesfully redirected to Final page");
	  
	  
  }
}
