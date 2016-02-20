package test.example;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.testng.asserts.Assertion;
import test.example.pageobjects.HomePageObjects;


public class DemoSitePrerequisiteStepDefs {
	
	private HomePageObjects homePageObjects = null;
	private WebDriver webDriver;
	private Assertion hardAssert = new Assertion();
	
	public DemoSitePrerequisiteStepDefs(SharedDriver webDriver) {
		this.webDriver = webDriver;
		homePageObjects = new HomePageObjects(webDriver);
	}
	
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
