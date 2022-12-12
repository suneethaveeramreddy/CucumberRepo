package stepdefinitions;

import org.junit.Assert;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.*;

public class LoginPageSteps {
	
	private static String title;	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().get("https://classic.freecrm.com/index.html");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = loginPage.getLoginPageTitle();
		System.out.println(" The Login Page title is: " + title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String ExpectedTitleName) throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertTrue(title.contains(ExpectedTitleName));
	}

	@Then("forgot password link should be displayed")
	public void forgot_password_link_should_be_displayed() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());   
	}

	@When("user enters username {string}")
	public void user_enters_username(String uname) {
		loginPage.enterUserName(uname);
	}

	@When("user enters password {string}")
	public void user_enters_password(String pwd) {
		loginPage.enterPassword(pwd);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		loginPage.clickOnLogin();
	}

}
