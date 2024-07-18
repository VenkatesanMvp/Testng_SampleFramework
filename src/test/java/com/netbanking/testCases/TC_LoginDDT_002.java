package com.netbanking.testCases;

import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.netbanking.utilities.Reporting;
import com.netbanking.utilities.TestListener;
import com.netbanking.utilities.XLUtils;
import auto.netbanking.pageObjects.LoginPage;

public class TC_LoginDDT_002 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void loginDDT(String userName, String password) throws IOException {
		ExtentTest childTest = Reporting.createChildTest(TestListener.parentTest, "TC_LoginDDT_002");
		LoginPage lp = new LoginPage(driver);
		driver.manage().window().maximize();
		lp.setUserName(userName);
		childTest.log(Status.INFO, "Username provided");
		Reporting.attachScreenshotSafe(childTest, "Username provided");
		lp.setPassword(password);
		childTest.log(Status.INFO, "Password provided");
		Reporting.attachScreenshotSafe(childTest, "Password provided");
		lp.clickSubmit();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			childTest.log(Status.FAIL, "Thread interrupted");
		}

		// close alert
		if (isAlertPresent()) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			childTest.log(Status.INFO, "Login Failed");
			Reporting.attachScreenshotSafe(childTest, "Login Failed");
		} else {
			Assert.assertTrue(true);
			childTest.log(Status.INFO, "Login passed");
			Reporting.attachScreenshotSafe(childTest, "Login passed");
			lp.clickLogout();
			try {
				Thread.sleep(3000);
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();
			} catch (InterruptedException e) {
				childTest.log(Status.FAIL, "Thread interrupted");
			}
		}
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/netbanking/testData/LoginData.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

		String[][] logindata = new String[rownum][colcount];
		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
	}
}