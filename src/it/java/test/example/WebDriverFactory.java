package test.example;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import test.example.pageobjects.HomePageObjects;

public class WebDriverFactory {
	
	private static Map<String, WebDriver> webDrivers = new HashMap<String, WebDriver>();
	private static HomePageObjects homePageObjects = new HomePageObjects();
	 
	/*
	 * Factory method for getting browsers
	 */
	public static WebDriver getBrowser(String browserName) {
		WebDriver driver = null;
		String ieSetting = homePageObjects.getIESetting().toString();
		String chromeSetting = homePageObjects.getChromeSetting().toString();
 
		switch (browserName) {
		case "Firefox":
			driver = webDrivers.get("Firefox");
			if (driver == null) {
				driver = new FirefoxDriver();
				webDrivers.put("Firefox", driver);
			}
			break;
		case "IE":
			driver = webDrivers.get("IE");
			if (driver == null) {
				System.setProperty("webdriver.ie.driver",ieSetting);
				driver = new InternetExplorerDriver();
				webDrivers.put("IE", driver);
			}
			break;
		case "Chrome":
			driver = webDrivers.get("Chrome");
			if (driver == null) {
				System.setProperty("webdriver.chrome.driver",chromeSetting);
				driver = new ChromeDriver();
				webDrivers.put("Chrome", driver);
			}
			break;
		}
		return driver;
	}
	
	public static void closeDrivers() {
		for (String key : webDrivers.keySet()) {
			System.out.println("The driver key is: " + key);
			webDrivers.get(key).close();
			webDrivers.get(key).quit();
		}
	}

}
