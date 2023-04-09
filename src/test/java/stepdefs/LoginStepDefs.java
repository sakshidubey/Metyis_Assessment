package stepdefs;

import java.io.IOException;

import java.time.Duration;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.BasePage;
import pageobjects.LoginPage;
import util.Constants;
import util.ReadPropertiesFile;
import util.WebDriverUtility;

public class LoginStepDefs {

	WebDriver driver;
	BasePage basePage;
	WebDriverWait wait;

	public LoginStepDefs(BasePage basePage) {
		this.basePage = basePage;
		driver = basePage.getDriver();
		System.out.println("Driver name : "+driver);
		basePage.intializePageObjects(driver);
		new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@Given("^I navigate to the application URL \"([^\"]*)\"$")
	public void navigate_to_the_application_url(String url) throws IOException {
		String url1 = ReadPropertiesFile.getApplicationUrl();
		driver.get(url1);
		WebDriverUtility.addCookies("PVH_COOKIES_GDPR", "Accept");
		WebDriverUtility.addCookies("PVH_COOKIES_GDPR_ANALYTICS", "Accept");
		WebDriverUtility.addCookies("PVH_COOKIES_GDPR_SOCIALMEDIA", "Accept");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.navigate().refresh();
	}
	
	@When("I click on Sign In button")
	public void i_click_on_sign_in_button() {
		LoginPage.clickOnSignInLink();
	}

	@When("I enter valid login credentials")
	public void i_enter_valid_login_credentials() throws InterruptedException {
		i_click_on_sign_in_button();
		LoginPage.setTextInEmailTextField(Constants.VALID_USERNAME);
		LoginPage.setTextInPasswordTextField(Constants.VALID_PASSWORD);
		LoginPage.clickSignInButton();
	}

	@Then("I should logged in successfully in the application")
	public void i_should_logged_in_successfully_in_the_application() {
		System.out.print("User logged in : " + WebDriverUtility.isElementVisible(LoginPage.getLink_MyAccount()));
		Assert.assertTrue("My account link is not visible after login",
				WebDriverUtility.isElementVisible(LoginPage.getLink_MyAccount()));

	}

	@When("I enter invalid {string} in login credentials")
	public void i_enter_invalid_in_login_credentials(String textField) throws Exception {
		LoginPage.clickOnSignInLink();
		switch (textField.toUpperCase()) {
		case "EMAIL":
			LoginPage.setTextInEmailTextField(Constants.INVALID_USERNAME);
			LoginPage.setTextInPasswordTextField(Constants.VALID_PASSWORD);
			break;
		case "PASSWORD":
			LoginPage.setTextInEmailTextField(Constants.VALID_USERNAME);
			LoginPage.setTextInPasswordTextField(Constants.INVALID_PASSWORD);
			break;
		case "EMAIL FORMAT":
			LoginPage.setTextInEmailTextField(Constants.INVALID_EMAIL_FORMAT);
			break;
		case "PASSWORD FORMAT":
			LoginPage.setTextInPasswordTextField(Constants.INVALID_PASSWORD_FORMAT);
			break;
		default:
			throw new Exception("Invalid selection");
		}
		LoginPage.clickSignInButton();
	}

	@Then("Application should display {string} error message")
	public void application_should_display_error_message(String msg) {
		String expectedMsg;
		switch (msg.toUpperCase()) {
		case "EMAIL FORMAT":
			expectedMsg = Constants.ERR_MSG_FOR_EMAIL_FORMAT;
			Assert.assertTrue("Error message not present : " + expectedMsg,
					WebDriverUtility.isElementVisible(LoginPage.getError_belowSignIn()));
			Assert.assertTrue("Application not displaying expected error message : " + expectedMsg,
					expectedMsg.equalsIgnoreCase(WebDriverUtility.getText(LoginPage.getError_belowSignIn())));
			break;
		case "PASSWORD FORMAT":
			expectedMsg = Constants.ERR_MSG_FOR_PASSWORD_FORMAT;
			Assert.assertTrue("Error message not present : " + expectedMsg,
					WebDriverUtility.isElementVisible(LoginPage.getError_belowPassword()));
			Assert.assertTrue("Application not displaying expected error message : " + expectedMsg,
					expectedMsg.equalsIgnoreCase(WebDriverUtility.getText(LoginPage.getError_belowPassword())));
			break;
		default:
			expectedMsg = Constants.ERR_MSG_FOR_USERNAME_PASSWORD_DONOT_MATCH;
			Assert.assertTrue("Application not showing error : " + expectedMsg,
					WebDriverUtility.isElementVisible(LoginPage.getError_credentialDoNotMatch()));
			Assert.assertTrue("Application not displaying expected error message : " + expectedMsg,
					WebDriverUtility.getText(LoginPage.getError_credentialDoNotMatch()).toUpperCase()
							.contains(expectedMsg.toUpperCase()));
		}

	}

	@Then("I provide empty value in {string} textbox")
	public void i_provide_empty_value_in_textbox(String textField) throws Exception {
		switch (textField.toUpperCase()) {
		case "EMAIL":
			LoginPage.getTextfield_email().click();
			LoginPage.getTextfield_password().click();
			break;
		case "PASSWORD":
			LoginPage.getTextfield_password().click();
			LoginPage.getTextfield_email().click();
			break;
		default:
			throw new Exception("Invalid selection");
		}
	}

	@Then("Application should display {string} error message below {string} textbox")
	public void application_should_display_error_message_below_textbox(String msg, String textField) throws Exception {
		switch (textField.toUpperCase()) {
		case "EMAIL":
			Assert.assertTrue("Error message not present : " + msg, WebDriverUtility.isElementVisible(LoginPage.getError_belowSignIn()));
			Assert.assertTrue("Application not displaying expected error message : " + msg,
					msg.equalsIgnoreCase(WebDriverUtility.getText(LoginPage.getError_belowSignIn())));
			break;
		case "PASSWORD":
			Assert.assertTrue("Error message not present : " + msg,
					WebDriverUtility.isElementVisible(LoginPage.getError_belowPassword()));
			Assert.assertTrue("Application not displaying expected error message : " + msg,
					msg.equalsIgnoreCase(WebDriverUtility.getText(LoginPage.getError_belowPassword())));
			break;
		default:
			throw new Exception("Invalid selection");
		}
	}

	@Then("I close the sigin dialog")
	public void i_close_the_sigin_dialog() {
		LoginPage.clickCloseButtonOnSignIn();
	}

	@Then("I should see {string} as a header of the Login widget")
	public void i_should_see_as_a_header_of_the_login_widget(String headerName) {
		Assert.assertTrue("Header name is not as expected : "+ headerName, 
				headerName.equalsIgnoreCase(WebDriverUtility.getText(LoginPage.getHeader_SignIn())));
	}

	@And("I should see Create an account link")
	public void i_should_see_create_an_account_link() {
		Assert.assertTrue("Create an account link is not visible", WebDriverUtility.isElementVisible(LoginPage.getLink_createAnAccount()));
	}

	@And("I should select Remember me checkbox")
	public void i_should_select_remember_me_checkbox() {
		WebDriverUtility.selectCheckBox(LoginPage.getCheckbox_rememberMe());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Assert.assertTrue("Remember me checkbox not checked", LoginPage.getCheckbox_rememberMeValue().isSelected());
	}
}
