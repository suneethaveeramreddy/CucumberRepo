package stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.pages.CreateCompanyPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ExcelReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateCompanyPageSteps {
	
	private CreateCompanyPage createCompanyPage = new CreateCompanyPage(DriverFactory.getDriver());
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private HomePage homePage;
	
	@Given("User is on New Company page")
	public void user_is_on_home_page() {
		createCompanyPage.NewCompanyPage();
	}
	
	@When("User fills the  details from the given sheetname {string} and rownumber {int}")
	public void user_fills_the_details_from_the_given_sheetname_and_rownumber(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
		ExcelReader reader=new ExcelReader();
		List<Map<String,String>> testData= reader.getData("C:\\Users\\sunee\\eclipse-workspace\\CucumberPOMSeries\\src\\main"
				+ "\\java\\com\\qa\\testdata\\BDDFeatureWithExcelData.xlsx", sheetName);
		
		String Company =testData.get(rowNumber).get("CompanyId");
		String Industry =testData.get(rowNumber).get("IndustryID");
		String Revenue =testData.get(rowNumber).get("Annual Revenue");
		String Emp =testData.get(rowNumber).get("Employees");
		String Stat =testData.get(rowNumber).get("Status");
		String Priority =testData.get(rowNumber).get("Priority");
		String PhoneNum =testData.get(rowNumber).get("PhoneNumber");
		String Email =testData.get(rowNumber).get("EmailID");
		createCompanyPage.fillCreateCompany(Company, Industry, Revenue, Emp, Stat, Priority, PhoneNum, Email);
		
	}

	@When("Clicks on save button")
	public void clicks_on_save_button() {
		createCompanyPage.ClickSave();
	   
	}

	@Then("the company should be added")
	public void the_company_should_be_added() {
	   
	}

}
