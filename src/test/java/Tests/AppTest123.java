package Tests;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import WebPage.GmailPage;
import WebPage.NoukriPage;

public class AppTest123 {
	
	
	public WebDriver driver;

	
	//@Parameters({"browser"})
	@BeforeTest
	public void launchBrowser(String brw) {
		
		if (brw.equalsIgnoreCase("chrome")) {
	
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
			
			driver = new ChromeDriver();
		
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			driver.manage().deleteAllCookies();
			
			//driver.get("https://google.com");
		}
		
		 if(brw.equalsIgnoreCase("Firefox")) {
			
		System.setProperty("webdriver.gecko.driver", "D:\\NoukriGmailBigBoss\\DriversFFGC\\geckodriver.exe");
			
			driver = new FirefoxDriver();   
		
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			driver.manage().deleteAllCookies();			
		}
		
		else if(brw.equalsIgnoreCase("ie")) {
			
			System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer.exe");
				
				driver = new InternetExplorerDriver();
			
				driver.manage().window().maximize();
				
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
				driver.manage().deleteAllCookies();	
			}
		}
	
	
	
	
	@Test(enabled=false)
	public void gmailTest() throws Throwable {
				
		FileInputStream fi = new FileInputStream("D:\\NoukriGmailBigBoss\\PropertiesFile\\constants.properties");

		Properties prt = new Properties();
		
		prt.load(fi);
		
		driver.get(prt.getProperty("gmailurl"));
		
		GmailPage gp = PageFactory.initElements(driver, GmailPage.class);
		
		boolean res = gp.GmailLogin();
		
		Assert.assertTrue(res);
//		
//		if (res) {
//			Assert.assertTrue(res);
//			
//		}
//		else {
//			Assert.assertFalse(res);
//		
//			
//		}
		
		boolean res1 = gp.gmainLogout();
		
		System.out.println(res1);
	}
	@Test(enabled=false)
	public void noukriTest() throws Throwable {
		
		FileInputStream fi = new FileInputStream("D:\\NoukriGmailBigBoss\\PropertiesFile\\constants.properties");

		Properties prt = new Properties();
		
		prt.load(fi);
		
		driver.get(prt.getProperty("noukriurl"));
		
		NoukriPage np = PageFactory.initElements(driver, NoukriPage.class);
		
		boolean res = np.noukriLogin();
		if (res) {
			Assert.assertTrue(res);
		
		}
		else {
			Assert.assertFalse(res);
			
			
		}		
		
		Actions act = new Actions(driver);
		
		act.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'My Naukri')]")));
		
		act.build().perform();
		
		Thread.sleep(2000);
		
		np.noukriLogout();
		
	}
	
	@Test(invocationCount=500)
	public void bigBossVote() throws Throwable {
		
		FileInputStream fi = new FileInputStream("D:\\NoukriGmailBigBoss\\PropertiesFile\\constants.properties");

		Properties prt = new Properties();
		
		prt.load(fi);

		driver.get(prt.getProperty("bigbossurl"));
		
		WebElement Rahul =  driver.findElement(By.xpath("//span[@id='pds-answer10415372']/child::span[5]//child::label"));
		
		WebElement dragEle = driver.findElement(By.xpath("//div[@class='css-question-top pds-question-top' and contains(text(),'Bigg Boss Telugu Season 3 Final winner Voting')]"));
		
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		
		js.executeScript("window.scrollBy(0,1000)");
		
		if (!Rahul.isSelected()) {
			
			Rahul.click();
			
		}
		driver.findElement(By.xpath("//a[@id='pd-vote-button10415372']")).click();
		
		//Thread.sleep(3000);
	
//		WebElement thanks =driver.findElement(By.xpath("//div[@class='pds-question-top']"));
//		
//		if (thanks.isDisplayed()) {
//			
//			Assert.assertTrue(true);
//			test.log(LogStatus.FAIL, "Big Boss Vote Pass");
//			
//		}
//		else {
//			Assert.assertFalse(false);
//			test.log(LogStatus.FAIL, "Big Boss Vote Fail");// Here we are checking bigboss Assertion
//			
//		
//		}
	}
	
	@AfterTest
	public void close() {
		
		
		driver.quit();
		
	}

}
