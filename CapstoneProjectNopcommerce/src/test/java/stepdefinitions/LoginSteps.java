package stepdefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.DriverFactory;

public class LoginSteps {

	LoginPage login = new LoginPage();
	String validUsername = ConfigReader.get("validUser");
	String validPassword = ConfigReader.get("validPassword");

	String url = ConfigReader.get("URL");

	@Given("I am on the login page")
	public void i_am_on_the_login_page() {
		DriverFactory.getDriver().get(url);
		login.navigateLoginPage();

	}

	@When("I enter valid email and password")
	public void i_enter_valid_email_and_password() {
		login.enterEmail(validUsername);
		login.enterPassword(validPassword);
	}

	@When("I enter correct email and wrong password")
	public void i_enter_correct_email_and_wrong_password() {
		login.enterEmail("valid_email@example.com");
		login.enterPassword("WrongPassword");
	}

	@When("I enter unregistered email and any password")
	public void i_enter_unregistered_email_and_any_password() {
		login.enterEmail("unregistered@example.com");
		login.enterPassword("AnyPassword123");
	}

	@When("I click on the login button")
	public void i_click_on_the_login_button() {
		login.clickLogin();
	}

	@Then("I should be logged in successfully")
	public void i_should_be_logged_in_successfully() {
		Assert.assertTrue(login.isLogoutDisplayed(), "Logout link should be visible");
	}

	@Then("I should see an error message login {string}")
	public void i_should_see_an_error_message_login(String expectedMessage) {
		Assert.assertTrue(login.getErrorMessage().contains(expectedMessage), "Error message should match expected");
	}

	@Given("I am logged in")
	public void i_am_logged_in() {
		i_am_on_the_login_page();
		i_enter_valid_email_and_password();
		i_click_on_the_login_button();
		Assert.assertTrue(login.isLogoutDisplayed(), "User should be logged in");
	}

	@When("I click on the logout button")
	public void i_click_on_the_logout_button() {
		login.clickLogout();
	}

	@Then("I should be redirected to the homepage")
	public void i_should_be_redirected_to_the_homepage() {
		String currentUrl = DriverFactory.getDriver().getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("nopcommerce.com"), "Should be on homepage");
	}

	@Then("I should see login and register links")
	public void i_should_see_login_and_register_links() {
		Assert.assertTrue(login.isLoginAndRegisterVisible(), "Login and Register links should be visible");
	}
}
