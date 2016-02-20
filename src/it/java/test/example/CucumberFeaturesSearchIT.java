package test.example;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/it/resources", strict = true, tags = { "@DemoHomeAccess,@DemoHomeSearch" }, plugin = {
		"pretty", "html:target/failsafe-reports" })
public class CucumberFeaturesSearchIT extends AbstractTestNGCucumberTests {

}
