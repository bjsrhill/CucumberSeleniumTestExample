package test.example.stepdefs;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import test.example.WebDriverFactory;
import test.example.pageobjects.HomePageObjects;


public class DemoSitePrerequisiteStepDefs {
	
	private static WebDriver webDriver = WebDriverFactory.getBrowser("Firefox");
	private HomePageObjects homePageObjects = new HomePageObjects(webDriver);
	private Assertion hardAssert = new Assertion();
	
//	public DemoSitePrerequisiteStepDefs(SharedDriver webDriver) {
//		this.webDriver = webDriver;
//		homePageObjects = new HomePageObjects(webDriver);
//	}
	
	@Given("^that the Demo site has been accessed$")
	public void that_the_Demo_site_has_been_accessed() throws Throwable {
    	homePageObjects.loadUrl();
    	if(! homePageObjects.getTitle().equals(homePageObjects.getSiteTitle())) {
    		homePageObjects.fatalExit();
		}
	}

	@Then("^Verify the demo title$")
	public void verify_the_demo_title() throws Throwable {
		if(! homePageObjects.getTitle().equals(homePageObjects.getSiteTitle())) {
			homePageObjects.fatalExit();
		}
	}
	
//	@AfterSuite
//	public void tearDown()
//	{
//		WebDriverFactory.closeDrivers();
//	}
	
}
