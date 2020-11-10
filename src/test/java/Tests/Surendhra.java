package Tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

import WebPage.NoukriPage;

public class Surendhra {

	public static WebDriver driver;

	public static void main(String[] args) throws Throwable {

		System.setProperty("webdriver.ie.driver", "C:\\Users\\SunkaraRam\\Desktop\\Display\\IEDriverServer.exe");
		
		driver = new InternetExplorerDriver();

		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.manage().deleteAllCookies();	
			
			FileInputStream fi = new FileInputStream("D:\\NoukriGmailBigBoss\\PropertiesFile\\constants.properties");

			Properties prt = new Properties();
			
			prt.load(fi);
			
			driver.get(prt.getProperty("noukriurl"));
			
			NoukriPage np = PageFactory.initElements(driver, NoukriPage.class);
			
			boolean res = np.noukriLogin();
		
	}

} 
