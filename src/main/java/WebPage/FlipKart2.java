package WebPage;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipKart2 {

		
		public static void main(String[] args) throws InterruptedException {
			
			System.setProperty("webdriver.chrome.driver", "d://chromedriver.exe");
			
			WebDriver driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			
			driver.manage().deleteAllCookies();
			
			driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			driver.get("https://www.flipkart.com/");
			
			driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
			
			driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more'][1]")).sendKeys("Shoes");
			
			Actions act = new Actions(driver);
			
			act.sendKeys(Keys.ENTER).build().perform();
			
			Thread.sleep(1000);
			
			JavascriptExecutor js= (JavascriptExecutor)driver;
			
			js.executeScript("window.scrollBy(0,500)");
			
			WebDriverWait wait=new WebDriverWait(driver,20);
			
			WebElement min = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_1qKb_B']//select[@class='fPjUPw']")));
			
			Thread.sleep(2000);
			
			min.click();
			
			//driver.findElement(By.xpath("//div[@class='_1qKb_B']//select[@class='fPjUPw']")).click();
			
			driver.findElement(By.xpath("//div[@class='_1qKb_B']//select[@class='fPjUPw']//child::*[contains(text(),'500')][1]")).click();
		
			Thread.sleep(2000);
			
			WebElement brand  = driver.findElement(By.xpath("//div[@class='_2rIV_l']//img[@src='//img1a.flixcart.com/www/linchpin/fk-cp-zion/img/fa_8b4b59.png']"));
					
			js.executeScript("arguments[0].scrollIntoView()",brand);
			
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_36jUgy']//child::*[contains(text(),'Nike')]")));
			
			element.click();
			
			//driver.findElement(By.xpath("//div[@class='_36jUgy']//child::*[contains(text(),'Nike')]")).click();
			
			//Thread.sleep(2000);
			
			String parent = driver.getWindowHandle();
			
			System.out.println(parent);
			
			WebElement ele =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_3O0U0u']//child::div[contains(@data-id,'SHOFG2B26TGKJ64S')]")));
			
			ele.click();
			
			Set<String> wins = driver.getWindowHandles();
			
			for (String ch: wins) {
				
				if (!parent.equalsIgnoreCase(ch)) {
		
					driver.switchTo().window(ch);
					
					WebElement uk = driver.findElement(By.xpath("//span[@class='_1nBnpg' or text()='Deliver to']"));
		
					js.executeScript("arguments[0].scrollIntoView()",uk);
					
					driver.findElement(By.xpath("//li[@id='swatch-0-size']/parent::ul[@class='fUBI-_']/child::li[3]")).click();
					
					driver.findElement(By.xpath("//form[1]/child::button[1]")).click();
					
				}
				
			}
			
			//driver.findElement(By.xpath("//div[@class='_3O0U0u']//child::div[contains(@data-id,'SHOF')][3]")).click();
			
			
		
		}
	
}
