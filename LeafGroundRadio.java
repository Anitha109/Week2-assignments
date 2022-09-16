package week2.assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundRadio {

	public static void main(String[] args) {
		int count = 0;
		// Setup the browser driver
		WebDriverManager.chromedriver().setup();
		// Launch the browser
		ChromeDriver driver = new ChromeDriver();
		// Load the URL https://en-gb.facebook.com/
		driver.get("https://leafground.com/radio.xhtml");
		// Maximise the window
		driver.manage().window().maximize();

		// Your most favorite browser
		driver.findElement(By.xpath("//table[@id = 'j_idt87:console1']//label[text() = 'Chrome']")).click();
		// UnSelectable
		// Select the radio button and check whether its selected or not
		WebElement findElementUnSel = driver.findElement(By.xpath("(//div[@class = 'ui-g-12 ui-md-4'])[2]//span"));
		findElementUnSel.click();
		if (findElementUnSel.getDomAttribute("class").contains("ui-icon-bullet")) {
			System.out.println("Radio button is selected ");
		} else {
			System.out.println("Radio button is not selected ");
		}
		// Unselect the radio button
		findElementUnSel.click();
		if (findElementUnSel.getDomAttribute("class").contains("ui-icon-bullet")) {
			System.out.println("Radio button is selected ");
		} else {
			System.out.println("Radio button is unselected ");
		}
		// Find the default select radio button
		WebElement findElementDefault = driver.findElement(By.id("j_idt87:console2"));

		List<WebElement> findElementsDefault = findElementDefault.findElements(By.tagName("span"));
		for (int i = 0; i < findElementsDefault.size(); i++) {
			// Counting to know the selected radio button location
			count++;
			WebElement webElement = findElementsDefault.get(i);
			// If span node class attribute as ui-icon-bullet then that radio
			// button is selected
			if (webElement.getDomAttribute("class").contains("ui-icon-bullet")) {
				System.out.println(count + " Radio button is selected by default");
			}
		}
		// Select the age group (only if not selected)
		WebElement findElementAge = driver.findElement((By.id("j_idt87:age")));
		List<WebElement> findElementsAge = findElementAge.findElements(By.tagName("span"));
		count = 0;
		for (int i = 0; i < findElementsAge.size(); i++) {
			count++;
			WebElement webElement = findElementsAge.get(i);
			if (webElement.getDomAttribute("class").contains("ui-icon-bullet")) {
				System.out.println(count + " Radio button for age group is selected, No need to select");
			}
		}

	}

}
