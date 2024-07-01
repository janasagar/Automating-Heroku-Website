package paly_with_WebElement_WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class dropdown {
	WebDriver driver;
	
	@BeforeTest
	public void visit() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.manage().window().maximize();
		Thread.sleep(4000);
	}
	@Test
	public void drpdwn() throws InterruptedException {
		driver.findElement(By.linkText("Dropdown")).click();
		Thread.sleep(5000);
		WebElement el = driver.findElement(By.id("dropdown"));
		Select dwn = new Select(el);
		
		dwn.selectByValue("2");
		Thread.sleep(3000);
		
	}
	
	@AfterTest
	public void close() {
		driver.quit();
	}

}
