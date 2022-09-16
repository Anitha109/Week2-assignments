package week2.assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundCheckbox {

	public static void main(String[] args) throws InterruptedException {
		// Setup the browser driver
		WebDriverManager.chromedriver().setup();
		// Launch the browser
		ChromeDriver driver = new ChromeDriver();
		// Load the URL https://en-gb.facebook.com/
		driver.get("https://leafground.com/checkbox.xhtml");
		// Maximise the window
		driver.manage().window().maximize();
		// Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Basic Checkbox click
		driver.findElement(By.id("j_idt87:j_idt89")).click();
		// Notification check
		driver.findElement(By.id("j_idt87:j_idt91")).click();
		boolean displayed = driver.findElement(By.xpath("//span[@class = 'ui-growl-title']")).isDisplayed();
		System.out.println("Alert displayed ? " + displayed);
		// Choose your favorite language(s)
		driver.findElement(By.xpath("//table[@id='j_idt87:basic']//label[text() = 'Java']")).click();
		driver.findElement(By.xpath("//table[@id='j_idt87:basic']//label[text() = 'Javascript']")).click();
		//Tri State Checkbox
		driver.findElement(By.id("j_idt87:ajaxTriState")).click();
		boolean displayedStateAlert = driver.findElement(By.xpath("//span[@class = 'ui-growl-title']")).isDisplayed();
		System.out.println("State Alert displayed ? " + displayedStateAlert);
		//Toggle Switch
		driver.findElement(By.className("ui-toggleswitch-slider")).click();
		//Verify if check box is disabled
		boolean enabled = driver.findElement(By.id("j_idt87:j_idt102")).isEnabled();
		System.out.println("Checkbox is disabled ? " + enabled);
		//Select Multiple
		driver.findElement(By.id("j_idt87:multiple")).click();
		Thread.sleep(5000);
		//This part is not working
//		System.out.println(driver.findElement(By.xpath("//div[@id = 'j_idt87:multiple']//label[text() = 'Miami']")).isDisplayed());
//		driver.findElement(By.xpath("//div[@id = 'j_idt87:multiple']//label[text() = 'Rome']")).click();
	}

}
