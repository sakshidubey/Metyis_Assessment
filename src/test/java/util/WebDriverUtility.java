package util;

import java.time.Duration;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	static WebDriver driver;
	static WebDriverWait wait;
	public WebDriverUtility(WebDriver driver) {
		WebDriverUtility.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	/**
     * Get a text value of a Web element.
     * @params : WebElement
     * @return : String
     */
	public static String getText(WebElement ele) {
		try {
			wait.until(ExpectedConditions.visibilityOf(ele));
			return ele.getText();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
     * Select check box by providing Web Element.
     * @params : WebElement
     */
	public static void selectCheckBox(WebElement ele) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
	/**
     * Add cookies in the browser.
     * @params : Cookie name in string
     * @params : Cookie value in string
     */
	public static void addCookies(String cookieName, String cookieValue) {
		driver.manage().addCookie(new Cookie(cookieName, cookieValue));
	}
	
	/**
     * Check Web element is visible.
     * @params : WebElement
     * @return : boolean
     */
	public static boolean isElementVisible(WebElement ele) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			return ele.isDisplayed();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return false;
	}

}
