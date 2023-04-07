package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import util.WebDriverUtility;

public class BasePage {
	
	public WebDriver driver;
	
	LoginPage loginPage;
	WebDriverUtility webDriverUtility;
	
	
	public void intializePageObjects(WebDriver driver) {
		loginPage = new LoginPage(driver);
		webDriverUtility = new WebDriverUtility(driver);
		
	}

	public void initDriver() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public LoginPage getLoginPage() {
		return loginPage;
	}

}
