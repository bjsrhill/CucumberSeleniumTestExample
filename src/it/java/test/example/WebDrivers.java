package test.example;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.safari.*;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * 
 * @author beverlyshill
 *
 */
public class WebDrivers implements WebDriver {
	
	private WebDriver webDriver = null;
	
	public WebDrivers(String driverType) {
		if(driverType.equals("FirefoxDriver")) {
			this.webDriver = new EventFiringWebDriver(new FirefoxDriver());
			webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		} 
	}
	
	public WebDrivers() {
		this.webDriver = new FirefoxDriver();
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Override
	public void close() {
		if(!(webDriver == null)) {
			webDriver.close();
		}
	}

	@Override
	public WebElement findElement(By arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WebElement> findElements(By arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void get(String url) {
		webDriver.get(url);
		
	}

	@Override
	public String getCurrentUrl() {
		return webDriver.getCurrentUrl();
	}

	@Override
	public String getPageSource() {
		return webDriver.getPageSource();
	}

	@Override
	public String getTitle() {
		return webDriver.getTitle();
	}

	@Override
	public String getWindowHandle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getWindowHandles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Options manage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Navigation navigate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void quit() {
		webDriver.quit();
		
	}

	@Override
	public TargetLocator switchTo() {
		// TODO Auto-generated method stub
		return null;
	}
}
