package Tests;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import WebPage.FlipKartPage;

public class FlipKartTest{

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\LatestDrivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.flipkart.com/");
	
		FlipKartPage fp = PageFactory.initElements(driver, FlipKartPage.class);
		
		fp.popup.click();
		
		fp.serachBox.sendKeys("shoes");
		
		Actions act = new Actions(driver);
		
		act.sendKeys(Keys.ENTER).build().perform();
		
		Thread.sleep(1000);
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,300)");
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		
		WebElement min = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_1qKb_B']//select[@class='fPjUPw']")));
		
		min.click();

		fp.minPrice.click();
		
		Thread.sleep(2000);
				
		js.executeScript("arguments[0].scrollIntoView()",fp.drag);
		
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_36jUgy']//child::*[contains(text(),'Nike')]")));
		
		element.click();
				
		String parent = driver.getWindowHandle();
		
		System.out.println(parent);
		
		WebElement ele =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_3O0U0u']//child::div[contains(@data-id,'SHOFG2B26TGKJ64S')]")));
		
		ele.click();
		
		Set<String> wins = driver.getWindowHandles();
		
		for (String ch: wins) {
			
			if (!parent.equalsIgnoreCase(ch)) {
	
				driver.switchTo().window(ch);//Here we are swiching each and every window
				
				js.executeScript("arguments[0].scrollIntoView()",fp.dragToDelivery);
			
				fp.shoeSize.click();
				
				fp.buyNow.click();
				
			}
			
		}	
		
	
	}

}
