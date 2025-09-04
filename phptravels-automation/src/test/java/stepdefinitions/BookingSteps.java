package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BookingPage;
import utils.DriverFactory;

public class BookingSteps {
    WebDriver driver;
    BookingPage bookingPage;

    @Given("user is on flight results page")
    public void user_is_on_flight_results_page() {
        driver = DriverFactory.getDriver();
        bookingPage = new BookingPage(driver);
        bookingPage.openResultsPage();
    }

    @Given("user selects the first available flight")
    public void user_selects_the_first_available_flight() {
        bookingPage.selectFirstFlight();
    }

    // ✅ Positive case
    @When("user enters passenger details")
    public void user_enters_passenger_details() {
        bookingPage.fillPassengerDetails(
                "Asish", "Kumar",
                "asish.auto@test.com",
                "9876543210",
                "New Delhi, India"
        );
        bookingPage.fillTravellerDetails();
    }

    // ✅ Negative case - blank mandatory fields
    @When("user leaves mandatory booking fields blank")
    public void user_leaves_mandatory_booking_fields_blank() {
        bookingPage.fillPassengerDetails("", "", "", "", "");
        bookingPage.fillTravellerDetailsCustom("", "", "", "", "");
    }

    // ✅ Negative case - invalid passport
    @When("user enters invalid passport number {string}")
    public void user_enters_invalid_passport_number(String passport) {
        bookingPage.fillPassengerDetails(
                "Asish", "Kumar",
                "asish.auto@test.com",
                "9876543210",
                "New Delhi, India"
        );
        bookingPage.fillTravellerDetailsCustom("Asish", "Kumar", passport, "asish.auto@test.com", "9876543210");
    }

    @When("user chooses PayPal as payment method")
    public void user_chooses_paypal_as_payment_method() {
        bookingPage.choosePaypalAndConfirm();
    }

    // ✅ Positive validation
    @Then("booking invoice page should be displayed")
    public void invoice_page_should_be_displayed() {
        String currentUrl = driver.getCurrentUrl();
        if (!currentUrl.contains("invoice")) {
            throw new AssertionError("❌ Invoice page not reached! Current URL: " + currentUrl);
        }
        System.out.println("✅ Invoice page displayed: " + currentUrl);
    }

    // ✅ Negative validation (URL should NOT contain invoice)
    @Then("booking should NOT be created")
    public void booking_should_not_be_created() {
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("invoice")) {
            throw new AssertionError("❌ Booking was created unexpectedly! URL: " + currentUrl);
        }
        System.out.println("✅ Booking not created (invalid data blocked). Current URL: " + currentUrl);
    }

    // ✅ Common negative step - check error messages
    @Then("system should show booking error message {string} for {string}")
    public void system_should_show_booking_error_message(String expectedMessage, String fieldName) {
        By locator;
        switch (fieldName.toLowerCase()) {
            case "firstname":
                locator = By.id("t-first-name-1");
                break;
            case "lastname":
                locator = By.id("t-last-name-1");
                break;
            case "passport":
                locator = By.id("t-passport-1");
                break;
            case "email":
                locator = By.id("t-email-1");
                break;
            case "phone":
                locator = By.id("t-phone-1");
                break;
            default:
                throw new IllegalArgumentException("Unknown field: " + fieldName);
        }

        String actual = bookingPage.getValidationMessage(locator);
        assert actual.contains(expectedMessage)
                : "❌ Expected: " + expectedMessage + " but got: " + actual;
        System.out.println("✅ Error message validated for field " + fieldName + ": " + actual);
    }
    @Then("user clicks proceed on invoice page")
    public void user_clicks_proceed_on_invoice_page() {
        bookingPage.clickProceedOnInvoice();
    }

}
