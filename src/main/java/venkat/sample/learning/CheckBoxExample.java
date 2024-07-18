package venkat.sample.learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxExample {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/checkbox.xhtml");
		driver.manage().window().maximize();
		Thread.sleep(5000);

		// Basic Checkbox
		driver.findElement(By.xpath("//*[@id=\"j_idt87:j_idt89\"]/div[2]")).click();

		// Verify if check box is disabled
		WebElement status = driver.findElement(By.xpath("//*[@id=\"j_idt87:j_idt102\"]"));
		boolean status1 = status.isEnabled();
		System.out.println(status1);
		
	}
}
