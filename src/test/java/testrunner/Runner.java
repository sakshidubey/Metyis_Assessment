package testrunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/", glue = "stepdefs",
		plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })

public class Runner {

}
