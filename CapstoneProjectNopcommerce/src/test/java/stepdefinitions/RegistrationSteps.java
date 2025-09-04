package stepdefinitions;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RegistrationPage;
import utilities.ConfigReader;
import utilities.DriverFactory;

public class RegistrationSteps {

	RegistrationPage page = new RegistrationPage();
	String url = ConfigReader.get("URL");

	@Given("I am on the registration page")
	public void i_am_on_the_registration_page() {

		DriverFactory.getDriver().get(url);
		page.goToRegisterPage();
	}

	@When("I enter a unique email, strong password and matching confirm password")
	public void i_enter_valid_registration_details() {
		page.selectGender();
		page.enterFirstname("Anurag");
		page.enterLastname("Das");
		page.enterEmail("anurag" + System.currentTimeMillis() + "@gmail.com");
		page.enterPassword("Anurag@0102");
		page.enterConfirmPassword("Anurag@0102");
	}

	@When("I enter an existing email, strong password and matching confirm password")
	public void i_enter_existing_email_details() {
//		page.clickLogout();
		page.goToRegisterPage();
		page.selectGender();
		page.enterFirstname("Anurag");
		page.enterLastname("Ds");
		page.enterEmail("existinguser@mail.com");
		page.enterPassword("Pass1234");
		page.enterConfirmPassword("Pass1234");
	}

	@When("I enter an invalid email format")
	public void i_enter_invalid_email() {
		page.goToRegisterPage();
		page.selectGender();
		page.enterFirstname("Anurag");
		page.enterLastname("Das");
		page.enterEmail("anurag");
		page.enterPassword("Pass1234");
		page.enterConfirmPassword("Pass1234");
	}

	@When("I enter a unique email and weak password")
	public void i_enter_weak_password() {
		page.goToRegisterPage();
		page.selectGender();
		page.enterFirstname("Anurag");
		page.enterLastname("Das");
		page.enterEmail("Anurag" + System.currentTimeMillis() + "@gmail.com");
		page.enterPassword("123");
		page.enterConfirmPassword("12");
	}

	@When("I enter a unique email, strong password and mismatched confirm password")
	public void i_enter_mismatched_passwords() {
		page.goToRegisterPage();
		page.selectGender();
		page.enterFirstname("Anurag");
		page.enterLastname("Das");
		page.enterEmail("john" + System.currentTimeMillis() + "@gmail.com");
		page.enterPassword("Pass1234");
		page.enterConfirmPassword("Pass12345");
	}

	@And("I submit the registration form")
	public void i_submit_the_registration_form() {
		page.clickRegister();
	}

	@Then("I should see a success message {string}")
	public void i_should_see_success_message(String message) {
		Assert.assertTrue(page.getSuccessMessage().contains(message));

	}

	@Then("I should see an error message {string}")
	public void i_should_see_error_message(String message) {
		Assert.assertTrue(page.getErrorMessage().contains(message));

	}

	@Then("I should see an error message for invalid email {string}")
	public void i_should_see_invalid_email_error(String expectedMessage) {
		Assert.assertTrue(page.getEmailError().contains("Please enter a valid email address."));

	}

	@Then("I should see a password policy error message")
	public void i_should_see_password_policy_error() {
		Assert.assertTrue(page.getPasswordError().contains("must have at least 6 characters"));

	}

	@Then("I should see an mismatched password error message {string}")
	public void i_should_see_mismatched_error_message(String message) {
		Assert.assertTrue(page.getMismatchedErrorMessage().contains(message));

	}
}
