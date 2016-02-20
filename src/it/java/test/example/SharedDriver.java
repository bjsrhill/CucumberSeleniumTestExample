package test.example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import cucumber.api.java.Before;

/**
 * A new instance of SharedDriver is created for each Scenario and passed to
 * StepDef classes via Dependency Injection (adapted from 
 * a Cucumber JVM sample class)
 * 
 */
public class SharedDriver extends EventFiringWebDriver {

	private static final WebDriver REAL_DRIVER;
	private static final Thread CLOSE_THREAD = new Thread() {
		@Override
		public void run() {
			REAL_DRIVER.close();
		}
	};

	static {
		REAL_DRIVER = new FirefoxDriver();
		REAL_DRIVER.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
	}
	
	public SharedDriver() {

		super(REAL_DRIVER);
	}

	@Override
	public void close() {
		if (Thread.currentThread() != CLOSE_THREAD) {
			throw new UnsupportedOperationException(
					"This driver is shared and will close when the JVM exits.");
		}
		super.close();
	}
	
	@Before
    public void deleteAllCookies() {
        manage().deleteAllCookies();
    }
}
