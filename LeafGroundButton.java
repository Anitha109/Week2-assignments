package week2.assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundButton {

	public static void main(String[] args) {

		int buttonCount = 0;
		// Setup the browser driver
		WebDriverManager.chromedriver().setup();
		// Launch the browser
		ChromeDriver driver = new ChromeDriver();
		// Load the URL https://en-gb.facebook.com/
		driver.get("https://leafground.com/button.xhtml");
		// Maximise the window
		driver.manage().window().maximize();
		// Click the button and Confirm title
		driver.findElement(By.xpath("//span[text() = 'Click']")).click();
		System.out.println("Title name : " + driver.getTitle());
		// Navigate to back in browser
		driver.navigate().back();
		// Confirm if the button is disabled
		boolean buttonEnabled = driver.findElement(By.xpath("//span[text() = 'Disabled']")).isEnabled();
		if (buttonEnabled == true) {
			System.out.println("Button is disabled");
		} else {
			System.out.println("Button is enabled");
		}
		// Find the position of the Submit button
		Point buttonLocation = driver.findElement(By.xpath("//span[text() = 'Submit']")).getLocation();
		System.out.println("Position of the Submit button " + buttonLocation);
		// Find the Save button color
		String cssValue = driver.findElement(By.id("j_idt88:j_idt96")).getCssValue("background-color");

		System.out.println("CSSvalue of the Save button " + cssValue);
		// Find the height and width of this button
		Dimension size = driver.findElement(By.id("j_idt88:j_idt98")).getSize();
		System.out.println("Height and Width of Submit button " + size);
		// Mouse over and confirm the colour changed
		WebElement successButton = driver.findElement(By.id("j_idt88:j_idt100"));
		// Get the background colour of the button from CSS value
		String cssValue1 = successButton.getCssValue("background-color");
		// Print the RGBA value beofre mouse over
		System.out.println("Colour before mouse over " + cssValue1);
		Actions a = new Actions(driver);
		// mouse over action perform
		a.moveToElement(successButton).perform();
		// Get the background colour after mouser over and Print the RGBA value
		String cssValue2 = successButton.getCssValue("background-color");
		System.out.println("Colour after mouse over " + cssValue2);
		// Click Image Button and Click on any hidden button
		driver.findElement(By.id("j_idt88:j_idt102:imageBtn")).click();
		// Verifing whether the Testleaf image displayed or not
		boolean imgDisplayed = driver.findElement(By.xpath("//div[@class = 'ui-overlaypanel-content']")).isDisplayed();
		if (imgDisplayed == true) {
			System.out.println("Testleaf image is displayed");
		} else {
			System.out.println("Testleaf image is not displayed");
		}
		// Dismiss the image
		driver.findElement(By.id("j_idt88:j_idt102:imageBtn")).click();
		// How many rounded buttons are there?
		// Find number of elements with tag button
		WebElement buttonElement = driver.findElement(By.xpath("//button[@id = 'j_idt88:j_idt107']/parent :: div"));
		List<WebElement> buttonElements = buttonElement.findElements(By.tagName("button"));
		// Loop each elements
		for (int i = 0; i < buttonElements.size(); i++) {
			WebElement webElement = buttonElements.get(i);
			// Check if the border-ragius value is there its rounded button else
			// its not
			String attribute = webElement.getCssValue("border-radius");
			if (attribute != " ") {
				// Count how many rounded buttons available
				buttonCount++;
			}
		}
		System.out.println("How many rounded buttons are there? " + buttonCount);
	}

}
