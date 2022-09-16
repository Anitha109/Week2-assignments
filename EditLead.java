package week2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) {
		// Setup the browser driver
		WebDriverManager.chromedriver().setup();
		// Launch the browser
		ChromeDriver driver = new ChromeDriver();
		// url to open in the browser
		driver.get("http://leaftaps.com/opentaps/control/main");
		// Maximize the browser
		driver.manage().window().maximize();
		// Enter UserName Using Id Locator
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		// Enter Password Using Id Locator
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		// Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
		// Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
		// Click on Leads Button
		driver.findElement(By.linkText("Leads")).click();
		// Click on Create Lead
		driver.findElement(By.linkText("Create Lead")).click();
		// Enter CompanyName Field Using id Locator
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Cognizant");
		// Enter FirstName Field Using id Locator
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Anitha");
		// Enter LastName Field Using id Locator
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Mahendran");
		// Enter FirstName(Local) Field Using id Locator
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Anitha");
		// Enter Department Field
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Testing");
		// Enter Description Field
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Week2 assignment for Edit Lead");
		// Enter your email in the E-mail address Field
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("testemail@gmail.com");
		// Select State/Province as NewYork Using Visible Text
		WebElement state = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select stateDD = new Select(state);
		stateDD.selectByVisibleText("New York");
		// Click on Create Button
		driver.findElement(By.className("smallSubmit")).click();

		// Click on Edit button
		driver.findElement(By.xpath("//a[@class = 'subMenuButton'][3]")).click();
		// Clear the CompanyName Field using .clear() And Enter new CompanyName
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Testleaf");
		// Clear the FirstName Field using .clear() And Enter new FirstName
		driver.findElement(By.id("updateLeadForm_firstName")).clear();
		driver.findElement(By.id("updateLeadForm_firstName")).sendKeys("Anitha123");
		// Click on Update Button
		driver.findElement(By.className("smallSubmit")).click();

	}

}
