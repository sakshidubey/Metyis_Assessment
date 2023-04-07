package stepdefs;

import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import pageobjects.BasePage;


public class Hooks {

	BasePage basePage;
	WebDriver driver;
	
	public Hooks(BasePage basePage) {
		this.basePage = basePage;
//		driver = basePage.getDriver();
	}
	
	@Before
	public void before(Scenario scenario) {	
		basePage.initDriver();
//		System.out.println("Scenario name : "+ scenario.getName());
//		CapturingScreenshot.setCurrentScenario(scenario);
	}
	@AfterStep
    public void afterStep(Scenario scenario)
    {
//		byte[] screenshot = ((Object) driver).getScreenshotAs(OutputType.BYTES);
        final byte[] screenshot = ((TakesScreenshot) basePage.getDriver()).getScreenshotAs(OutputType.BYTES);
        
        scenario.attach(screenshot, "image/png", scenario.getName()); 
    }

	@After
    public void after(Scenario scenario) throws Exception {    
//		if(basePage.getDriver()!=null) {
//			basePage.getDriver().close();
//			basePage.getDriver().quit();
//        }   
		basePage.getDriver().quit();
    }
	
}
