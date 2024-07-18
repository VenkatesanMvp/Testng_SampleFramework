package venkat.sample.learning;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextBoxExample {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/input.xhtml");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		// Enter a text in textbox
		driver.findElement(By.xpath("//input[@placeholder=\"Babu Manickam\"]")).sendKeys("Venkatesan Murugesan");

		// append a text
		driver.findElement(By.xpath("//input[@value=\"Chennai\"]")).sendKeys(" Tamil Nadu");

		// Verify if text box is disabled
		boolean enabled = driver.findElement(By.xpath("//input[@placeholder=\"Disabled\"]")).isEnabled();
		System.out.print(enabled);

		// Clear the typed text
		driver.findElement(By.xpath("//input[@value=\"Can you clear me, please?\"]")).clear();

		// Type email and Tab. Confirm control moved to next element.
		driver.findElement(By.xpath("//input[@placeholder=\"Your email and tab\"]"))
				.sendKeys("abc@gmail.com" + Keys.TAB);
		driver.findElement(By.xpath("//*[@placeholder=\"About yourself\"]"))
				.sendKeys("My name is Venkat and I'm working as a Senior Software Engineer @Maveric Systems");

		// Just Press Enter and confirm error message
		driver.findElement(By.xpath("//*[@id=\"j_idt106:thisform:age\"]")).sendKeys(Keys.ENTER);
		WebElement errormsg = driver.findElement(By.xpath("//span[text()='Age is mandatory']"));
		String error = errormsg.getText();
		if (error.equals("Age is mandatory")) {
			System.out.print("Error msg is:" + error);
		}
	}
}
