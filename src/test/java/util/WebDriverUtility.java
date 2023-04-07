package util;

import java.time.Duration;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageobjects.BasePage;

public class WebDriverUtility {
	
	static WebDriver driver;
	static WebDriverWait wait;
	public WebDriverUtility(WebDriver driver) {
		WebDriverUtility.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public static String getText(WebElement ele) {
		try {
			wait.until(ExpectedConditions.visibilityOf(ele));
			return ele.getText();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void selectRememberMeCheckBox(WebElement ele) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
	public static void addCookies(String cookieName, String cookieValue) {
		driver.manage().addCookie(new Cookie(cookieName, cookieValue));
	}
	
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
