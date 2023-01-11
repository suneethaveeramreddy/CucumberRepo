package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateCompanyPage {
private WebDriver driver;

	//1. By locators 

	private By Company	 		= By.xpath("//input[@name='company_name']");
	private By Industry	 		= By.xpath("//input[@name='industry']");
	private By Revenue			= By.xpath("//input[@name='annual_revenue']");
	private By Emp				= By.xpath("//input[@name='num_of_employees']");
	private By Status			= By.xpath("//select[@name='status']");
	private By Prity			= By.xpath("//select[@name='priority']");
	private By Phone			= By.xpath("//input[@name='phone']");
	private By Email			= By.xpath("//input[@name='email']");
	private By SaveBtn			= By.xpath("//input[@type='submit']");
	private By Companies		= By.xpath("//a[@title='Companies']");
	private By NewCompany		= By.xpath("//a[@title='New Company']");
	
	
	
	//2. Constructor of the page class:
		public CreateCompanyPage(WebDriver driver) {
			this.driver = driver;
	}
	
	public void NewCompanyPage() {
		driver.switchTo().frame("mainpanel");
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(Companies)).build().perform();
		driver.findElement(NewCompany).click();
	}
		
	public void fillCreateCompany(String CompanyID,String IndustryID,String	AnnualRevenue,
			String Employees,String StatusID,String Priority,String PhoneNumber,String EmailID) {
			driver.findElement(Company).sendKeys(CompanyID);
			driver.findElement(Industry).sendKeys(IndustryID);
			driver.findElement(Revenue).sendKeys(AnnualRevenue);
			driver.findElement(Emp).sendKeys(Employees);
			Select select = new Select(driver.findElement(Status));
			select.selectByVisibleText(StatusID);
			Select select1 = new Select(driver.findElement(Prity));
			select1.selectByVisibleText(Priority);
			driver.findElement(Phone).sendKeys(PhoneNumber);
			driver.findElement(Email).sendKeys(EmailID);
	}
	
	public void ClickSave() {
		driver.findElement(SaveBtn).click();
	}
	
}
