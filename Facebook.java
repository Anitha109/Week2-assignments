package week2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) throws InterruptedException {
		// Setup the browser driver
		WebDriverManager.chromedriver().setup();
		// Launch the browser
		ChromeDriver driver = new ChromeDriver();
		// Load the URL https://en-gb.facebook.com/
		driver.get("https://en-gb.facebook.com");
		// Maximise the window
		driver.manage().window().maximize();
		// Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//button[@class = '_42ft _4jy0 _9xo6 _4jy3 _4jy1 selected _51sy']")).click();
		// Click on Create New Account button
		driver.findElement(By.xpath("//a[@class = '_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
		// Enter the first name
		driver.findElement(By.xpath("//input[@name = 'firstname']")).sendKeys("Anitha");
		// Enter the last name
		driver.findElement(By.xpath("//input[@name = 'lastname']")).sendKeys("Mahendran");
		// Enter the mobile number
		driver.findElement(By.xpath("//input[@name = 'reg_email__']")).sendKeys("9876543210");
		// Enter the password
		driver.findElement(By.id("password_step_input")).sendKeys("12345678");
		// Select Day of Birth from Drop down
		WebElement day = driver.findElement(By.id("day"));
		Select daydd = new Select(day);
		daydd.selectByVisibleText("10");
		// Select Month of Birth from Drop down
		WebElement month = driver.findElement(By.id("month"));
		Select monthdd = new Select(month);
		monthdd.selectByVisibleText("May");
		// Select Birth year from Drop down
		WebElement year = driver.findElement(By.id("year"));
		Select yeardd = new Select(year);
		yeardd.selectByVisibleText("1990");
		// Select the radio button "Female"
		driver.findElement(By.xpath("//label[text() ='Female']")).click();
	}

}
