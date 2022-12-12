package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
private WebDriver driver;
	
	//1. By locators 
	
	private By HomePageLabels = By.xpath("//a[starts-with(@style,'background')]");
	private By LoggedInUname = By.xpath("//td[contains(text(),'User: Suneetha Veeramreddy ')]");
	
	
	//2. Constructor of the page class:
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	//3. page actions: features(behaviour) of the page the form of methods 
	
	
	public int getHomePageLabelsCount() {
		return driver.findElements(HomePageLabels).size();
	}
	
	public String getLoggedInUsername() {
		driver.switchTo().frame("mainpanel");
		return driver.findElement(LoggedInUname).getText();
	}
	
	public List<String> getHomeLabelsList() {
		List<String> LabelList= new ArrayList<>();
		driver.switchTo().frame("mainpanel");
		List<WebElement> HeadersList = driver.findElements(HomePageLabels);
		for(WebElement e:HeadersList) {
			String LabelText=e.getText();
			System.out.println("The list is " +LabelText);
			LabelList.add(LabelText);
		}
		return LabelList;
	}
}
