package com.netbanking.utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting {
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	private static WebDriver driver;

	public static void setDriver(WebDriver driver) {
		Reporting.driver = driver;
	}

	public void initializeReportFile() {
		if (extent == null) {
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String repName = "Test-Report-" + timeStamp + ".html";
			htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/" + repName);

			try {
				htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
			} catch (IOException e) {
				e.printStackTrace();
			}

			htmlReporter.config(ExtentSparkReporterConfig.builder().theme(Theme.DARK)
					.documentTitle("NetBanking Test Project").reportName("NetBanking Test Report").encoding("utf-8")
					.timeStampFormat("MMMM dd, yyyy HH:mm:ss").build());

			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			extent.setSystemInfo("Host name", "localhost");
			extent.setSystemInfo("Environment", "QA");
			extent.setSystemInfo("User", "Venkatesan Murugesan");

			// Additional custom system information
			extent.setSystemInfo("Browser", "Chrome");
			extent.setSystemInfo("OS", System.getProperty("os.name"));
			extent.setSystemInfo("Java Version", System.getProperty("java.version"));
		}
	}

	public static String captureScreenshot(String methodName) {
		try {
			if (driver instanceof TakesScreenshot) {
				TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
				File screenshot = screenshotDriver.getScreenshotAs(OutputType.FILE);
				String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date());
				String screenshotPath = System.getProperty("user.dir") + "/test-output/Screenshots/" + methodName + "_"
						+ timeStamp + ".png";
				Files.copy(screenshot.toPath(), Paths.get(screenshotPath));
				return screenshotPath;
			} else {
				System.out.println("Driver does not support taking screenshots");
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void attachScreenshotSafe(ExtentTest logger, String description) throws IOException {
		String screenshotPath = Reporting.captureScreenshot(description);
		if (screenshotPath != null) {
			logger.addScreenCaptureFromPath(screenshotPath, description);
		}
	}

	public static ExtentTest createParentTest(String testName) {
		return extent.createTest(testName);
	}

	public static ExtentTest createChildTest(ExtentTest parentTest, String childTestName) {
		return parentTest.createNode(childTestName);
	}
}