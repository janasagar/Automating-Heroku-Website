package paly_with_WebElement_WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class form_auth {
	WebDriver driver;
	
	@BeforeTest
	public void visit() throws InterruptedException {
		driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	@Test
	public void login() throws InterruptedException {
		driver.findElement(By.linkText("Form Authentication")).click();
		Thread.sleep(4000);
		driver.findElement(By.name("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
		Thread.sleep(4000);
		String url = driver.getCurrentUrl();
		Assert.assertEquals("https://the-internet.herokuapp.com/secure", url);
		System.out.println("Login successful!");
	}
	@AfterTest
	public void close() {
		driver.quit();
	}

}
