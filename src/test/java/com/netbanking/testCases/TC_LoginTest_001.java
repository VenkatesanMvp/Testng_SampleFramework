package com.netbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.netbanking.utilities.Reporting;
import com.netbanking.utilities.TestListener;

import auto.netbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException {
		ExtentTest childTest = Reporting.createChildTest(TestListener.parentTest, "TC_LoginTest_001");

		driver.get(baseURL);
		childTest.log(Status.INFO, "URL is Opened");
		Reporting.attachScreenshotSafe(childTest, "URL Opened");

		driver.manage().window().maximize();
		LoginPage lp = new LoginPage(driver);

		lp.setUserName(UserName);
		childTest.log(Status.INFO, "Entered UserName");
		Reporting.attachScreenshotSafe(childTest, "Entered UserName");

		lp.setPassword(password);
		childTest.log(Status.INFO, "Entered password");
		Reporting.attachScreenshotSafe(childTest, "Entered password");

		lp.clickSubmit();
		childTest.log(Status.INFO, "Clicked Submit Button");
		Reporting.attachScreenshotSafe(childTest, "Clicked Submit Button");

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			childTest.log(Status.INFO, "Login Test Passed");
			Reporting.attachScreenshotSafe(childTest, "Login Test Passed");
		} else {
			Assert.assertTrue(false);
			childTest.log(Status.WARNING, "Login Test Failed");
			Reporting.attachScreenshotSafe(childTest, "Login Test Passed");
		}

	}

}
