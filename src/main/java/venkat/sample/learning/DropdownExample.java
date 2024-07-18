package venkat.sample.learning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownExample {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/select.xhtml");
		driver.manage().window().maximize();
		Thread.sleep(5000);

		// Which is your favorite UI Automation tool?
		WebElement dropdown1 = driver.findElement(By.xpath("//*[@id=\"j_idt87\"]/div/div[1]/div[1]/div/div/select"));
		Select select1 = new Select(dropdown1);
		select1.selectByIndex(0);
		select1.selectByIndex(1);
		select1.selectByIndex(2);
		select1.selectByIndex(3);
		select1.selectByIndex(4);

		List<WebElement> listofOptions = select1.getOptions();
		int optionCount = listofOptions.size();
		System.out.println(optionCount);
	}

}
