package test.example.stepdefs;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.Assertion;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import test.example.WebDriverFactory;
import test.example.pageobjects.DemoPageObjects;


public class DemoPrerequisiteStepDefs {
	
	private static WebDriver webDriver = WebDriverFactory.getBrowser("Firefox");
	private DemoPageObjects homePageObjects = new DemoPageObjects(webDriver);
	private Assertion hardAssert = new Assertion();
	
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
}
