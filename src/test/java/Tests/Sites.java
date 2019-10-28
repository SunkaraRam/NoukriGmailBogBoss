package Tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import WebPage.BeforeAfter;
import WebPage.GmailPage;
import WebPage.NoukriPage;

public class Sites {
	
	public WebDriver driver;
	
	@BeforeSuite
	public void launchBrowser() {
		
		driver = new ChromeDriver();
	
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.manage().deleteAllCookies();
	
		
		}
	
	
	
	
	@Test(enabled = false)
	public void gmailTest() throws Throwable {
				
		FileInputStream fi = new FileInputStream("D:\\NoukriGmailBigBoss\\PropertiesFile\\constants.properties");

		Properties prt = new Properties();
		
		prt.load(fi);
		
		driver.get(prt.getProperty("gmailurl"));
		
		GmailPage gp = PageFactory.initElements(driver, GmailPage.class);
		
		boolean res = gp.GmailLogin();
		
		//Assert.assertEquals(res, true);
		
		Assert.assertTrue(res);
		
	}
	@Test(enabled = false)
	public void noukriTest() throws Throwable {
		
		FileInputStream fi = new FileInputStream("D:\\NoukriGmailBigBoss\\PropertiesFile\\constants.properties");

		Properties prt = new Properties();
		
		prt.load(fi);
		
		driver.get(prt.getProperty("noukriurl"));
		
		NoukriPage np = PageFactory.initElements(driver, NoukriPage.class);
		
		boolean res = np.noukriLogin();
		
		Assert.assertTrue(res);
				
	}
	
	@Test
	public void bigBossVote() throws Throwable {
		
		FileInputStream fi = new FileInputStream("D:\\NoukriGmailBigBoss\\PropertiesFile\\constants.properties");

		Properties prt = new Properties();
		
		prt.load(fi);

		driver.get(prt.getProperty("bigbossurl"));
		
		WebElement mahesh =  driver.findElement(By.xpath("//span[contains(text(),'Mahesh Vitta')]"));
		
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		
		js.executeScript("arguments[0].scrollIntoView();", mahesh);
			
		if (!mahesh.isSelected()) {
			
			mahesh.click();
			
		}
		
		driver.findElement(By.xpath("//a[@id='pd-vote-button10409946']")).click();
	
		WebElement thanks =driver.findElement(By.xpath("//div[@class='pds-question-top']"));
		
		if (thanks.isDisplayed()) {
			
			Assert.assertTrue(true);
		}
		else {
			Assert.assertFalse(false);
		}
	}
	
	
	
	
	
	@AfterSuite
	public void close() {
		
		driver.quit();
		
	}
	
//	public static void main(String[] args) throws Throwable {
//		
//	
//		driver = new ChromeDriver();
//		
//		driver.manage().window().maximize();
//		
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		
//		driver.manage().deleteAllCookies();
//		
//		FileInputStream fi = new FileInputStream("D:\\NoukriGmailBigBoss\\PropertiesFile\\constants.properties");
//		
//		Properties prt = new Properties();
//		
//		prt.load(fi);
//		
//		driver.get(prt.getProperty("url"));
//		
//		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys(prt.getProperty("uid"));;
//		
//		driver.findElement(By.xpath("//span[@class='CwaK9']")).click();
//		
//		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(prt.getProperty("pwd"));
//		
//		driver.findElement(By.xpath("//div[@id='passwordNext']//span[@class='CwaK9']")).click();
//		
//		
//	
//	}
	
	}


