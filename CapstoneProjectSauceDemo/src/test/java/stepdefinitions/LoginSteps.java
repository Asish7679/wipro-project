package stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertTrue;
import io.cucumber.java.en.*;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.DriverFactory;

public class LoginSteps {

	LoginPage login = new LoginPage();
	String validUsername = ConfigReader.get("username");
	String validPassword = ConfigReader.get("password");
	String invalidUsername = ConfigReader.get("invalidUser");
	String invalidPassword = ConfigReader.get("invalidPass");
	String url = ConfigReader.get("url");

	@Given("User is on Login Page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().get(url);
	}

	@When("User enters valid username")
	public void user_enters_valid_username() {
		login.enterUsername(validUsername);
	}

	@When("User enters valid password")
	public void user_enters_valid_password() {
		login.enterPassword(validPassword);
	}

	@When("User enters invalid username")
	public void user_enters_invalid_username() {
		login.enterUsername(invalidUsername);
	}

	@When("User enters invalid password")
	public void user_enters_invalid_password() {
		login.enterPassword(invalidPassword);
	}

	@When("User leaves username blank")
	public void user_leaves_username_blank() {
		login.enterUsername("");
	}

	@When("User leaves password blank")
	public void user_leaves_password_blank() {
		login.enterPassword("");
	}

	@When("User clicks on Login button")
	public void clicks_on_login_button() {
		login.clickLoginButton();
	}

	@Then("User should be navigated to the homepage")
	public void user_should_be_navigated_to_the_homepage() {
		assertTrue(login.isHomePageDisplayed(), "Home page is not displayed");
	}

	@Then("Login error message should be displayed")
	public void login_error_message_should_be_displayed() {
		assertTrue(login.isErrorMessageDisplayed(), "Error message not displayed");
	}

	@Then("Mandatory login field error messages should appear")
	public void mandatory_login_field_error_messages_should_appear() {
		assertTrue(login.isErrorMessageDisplayed(), "Username error not displayed");
		assertTrue(login.isErrorMessageDisplayed(), "Password error not displayed");
	}

	@Given("User is logged in")
	public void user_is_logged_in() {
		DriverFactory.getDriver().get(url);
		login.enterUsername(validUsername);
		login.enterPassword(validPassword);
		login.clickLoginButton();
	}

	@When("User clicks on Logout")
	public void user_clicks_on_logout() {
		login.clickLogout();
	}

	@Then("User should be redirected to Login Page")
	public void user_should_be_redirected_to_login_page() {
		assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("saucedemo.com"), "Not redirected to login page");
	}
}
