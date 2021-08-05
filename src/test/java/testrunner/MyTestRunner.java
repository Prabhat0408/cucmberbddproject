package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"C:\\QA\\RestAssured\\RestAPI\\CucmberBDDProjectFrameork\\src\\test\\resource\\com\\features"},
		glue= {"stepdefinitions","AppHooks"},
		/*
		 * tags= "@Smoke and @Regression", tags= "@Smoke and @Regression",
		 */
		//tags= "@ALL",
		plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"json:target json/cucumber-reports/Cucumber.json",
				"html:target html/cucumber-reports","timeline:test-output-thread"},
		monochrome = true
		
		)
public class MyTestRunner {

}
