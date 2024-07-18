package venkat.sample.learning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ButtonExample {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/button.xhtml");
		driver.manage().window().maximize();
		Thread.sleep(5000);

		// Click and Confirm title
		driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt90\"]/span")).click();
		String title = driver.getTitle();
		System.out.println(title);
		if (title == ("Dashboard")) {
			System.out.println("Title is valid");
		}
		driver.navigate().back();

		// Confirm if the button is disabled.
		WebElement enabled = driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt92\"]"));
		boolean status = enabled.isEnabled();
		System.out.println(status);

		// Find the position of the Submit button
		Point xypoint = driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt94\"]/span[2]")).getLocation();
		int xValue = xypoint.getX();
		int yValue = xypoint.getY();
		System.out.println("X value:" + xValue + ", Y value:" + yValue);

		// Find the Save button color
		WebElement getColor = driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt96\"]/span[2]"));
		String color = getColor.getCssValue("background-color");
		System.out.println("color is :" + color);

		// Find the height and width of this button
		WebElement size = driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt98\"]/span[2]"));
		int height = size.getSize().getHeight();
		int width = size.getSize().getWidth();
		System.out.println("Height:" + height + ", Width:" + width);

		// How many rounded buttons are there?
		List<WebElement> buttoncount = driver
				.findElements(By.xpath("//*[text()=\"How many rounded buttons are there?\"]/following::button"));
		int Count = 0;
		for (WebElement buttonCounts : buttoncount) {
			Count++;
		}
		System.out.println(Count);

		// Mouse over and confirm the color changed
		WebElement buttoncolor = driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt100\"]/span"));
		String initialcolor = buttoncolor.getCssValue("background-color");
		// Perform mouse hover action
		Actions actions = new Actions(driver);
		actions.moveToElement(buttoncolor).perform();
		// Get the color of the button after mouse hover
		String hoverColor = buttoncolor.getCssValue("background-color");
		// Print the colors to verify
		System.out.println("Initial Color: " + initialcolor);
		System.out.println("Hover Color: " + hoverColor);

	}

}
