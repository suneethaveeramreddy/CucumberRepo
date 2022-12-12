package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class HomePageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private HomePage homePage;
	
	@Given("user has already logged into the application")
	public void user_has_already_logged_into_the_application(DataTable CredTable) {
		List<Map<String, String>> credList = CredTable.asMaps();
		String userName = credList.get(0).get("username");
		String password = credList.get(0).get("password");
		DriverFactory.getDriver().get("https://classic.freecrm.com/index.html");
		homePage = loginPage.doLogin(userName, password);
	}

	@Then("loggedin username should be {string}")
	public void loggedin_username_should_be(String ExpectedTitle) {
		String ActualTitle=homePage.getLoggedInUsername();
		System.out.println("The loggedIn username is: " +ActualTitle);
		Assert.assertTrue(ActualTitle.contains(ExpectedTitle));
		
	}

	@Then("user gets home page labels section")
	public void user_gets_home_page_labels_section(DataTable LabelsTable) {
		List<String> ExpLabelList = LabelsTable.asList();
		System.out.println("Expected Home page Label List: " +ExpLabelList);
		List<String> ActualLabelList = homePage.getHomeLabelsList();
		System.out.println("Actual Home Page Label List: " +ActualLabelList);
	    Assert.assertTrue(ActualLabelList.containsAll(ActualLabelList));
	}

	@Then("home page labels section count should be {int}")
	public void home_page_labels_section_count_should_be(Integer ExpectedLabelCount) {
		int count=homePage.getHomePageLabelsCount();
		System.out.println("The Home Page labels count is: " +count);
	   Assert.assertTrue(homePage.getHomePageLabelsCount()==ExpectedLabelCount);
	}

}
