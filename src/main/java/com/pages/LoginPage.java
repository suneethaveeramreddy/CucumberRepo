package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	
	//1. By locators 
	
	private By Username = By.name("username");
	private By Password = By.name("password");
	private By LoginBtn = By.xpath("//input[@type='submit']");
	private By forgotPwdLink = By.linkText("Forgot Password?");
	
	//2. Constructor of the page class:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//3. page actions: features(behaviour) of the page the form of methods 
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isForgotPwdLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}
	public void enterUserName(String uname) {
		driver.findElement(Username).sendKeys(uname);
	}
	public void enterPassword(String pwd) {
		driver.findElement(Password).sendKeys(pwd);
	}
	public void clickOnLogin() {
		driver.findElement(LoginBtn).click();
	}
	public HomePage doLogin(String un,String pwd) {
		driver.findElement(Username).sendKeys(un);
		driver.findElement(Password).sendKeys(pwd);
		driver.findElement(LoginBtn).click();
		return new HomePage(driver);
	}
}
