package test.example;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.Then;
import test.example.pageobjects.HomePageObjects;

public class HomeSearchStepDefs {
	
	private HomePageObjects homePageObjects = null;
	private WebDriver webDriver;
	
	public HomeSearchStepDefs(SharedDriver webDriver) {
		this.webDriver = webDriver;
		homePageObjects = new HomePageObjects(webDriver);
	}

	@Then("^Verify that there is a search field that will produce a search for the word \"([^\"]*)\"$")
	public void verify_that_there_is_a_search_field_that_will_produce_a_search_for_the_word(String searchWord) throws Throwable {
		homePageObjects.performProductSearch(searchWord);
		Assert.assertTrue(homePageObjects.checkSearchResults());
	 
	}
}
