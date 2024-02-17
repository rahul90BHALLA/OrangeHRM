package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage {
	WebDriver driver;	
	
	private By emailfield = By.xpath("//input[@placeholder='Username']");
	private By passwordfield = By.xpath("//input[@placeholder='Password']");
	private By logInBtn = By.xpath("//button[contains(.,'Login')]");
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	
	public String getTitle() {
	 String str = driver.getTitle();
	 return str;
	}
	
	public void enterEmail(String username) {
		WebElement email = driver.findElement(emailfield);
		email.sendKeys(username);
		
		
	}
	
	public void enterPassword(String password) {
		WebElement passwordBox = driver.findElement(passwordfield);
		passwordBox.sendKeys(password);
		
		
	}
	
	public void clickLoginbtn() {
		driver.findElement(logInBtn).click();
	}
	
	
	
	
	public String loginPageTitle()
	{
		String title = driver.getTitle();
		return title;
	}
	
	
	
	
}