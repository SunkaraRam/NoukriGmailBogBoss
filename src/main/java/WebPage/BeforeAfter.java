package WebPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BeforeAfter {
	
	
	public static WebDriver driver;
	
	
	
	public static void launchBrowser() {
		
		driver = new ChromeDriver();
	
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.manage().deleteAllCookies();
		
		
		
		}
	
	public static void close() {
		
		driver.quit();
		
	}
	
	
	

}
