package week2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundSelect {

	public static void main(String[] args) throws Exception {
		// Setup the browser driver
		WebDriverManager.chromedriver().setup();
		// Launch the browser
		ChromeDriver driver = new ChromeDriver();
		// Load the URL https://en-gb.facebook.com/
		driver.get("https://leafground.com/select.xhtml");
		// Maximise the window
		driver.manage().window().maximize();
		driver.navigate().refresh();
		// Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Which is your favorite UI Automation tool?
		WebElement selectTool = driver.findElement(By.xpath("//div[@class='grid formgrid']//select"));
		Select selectToolDD = new Select(selectTool);
		selectToolDD.selectByVisibleText("Selenium");
		// Choose your preferred country.
		driver.findElement(By.id("j_idt87:country_label")).click();
		driver.findElement(By.id("j_idt87:country_2")).click();
		// Confirm Cities belongs to Country is loaded
		Thread.sleep(3000);
		driver.findElement(By.id("j_idt87:city_label")).click();
		driver.findElement(By.id("j_idt87:city_2")).click();
		// Choose the Course
		driver.findElement(By.tagName("button")).click();
		driver.findElement(By.xpath("//li[text() = 'Selenium WebDriver']")).click();
		// Choose language randomly
		driver.findElement(By.id("j_idt87:lang_label")).click();
		driver.findElement(By.id("j_idt87:lang_3")).click();
		// Select 'Two' irrespective of the language chosen
		Thread.sleep(3000);
		driver.findElement(By.id("j_idt87:value_label")).click();

		driver.findElement(By.id("j_idt87:value_2")).click();

	}

}
