package paly_with_WebDriver;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class new_tab {
	
	WebDriver driver;
	
	@BeforeTest
	public void visit() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		Thread.sleep(4000);
	}
	@Test
	public void new_window() throws InterruptedException {
		driver.findElement(By.linkText("Multiple Windows")).click();
		Thread.sleep(4000);
		driver.findElement(By.linkText("Click Here")).click();
		
		Set<String> tabs = driver.getWindowHandles();
		Iterator<String> it = tabs.iterator();
		String parrentid = it.next();
		String childid = it.next();
		
		driver.switchTo().window(childid);
		Thread.sleep(4000);
		driver.close();
		driver.switchTo().window(parrentid);
		
	}
	@AfterTest
	public void close() {
		driver.quit();
	}

}
