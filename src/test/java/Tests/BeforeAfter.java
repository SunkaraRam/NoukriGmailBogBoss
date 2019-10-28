package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BeforeAfter {
	
	
	public WebDriver driver;
	
	
	@BeforeSuite
	public void launchBrowser() {
		
		driver = new ChromeDriver();
	
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.manage().deleteAllCookies();
		
		
		
		}
	@AfterSuite
	public void close() {
		
		driver.quit();
		
	}
	
	
	

}
