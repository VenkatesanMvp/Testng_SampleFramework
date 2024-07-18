package venkat.sample.learning;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertExample {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/alert.xhtml");
		driver.manage().window().maximize();
		Thread.sleep(5000);

		// Alert (Simple Dialog)
		driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt91\"]/span[2]")).click();
		Alert alert1 = driver.switchTo().alert();
		Thread.sleep(3000);
		alert1.accept();

		// Alert (Confirm Dialog)
		driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt93\"]/span[2]")).click();
		Alert alert2 = driver.switchTo().alert();
		Thread.sleep(3000);
		alert2.dismiss();

		// Alert (Prompt Dialog)
		driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt104\"]/span[2]")).click();
		Alert alert3 = driver.switchTo().alert();
		alert3.sendKeys("Venkatesan M");
		Thread.sleep(3000);
		alert3.accept();
	}

}
