package test.example.pageobjects;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import test.example.SharedDriver;

/**
 * Manages the shared WebDriver
 * 
 * @author beverlyshill
 *
 */
public class HomePageObjects {
	
	private WebDriver webDriver = null;

	public HomePageObjects(SharedDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	/**
	 * Reads a property file to obtain a URL
	 * @return a property object representing the URl to test
	 */
    public Object getURL() {
		Properties p =
                new Properties(System.getProperties());
        return p.getProperty("baseUrl"); 
	}
    
    public Object getSiteTitle() {
    	Properties p =
                new Properties(System.getProperties());
        return p.getProperty("siteTitle");
    }
	
    /**
     * Loads URL into browser
     */
	public void loadUrl() {
		System.out.println("The url is: " + getURL());
		webDriver.get((String) getURL());
	}
	
	public WebDriver getWebDriver() {
		return webDriver;
	}
	
	/**
	 * Gets web page title from the WebDriver
	 * 
	 * @return a String representing a web page title
	 */
	public String getTitle() {
		return webDriver.getTitle();
	}
	
	public void performProductSearch(String input) {
		webDriver.findElement( By.xpath("/html/body/div[2]/div/div/header/nav/form/fieldset/input[1]")).sendKeys(input);
		webDriver.findElement( By.xpath("/html/body/div[2]/div/div/header/nav/form/fieldset/input[1]")).submit();
		
	}
	
	public boolean checkSearchResults() {
		return webDriver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[1]/div/div/div/div[1]/a")).isDisplayed();
	}
	
	/**
	 * 
	 */
	public void fatalExit() {
		System.out.println("The site title is not correct. URL not loaded. EXITING!!!");
		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		s += "/src/it/java/test/example/error.html";
		webDriver.navigate().to("file://" + s);
		webDriver.quit();
		System.exit(0);
	}

}
