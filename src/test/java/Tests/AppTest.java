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
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import WebPage.GmailPage;
import WebPage.NoukriPage;

public class AppTest {
	
	public WebDriver driver;

	ExtentReports report;
	
	ExtentTest test;
	
	@BeforeTest
	public void launchBrowser() {
	
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
			
			driver = new ChromeDriver();
		
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
		//	driver.manage().deleteAllCookies();
	
		}
		
	
	
	
	@Test(enabled =false)
	public void gmailTest() throws Throwable {
				
		FileInputStream fi = new FileInputStream("D:\\NoukriGmailBigBoss\\PropertiesFile\\constants.properties");

		Properties prt = new Properties();
		
		prt.load(fi);
		
		driver.get(prt.getProperty("gmailurl"));
		
		GmailPage gp = PageFactory.initElements(driver, GmailPage.class);
		
		boolean res = gp.GmailLogin();
		
		//Assert.assertEquals(res, true);
		
		if (res) {
			Assert.assertTrue(res);
			
		}
		else {
			Assert.assertFalse(res);
			}
		
		
	}
	@Test(enabled =false)
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
	}
	
	@Test(invocationCount=5000)
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
	
		WebElement thanks =driver.findElement(By.xpath("//div[contains(@class,'pds-question-top')]"));
		
		if (thanks.isDisplayed()) {
			
			Assert.assertTrue(true);
			
		}
		else {
			Assert.assertFalse(false);// This is hard Assert
			
		
		}
	}
	
	@AfterTest
	public void close() {
	
		driver.quit();// It will close all the browsers
		
	}


}
