package com.saucedemo.tests;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.saucedemo.pages.*;
import com.saucedemo.utility.MyUtilities;

public class BaseClass {

	public WebDriver driver;
	public LoginPage lp;
	public InventoryPage ip;
	public CartPage cp;
	public CheckoutPage chp;
	public OverviewPage op;
	public ExtentReports extent;
	public ExtentSparkReporter spark;
	public ExtentTest test;

	@BeforeSuite
	public void reportGen() {
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("target/SauceDemo.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("BasicReporting");
		extent.attachReporter(spark);
		test = extent.createTest("SauceTests");
	}

	@BeforeTest
	public void browserSetup() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/");
		test.pass("browser opened!");
		lp = PageFactory.initElements(driver, LoginPage.class);
		ip = PageFactory.initElements(driver, InventoryPage.class);
		cp = PageFactory.initElements(driver, CartPage.class);
		chp = PageFactory.initElements(driver, CheckoutPage.class);
		op = PageFactory.initElements(driver, OverviewPage.class);
	}

	@BeforeClass
	public void pageSetUp() {
		lp.doLogin("standard_user", "secret_sauce");
		System.out.println("Succesfully logged in!");
		test.pass("login succesfull");
		MyUtilities.addWait();
		ip.addToCart("sauce-labs-onesie");
		System.out.println("Succesfully added item to cart!");
		test.pass("Added to cart succesfully");
		MyUtilities.addWait();
		cp.checkoutVerification();
		MyUtilities.addWait();
		System.out.println("Succesfully redirected!");
		chp.addInfo("Mark", "Brown", "123456");
		test.pass("Successfully added checkout info");
		System.out.println("Succesfully added required information");

	}

	@AfterSuite
	public void tearDown() {
		MyUtilities.addWait();
		extent.flush();
		driver.quit();
	}

}
