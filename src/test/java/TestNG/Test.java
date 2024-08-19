package TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Test {

	WebDriver driver;

	@BeforeMethod

	public void start() {

		// Open Browser

		driver = new FirefoxDriver();

		// Enter Url

		driver.get("https://www.redbus.in/");

		// use implicit waits for prevention of element interceptions

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@org.testng.annotations.Test

	public void main1() {

		// Enter the word "De" in From by inspecting it

		driver.findElement(By.xpath("(//*[@class='sc-bxivhb dsDRlf'])[1]")).sendKeys("De");

		// Click on the Dropdown option of Delhi

		driver.findElement(By.cssSelector("[class='sc-iwsKbI jTMXri cursorPointing']")).click();

		// Enter "Ban" in Destination by inspecting it

		driver.findElement(By.cssSelector("#dest")).sendKeys("Ban");

		// Click on option of Bangalore in Dest

		driver.findElement(By.cssSelector("[class='sc-iwsKbI jTMXri cursorPointing']")).click();

		// Click on the Date to select it

		driver.findElement(By.cssSelector(".dateText")).click();

		// Select 20 august date for travelling

		driver.findElement(By.xpath("//*[.='20']")).click();

		// Search for that day options

		driver.findElement(By.cssSelector("#search_button")).click();

		// Create a String Variable for getting assertion into text

		String assrt = driver.findElement(By.cssSelector(".msg")).getText();

		// Verify that this text has been shown after searching on 20 August

		Assert.assertEquals(assrt, "Oops! No buses found.");

	}

	@AfterMethod

	public void teardown() throws InterruptedException {

		// Use thread to wait for 2 more seconds before closing the browser

		Thread.sleep(2000);

		// Close the Browser

		driver.close();
	}

}
