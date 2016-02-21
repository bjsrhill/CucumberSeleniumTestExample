package test.example.stepdefs;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import test.example.WebDriverFactory;
import test.example.pageobjects.HomePageObjects;

public class HomeStepDefs {
	
	private Assertion hardAssert = new Assertion();
	private WebDriver webDriver = WebDriverFactory.getBrowser("Firefox");
	private HomePageObjects homePageObjects = new HomePageObjects(webDriver);
	
//	public HomeStepDefs(SharedDriver webDriver) {
//		this.webDriver = webDriver;
//		homePageObjects = new HomePageObjects(webDriver);
//	}
	
//	@Given("^that a user has accessed the Demo Site Home page using a specific browser$")
//	public void that_a_user_has_accessed_the_Demo_Site_Home_page_using_a_specific_browser(DataTable browser) throws Throwable {
//		java.util.List<String> browsers = new ArrayList<String>();
//        browsers = browser.asList(String.class);
//        Iterator iterator = browsers.iterator();
//        while (iterator.hasNext()) {
//        	String element = iterator.next().toString();
//        	homePageObjects = new HomePageObjects(element);
//        	homePageObjects.loadUrl();
//        }
//	}

	@Then("^Verify the web page title$")
	public void verify_the_web_page_title() throws Throwable {
		if(! homePageObjects.getTitle().equals("ONLINE STORE | Toolsqa Dummy Test site")) {
			hardAssert.fail("Page title not found. URL can't be loaded.");
		}
	}
	
	@AfterSuite
	public void tearDown()
	{
		System.out.println("Got to after suite");
		WebDriverFactory.closeDrivers();
	}
}
