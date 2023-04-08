package stepdefs;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import pageobjects.BasePage;

public class Hooks {

	BasePage basePage;
	
	public Hooks(BasePage basePage) {
		this.basePage = basePage;
	}
	
	@Before
	public void initializeDriver(Scenario scenario) {	
		basePage.initDriver();
	}
	@AfterStep
    public void captureScreenshot(Scenario scenario)
    {
        final byte[] screenshot = ((TakesScreenshot) basePage.getDriver()).getScreenshotAs(OutputType.BYTES);     
        scenario.attach(screenshot, "image/png", scenario.getName()); 
    }

	@After
    public void tearDown(Scenario scenario) throws Exception {    
		basePage.getDriver().quit();
    }
	
}
