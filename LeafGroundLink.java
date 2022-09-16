package week2.assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundLink {

	public static void main(String[] args) {
		// Setup the browser driver
		WebDriverManager.chromedriver().setup();
		// Launch the browser
		ChromeDriver driver = new ChromeDriver();
		// Load the URL https://en-gb.facebook.com/
		driver.get("https://leafground.com/link.xhtml");
		// Maximise the window
		driver.manage().window().maximize();
		// Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Take me to dashboard
		driver.findElement(By.xpath("//a[text() = 'Go to Dashboard']")).click();
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Take me to dashboard link navigated to : " + driver.getTitle());
		// Go back to previous browser link
		driver.navigate().back();
		// Find my destination
		driver.findElement(By.xpath("//a[text() = 'Find the URL without clicking me.']")).click();
		System.out.println("Destination URL link : " + driver.getCurrentUrl());
		// Go back to previous browser link
		driver.navigate().back();
		// Am I broken link?
		driver.findElement(By.xpath("//a[text() = 'Broken?']")).click();
		if (driver.getTitle().contains("404")) {
			System.out.println(driver.getCurrentUrl() + " link is broken ");
		}
		// Go back to previous browser link
		driver.navigate().back();
		// Duplicate Link
		driver.findElement(By.xpath("(//a[text() = 'Go to Dashboard'])[2]")).click();
		if (currentUrl.equals(driver.getCurrentUrl())) {
			System.out.println("Its a Duplicate link");
		} else {
			System.out.println("Its not a Duplicate link");
		}
		// Go back to previous browser link
		driver.navigate().back();
		// How many links in this page?
		List<WebElement> findElementsPage = driver.findElements(By.xpath("//div[@class = 'col-12']"));
		System.out.println("How many links in this page? " + findElementsPage.size());
		// How many links in this layout?
		List<WebElement> findElementsLayout = driver
				.findElements(By.xpath("(//div[@class = 'col-12 md:col-6'])[2]//div[@class = 'col-12']"));
		System.out.println("How many links in this layout? " + findElementsLayout.size());
	}

}
