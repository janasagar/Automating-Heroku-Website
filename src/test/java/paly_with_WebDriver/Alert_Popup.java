package paly_with_WebDriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Alert_Popup { 
	WebDriver driver;
	
	@BeforeTest
	public void vist() throws InterruptedException {
		driver = new ChromeDriver();
		 driver.get("https://the-internet.herokuapp.com/");
		 driver.manage().window().maximize();
		 Thread.sleep(4000);
	}
	@Test
	public void Visit_pop_up() throws InterruptedException {
		driver.findElement(By.linkText("JavaScript Alerts")).click();
		Thread.sleep(4000);
	}
	@Test(dependsOnMethods = "Visit_pop_up")
	public void alrt() throws InterruptedException {
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		Thread.sleep(4000);
		
		Alert art = driver.switchTo().alert();
		
		String msg = driver.switchTo().alert().getText();
		
		System.out.println("Alert message is "+ msg);
		
		art.accept();
		Thread.sleep(3000);
		
	}
	@AfterTest
	public void close() {
		driver.quit();
	}
}
