package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.RegistrationPage;
import utils.ConfigReader;
import utils.DriverFactory;

import java.time.Duration;

public class RegistrationSteps {
    WebDriver driver;
    RegistrationPage registrationPage;
    WebDriverWait wait;

    @Given("user is on registration page")
    public void user_is_on_registration_page() {
        driver = DriverFactory.getDriver();
        registrationPage = new RegistrationPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        registrationPage.open();
    }

    @When("user enters registration details")
    public void user_enters_registration_details() {
        registrationPage.register(
                ConfigReader.get("firstname"),
                ConfigReader.get("lastname"),
                ConfigReader.get("country"),
                ConfigReader.get("phone"),
                ConfigReader.get("email"),
                ConfigReader.get("password")
        );
    }

    @When("user tries to register with missing fields")
    public void user_tries_to_register_with_missing_fields() {
        registrationPage.register(
                "",
                ConfigReader.get("lastname"),
                ConfigReader.get("country"),
                "",
                "",
                ConfigReader.get("password")
        );
    }

    @When("user enters invalid email {string}")
    public void user_enters_invalid_email(String email) {
        registrationPage.register(
                ConfigReader.get("firstname"),
                ConfigReader.get("lastname"),
                ConfigReader.get("country"),
                ConfigReader.get("phone"),
                email,
                ConfigReader.get("password")
        );
    }

    @When("user enters weak password {string}")
    public void user_enters_weak_password(String password) {
        registrationPage.register(
                ConfigReader.get("firstname"),
                ConfigReader.get("lastname"),
                ConfigReader.get("country"),
                ConfigReader.get("phone"),
                ConfigReader.get("email"),
                password
        );
    }

    @When("user enters phone number {string}")
    public void user_enters_phone_number(String phone) {
        registrationPage.register(
                ConfigReader.get("firstname"),
                ConfigReader.get("lastname"),
                ConfigReader.get("country"),
                phone,
                ConfigReader.get("email"),
                ConfigReader.get("password")
        );
    }

    @Then("account should be created successfully")
    public void account_should_be_created_successfully() {
        try {
            Thread.sleep(3000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        wait.until(ExpectedConditions.urlContains("success"));
        assert driver.getCurrentUrl().contains("success");
    }


    @Then("system should show error message {string} for {string}")
    public void system_should_show_error_message(String expectedMessage, String fieldName) {
        String actual = registrationPage.getValidationMessage(fieldName);
        assert actual.contains(expectedMessage)
                : " Expected: " + expectedMessage + " but got: " + actual;
    }
    @Then("account should NOT be created successfully")
    public void account_should_not_be_created_successfully() {
        try {
            Thread.sleep(3000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean success = driver.getCurrentUrl().contains("success");
        if (success) {
            System.err.println("Expected Failure: Account created due to missing validation in AUT");
            org.testng.Assert.fail("Expected Failure: Validation missing in AUT");
        }
    }

}
