package Tests;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SystemDirector {

	public static void main(String[] args) {
	
		WebDriver driver;
		
		//System.setProperty("webdriver.chrome.driver", System.getProperty("dir")+"./DriversFFGC/chromedriver.exe");
		
		System.setProperty("webdriver.chrome.driver", "d://chromedriver.exe");
		
		driver = new ChromeDriver();
	
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://google.com");
		
		Set<Cookie> allCoockies = driver.manage().getCookies();
		
		System.out.println(allCoockies.size());
		
		for(Cookie cookie: allCoockies) {
			
			System.out.println("Name-- "+cookie.getName());
			
			System.out.println("Domain-- "+cookie.getDomain());
			
			System.out.println("Path-- "+cookie.getPath());
			
			System.out.println("Value-- "+cookie.getValue());
			
			System.out.println("Particular Cookie "+cookie);
		}
		
		driver.manage().deleteCookieNamed("NID");
		
		driver.manage().deleteCookieNamed("UULE");
		
		Set<Cookie> allCoockies1 = driver.manage().getCookies();
	
		System.out.println(allCoockies1.size());
		
		
//		driver.manage().deleteAllCookies();
//		
		
		
		//driver.get("https://google.com");
	
		
	}

}
