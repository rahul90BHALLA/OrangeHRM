package com.qa.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	public WebDriver driver;

	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	public WebDriver init_driver(String browser) {
		System.out.println("browser value is: "+ browser);
		
		if(browser.equals("chrome")) {
			tlDriver.set(new ChromeDriver());
		}
		else if(browser.equals("firefox")) {
			tlDriver.set(new FirefoxDriver());
		}
		else if(browser.equals("Edge")) {
			tlDriver.set(new EdgeDriver());
		}
		else {
			System.out.println("Please pass the Correct Value of the Browser : "+ browser);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

}
