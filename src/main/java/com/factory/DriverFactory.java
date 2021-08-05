package com.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Synchronized;

public class DriverFactory {
	public static ThreadLocal<WebDriver> tiDriver = new ThreadLocal<>();
	
	
	/**
	 * This method is used to initialize the thradlocal driver on the basis of given
	 * browser
	 * 
	 * @param browser
	 * @return this will return tldriver.
	 */

	public WebDriver init_driver(String browser) {
		System.out.println(browser);
		
		if (browser.equalsIgnoreCase("CHROME")) {
			WebDriverManager.chromedriver().setup();
			tiDriver.set(new ChromeDriver());
		} else if (browser.equalsIgnoreCase("CHROME")) {
			WebDriverManager.firefoxdriver().setup();
			tiDriver.set(new FirefoxDriver());

		} else {
			System.out.println("please pass the correct browser driver value " + browser);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {
		return tiDriver.get();
	}
}
