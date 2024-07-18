package com.netbanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.netbanking.utilities.Reporting;
import com.netbanking.utilities.TestListener;

import auto.netbanking.pageObjects.AddCustomerPage;
import auto.netbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws IOException {
		ExtentTest childTest = Reporting.createChildTest(TestListener.parentTest, "TC_AddCustomerTest_003");
		LoginPage lp = new LoginPage(driver);
		driver.manage().window().maximize();
//		lp.setUserName(UserName);
//		childTest.log(Status.INFO, "Username provided");
//		Reporting.attachScreenshotSafe(childTest, "Username provided");
		lp.setPassword(password);
		childTest.log(Status.INFO, "Password provided");
		Reporting.attachScreenshotSafe(childTest, "Password provided");
		lp.clickSubmit();
		childTest.log(Status.INFO, "Login Successful!!!");
		Reporting.attachScreenshotSafe(childTest, "Login Successful!!!");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			childTest.log(Status.FAIL, "Thread interrupted");
		}
		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.clickNewCustomer();
		childTest.log(Status.INFO, "Clicked on New customer Button");
		Reporting.attachScreenshotSafe(childTest, "Clicked on New customer Button");

		addcust.inputCustomerName("Durgadevi Ramesh");
		childTest.log(Status.INFO, "Entered Customer Name");
		Reporting.attachScreenshotSafe(childTest, "Entered Customer Name");

		addcust.clickFemale();
		addcust.inputDOB("28", "06", "1996");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			childTest.log(Status.FAIL, "Thread interrupted");
		}

		addcust.inputAddress("NO 90A Parvathy Nagar Madambakkam");
		addcust.inputCity("Chennai");
		addcust.inputState("Tamil Nadu");
		addcust.inputPinNo("280696");
		addcust.inputMobileNo("9940525197");

		String email = randomString() + "@gmail.com";
		addcust.inputEmailID(email);

		addcust.inputPassword("Welcome@123");
		childTest.log(Status.INFO, "Details Entered");
		Reporting.attachScreenshotSafe(childTest, "Details Entered");
		addcust.clickSubmit();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			childTest.log(Status.FAIL, "Thread interrupted");
		}
		childTest.log(Status.INFO, "Validation Started");
		boolean result = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if (result == true) {
			Assert.assertTrue(true);
			childTest.log(Status.INFO, "Registered Successful!!!");
			Reporting.attachScreenshotSafe(childTest, "Registered Successful!!!");
		} else {
			Assert.assertTrue(false);
			childTest.log(Status.FAIL, "Registered Unsuccessful!!!");
			Reporting.attachScreenshotSafe(childTest, "Registered Unsuccessful!!!");
		}

	}

	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(8);
		return generatedString;
	}

}
