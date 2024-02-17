package AppHooks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class ApplicationHooks {
	
	private DriverFactory driverFactory;
	private WebDriver driver;
	private Properties prop;
	
	public Properties init_prop() {
		
		prop = new Properties();
		
	try {
		FileInputStream ip = new FileInputStream("C:\\Users\\admin\\Downloads\\OnTrack_BDD\\src\\test\\resources\\config\\config.properties");
		prop.load(ip);
	}
	catch(FileNotFoundException e) {
		e.printStackTrace();
	}
	catch(IOException e) {
		e.printStackTrace();
	}
	
	return prop; 
	}

	
	
	@Before(order = 0)
	public void getPRoperty() {
	prop = init_prop();
			
	}
//	@Parameters("BrowserType")
	@Before(order = 1)
	public void launchBrowser() {
	String browserName = prop.getProperty("browser");
	driverFactory = new DriverFactory();
	driver = driverFactory.init_driver(browserName);
			
	}
//	
	@After(order = 0)
	public void quitBrowser() {
	  driver.quit();
	}
//   
	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			//takeScreenshot:
			String screenshotName = scenario.getName().replaceAll(" ","_");
			byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
		
	}
	
}