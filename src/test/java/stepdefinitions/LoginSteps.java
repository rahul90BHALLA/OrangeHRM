package stepdefinitions;

import org.testng.Assert;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps  {

	DriverFactory driverFactory;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	@Given("I am on the OnTrack App Login Page")
	public void i_am_on_the_on_track_app_login_page() {
		DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    
	}

	@Given("I have entered a valid {string} and {string}")
	public void i_have_entered_a_valid_and(String username, String password) {
	    loginPage.enterEmail(username);
	    loginPage.enterPassword(password);
	} 

	@When("I click on Login button")
	public void i_click_on_login_button() {
	   loginPage.clickLoginbtn();
	}

	@Then("title shhould be {string}")
	public void title_shhould_be(String actTitle) {
		String expTitle =loginPage.loginPageTitle();
		Assert.assertEquals(expTitle, actTitle);
	    
	}

}