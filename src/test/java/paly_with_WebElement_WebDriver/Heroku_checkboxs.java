package paly_with_WebElement_WebDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Heroku_checkboxs {
	
	WebDriver driver;
	
	@BeforeTest
	public void visit() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
	}
	@Test
	public void checkbox() {
		driver.findElement(By.linkText("Checkboxes")).click();
		System.out.println("Navigate to Checkboxes page");
		
		String PageText = driver.findElement(By.xpath("//div[@id='content']/div/h3")).getText();
		System.out.println();
		System.out.println("Header of the page is "+PageText);
		Assert.assertEquals(PageText, "Checkboxes");
		System.out.println("Now We are in Checkboxes page");
		
		List<WebElement>  check_Boxs = driver.findElements(By.id("checkboxes"));
		int size = check_Boxs.size();
		for(int i=0;i<size;i++) {
			check_Boxs.get(i).click();
		}
		System.out.println("Chcekboxes selected and deselected");
		
		
	}
	@AfterTest
	public void close() {
		driver.quit();
		System.out.println();
		System.out.println("Browser is closed");
	}

}
