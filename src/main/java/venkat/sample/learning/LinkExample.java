package venkat.sample.learning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkExample {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.name("q")).sendKeys("Leafground link in selenium" + Keys.ENTER);
		driver.findElement(By.partialLinkText("Link Components - Dashboard")).click();

		// clicking on link.
		// driver.findElement(By.linkText("Go to Dashboard")).click();

		// Find the URL without clicking on link.
		// WebElement Link = driver.findElement(By.linkText("Find the URL without
		// clicking me."));
		// String getLink= Link.getAttribute("href");
		// System.out.println(getLink);

		// Check the Link is broken
		// driver.findElement(By.linkText("Broken?")).click();
		// String title= driver.getTitle();
		// System.out.println(title);
		// if(title.contains("404"))
		// {
		// System.out.println("Link is Broken");
		// }
		
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		int totalLinkCount=links.size();
		System.out.print(totalLinkCount);
		
	}

}
