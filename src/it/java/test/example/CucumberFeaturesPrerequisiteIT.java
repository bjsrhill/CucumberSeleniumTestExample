package test.example;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/it/resources", strict = true, tags = { "@DemoPrerequisites" }, plugin = { "pretty",
		"html:target/failsafe-reports" })
public class CucumberFeaturesPrerequisiteIT extends AbstractTestNGCucumberTests {

}
