package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import util.WebDriverUtility;
import org.openqa.selenium.chrome.ChromeOptions;

public class BasePage {
	
	public WebDriver driver;
	
	LoginPage loginPage;
	WebDriverUtility webDriverUtility;
	
	public void intializePageObjects(WebDriver driver) {
		loginPage = new LoginPage(driver);
		webDriverUtility = new WebDriverUtility(driver);		
	}
	
	/**
     * This function is used to initialize Webdriver based on browser variable value
     * passed at runtime.
     */
	public void initDriver() throws Exception {
		String browserName = System.getProperty("browser");
		try {
			switch (browserName.toUpperCase()) {
			case "FIREFOX" :
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "CHROME" :
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(chromeOptions);
				break;
			default :
				throw new Exception("Incorrect browser name provided");
			}
			driver.manage().window().maximize();
		} catch (NullPointerException e){
			throw new Exception("Browser name not provided");
		} catch (Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public LoginPage getLoginPage() {
		return loginPage;
	}

}
