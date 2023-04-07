package pageobjects;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	public static WebDriver driver;
	static WebDriverWait wait;
	BasePage basePage;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@FindBy(how = How.XPATH, using = "//button[@data-testid='sign-in-button']")
	private static WebElement link_SignIn;
	
	@FindBy(how = How.XPATH, using = "//h5[@data-testid='modal-heading']")
	private static WebElement header_SignIn;
	
	@FindBy(how = How.XPATH, using = "//button[@data-testid='register']")
	private static WebElement link_createAnAccount;

	@FindBy(how = How.XPATH, using = "//*[@data-testid='checkbox-label']")
	private static WebElement checkbox_rememberMe;
	
	@FindBy(how = How.XPATH, using = "//*[@data-testid='checkbox']")
	private static WebElement checkbox_rememberMeValue;
	
	@FindBy(how = How.CSS, using = "#signin-email")
	private static WebElement textfield_email;

	@FindBy(how = How.CSS, using = "#signin-password")
	private static WebElement textfield_password;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Sign in')]")
	private static WebElement btn_SignInUser;

	@FindBy(how = How.XPATH, using = "//a[@aria-label='View My Account']")
	private static WebElement link_MyAccount;
	
	@FindBy(how = How.XPATH, using = "//p[@class='error-text__RAc9']")
	private static WebElement error_credentialDoNotMatch;
	
	@FindBy(how = How.XPATH, using = "//button[@data-testid='modal-close-btn']")
	private static WebElement btn_closeSignInDialog;
	
	@FindBy(how = How.ID, using = "signin-email-helper-text")
	private static WebElement error_belowSignIn;

	@FindBy(how = How.ID, using = "signin-password-helper-text")
	private static WebElement error_belowPassword;
	
	public static WebElement getError_belowSignIn() {
		return error_belowSignIn;
	}

	public static WebElement getError_belowPassword() {
		return error_belowPassword;
	}
	

	public static WebElement getBtn_closeSignInDialog() {
		return btn_closeSignInDialog;
	}

	public static WebElement getError_credentialDoNotMatch() {
		return error_credentialDoNotMatch;
	}

	public static WebElement getLink_MyAccount() {
		return link_MyAccount;
	}

	public static WebElement getLink_SignIn() {
		return link_SignIn;
	}

	public static WebElement getTextfield_email() {
		return textfield_email;
	}

	public static WebElement getTextfield_password() {
		return textfield_password;
	}

	public static WebElement getBtn_SignInUser() {
		return btn_SignInUser;
	}
	
	public static WebElement getHeader_SignIn() {
		return header_SignIn;
	}

	public static WebElement getLink_createAnAccount() {
		return link_createAnAccount;
	}

	public static WebElement getCheckbox_rememberMe() {
		return checkbox_rememberMe;
	}
	
	public static WebElement getCheckbox_rememberMeValue() {
		return checkbox_rememberMeValue;
	}

	public static void clickOnSignInLink() {
		
		try {
			wait.until(ExpectedConditions.elementToBeClickable(link_SignIn));
			link_SignIn.click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	public static void setTextInEmailTextField(String email) {
		
		try {
			wait.until(ExpectedConditions.visibilityOf(textfield_email));
			textfield_email.sendKeys(email);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}

	}

	public static void setTextInPasswordTextField(String password) {
		try {
			wait.until(ExpectedConditions.visibilityOf(textfield_password));
			textfield_password.sendKeys(password);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}

	}
	
	public static void clickSignInButton() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btn_SignInUser));
			btn_SignInUser.click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}

	}
	
	public static void clickCloseButtonOnSignIn() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btn_closeSignInDialog));
			btn_closeSignInDialog.click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}

	}
	
//	public static String getText(WebElement ele) {
//		try {
//			wait.until(ExpectedConditions.visibilityOf(ele));
//			return ele.getText();
//		} catch (NoSuchElementException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//	
//	public static void selectRememberMeCheckBox(WebElement ele) {
//		try {
//			wait.until(ExpectedConditions.elementToBeClickable(checkbox_rememberMe));
//			checkbox_rememberMe.click();
//		} catch (NoSuchElementException e) {
//			e.printStackTrace();
//		}
//	}

}
