package com.netbanking.testCases;

import org.testng.annotations.Parameters;
import java.time.Duration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.netbanking.utilities.ReadConfig;
import com.netbanking.utilities.Reporting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();
	public String baseURL = readconfig.getApplicationURL();
	public String UserName = readconfig.getUserName();
	public String password = readconfig.getpassword();
	public String chromepath = readconfig.getChromepath();
	public String edgepath = readconfig.getEdgepath();
	public static WebDriver driver;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", chromepath);
			driver = new ChromeDriver();
			// Set the WebDriver in the Reporting class
			Reporting.setDriver(driver);
		} else if (br.equals("ie")) {
			System.setProperty("webdriver.edge.driver", edgepath);
			driver = new EdgeDriver();
			// Set the WebDriver in the Reporting class
			Reporting.setDriver(driver);
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseURL);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		Reporting.extent.flush();
	}
}
