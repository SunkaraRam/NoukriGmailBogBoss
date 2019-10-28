package WebPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class NoukriPage {

	@FindBy(xpath = "//a[@class='primary-link']") WebElement loginLink;
	
	@FindBy(xpath = "//input[@id='usernameField']") WebElement N_Usertextbox; 
	
	@FindBy(xpath = "//input[@id='passwordField']") WebElement N_Pwdtextbox;
	
	@FindBy(xpath = "//button[@class='waves-effect waves-light btn-large btn-block btn-bold blue-btn']") WebElement Loginbutton;
	
	@FindBy(xpath = "//a[@class='fl nLogo']//img") WebElement logo;
	
	@FindBy(xpath = "//div[contains(text(),'My Naukri')]") WebElement Noukrilog;
	
	@FindBy(xpath = "//a[@class='logout-gnb']") WebElement logout;
	
	public boolean noukriLogin() throws Throwable {
		
		FileInputStream fi = new FileInputStream("D:\\NoukriGmailBigBoss\\PropertiesFile\\constants.properties");
		
		Properties prt = new Properties();
		
		prt.load(fi);
				
		loginLink.click();
		
		N_Usertextbox.sendKeys(prt.getProperty("nuid"));
		
		N_Pwdtextbox.sendKeys(prt.getProperty("npwd"));
		
		Loginbutton.click();
		
		if (logo.isDisplayed()) {
			
			return true;
			
		}
		
		return false;
	}	
	
public void noukriLogout() {
		
			
		logout.click();
		
//		if (Loginbutton.isDisplayed()) {
//			
//			return true;
//			
//		}
//		
//		return false;
//	
	}
	
	
}
