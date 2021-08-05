package AppHooks;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.util.ConfigProperties;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigProperties configReader;
	
	/*
	 * @Before(order =0)
	 *  public void getProperty() { 
	 *  String browser =configReader.get("browser");
	 *   }
	 */
	
	@Before(order =1)
	public void launchBrowser(){
		//configReader= ;
		configReader= ConfigProperties.getInstance();
		String browser =configReader.get("browser");
		driverFactory= new DriverFactory();
		driver = driverFactory.init_driver(browser);
	}
	
	@After(order =0)
	public void quitBrowser() {
		driver.quit();
		
	}
	
	@After(order =1)
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			//take screenshot
			String screenShotName = scenario.getName().replaceAll(" ", "_").concat(".png");
			String screenshot =((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
			scenario.attach(screenshot, "image/png", screenShotName);
			
			
		}
		
	}
}
