package paly_with_WebDriver;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Heroku_checkboxs {
	
	WebDriver driver;
	
	@BeforeTest
	public void visit() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		Thread.sleep(4000);
	}
	@Test
	public void checkbox() throws InterruptedException {
		driver.findElement(By.linkText("Checkboxes")).click();
		
		System.out.println("Navigate to Checkboxes page");
		
		String PageText = driver.findElement(By.xpath("//div[@id='content']/div/h3")).getText();
		System.out.println();
		System.out.println("Header of the page is "+PageText);
		Assert.assertEquals(PageText, "Checkboxes");
		System.out.println("Now We are in Checkboxes page");
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
		Thread.sleep(4000);
		System.out.println("Chcekboxes selected and deselected");
		
		
	}
	@AfterTest
	public void close() {
		driver.quit();
		System.out.println();
		System.out.println("Browser is closed");
	}

}
