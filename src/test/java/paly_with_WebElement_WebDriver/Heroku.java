package paly_with_WebElement_WebDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Heroku {
	WebDriver driver;
	
	@BeforeTest
	public void visit() {
		WebDriverManager.chromiumdriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		
				
	}
	@Test
	public void add_remove() {
		driver.findElement(By.linkText("Add/Remove Elements")).click();
		System.out.println("Navigate to Add/Remove Elements page");
		
		String PageText = driver.findElement(By.xpath("//div[@id='content']/h3")).getText();
		System.out.println();
		System.out.println("Header of the page is "+PageText);
		Assert.assertEquals(PageText, "Add/Remove Elements");
		System.out.println("Now We are in Add/Remove Elements page");
		
		driver.findElement(By.xpath("//button[text()='Add Element']")).click();
		System.out.println("ADD an Element");
		
		
		WebElement delete_bt = driver.findElement(By.xpath("//button[text()='Delete']"));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(delete_bt));
		System.out.println("Element is created");
		
		System.out.println();
		
		System.out.println("Delete the element");
		delete_bt.click();
		System.out.println("Element is deleted");
		
		
		
	}
	@AfterTest
	public void close() {
		driver.quit();
		System.out.println("Browser is closed");
	}

}
