package com.netbanking.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestListener implements ITestListener {

	public static ExtentTest parentTest;
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	@Override
	public void onStart(ITestContext context) {
		Reporting report = new Reporting();
		report.initializeReportFile();
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporting.extent.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		parentTest = Reporting.createParentTest(result.getTestClass().getName());
		ExtentTest child = Reporting.createChildTest(parentTest, result.getMethod().getMethodName());
		test.set(child);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.get().log(Status.FAIL, "Test Failed");
		test.get().log(Status.FAIL, result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.get().log(Status.SKIP, "Test Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// Not implemented
	}
}