package WebPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailPage extends BeforeAfter {
	
	
	@FindBy(xpath = "//input[@id='identifierId']") WebElement UserTextBox;
	
	@FindBy(xpath = "//span[@class='CwaK9']") WebElement Unext;
	
	@FindBy(xpath = "//input[@name='password']") WebElement PasswordTextBox;
	
	@FindBy(xpath = "//div[@id='passwordNext']//span[@class='CwaK9']") WebElement Pnext;

	@FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-KE L3']") WebElement component;
	
	@FindBy(xpath = "//a[@class='gb_C gb_Ia gb_g']") WebElement logoutf;
	
	@FindBy(xpath = "//a[@id='gb_71']") WebElement logoutl;
	
	@FindBy(xpath = "//a[contains(text(),'Help')]") WebElement help;
	
	
	public boolean GmailLogin() throws Throwable {
		
		FileInputStream fi = new FileInputStream("D:\\NoukriGmailBigBoss\\PropertiesFile\\constants.properties");

		Properties prt = new Properties();
		
		prt.load(fi);
		
		UserTextBox.clear();
		
		UserTextBox.sendKeys(prt.getProperty("uid"));
		
		Unext.click();
		
		PasswordTextBox.sendKeys(prt.getProperty("pwd"));
		
		Pnext.click();
		
		Thread.sleep(5000);
		
		if (component.isDisplayed()) {
			
			return true;
			
		}
		
		else {
			
			return false;
		}
		
		
		
		
	}
	
	public boolean gmainLogout() {
		
		logoutf.click();
		
		logoutl.click();
		
		if (help.isDisplayed()) {
			
			return true;
		}
		
		return false;
		
	}
	
	

}
