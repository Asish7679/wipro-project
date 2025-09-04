package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FlightSearchPage;
import utils.DriverFactory;

import java.time.Duration;

public class FlightSearchSteps {

    WebDriver driver;
    FlightSearchPage flightSearchPage;
    String initialUrl;

    @Given("user is on homepage")
    public void user_is_on_homepage() {
        driver = DriverFactory.getDriver();
        driver.get("https://www.phptravels.net/");
        flightSearchPage = new FlightSearchPage(driver);
        initialUrl = driver.getCurrentUrl();
    }

    @When("user searches for a flight")
    public void user_searches_for_a_flight() {
        flightSearchPage.searchFlight("New York", "London");
    }

    @When("user searches for a flight with departure {string} and arrival {string}")
    public void user_searches_for_a_flight_with_departure_and_arrival(String departure, String arrival) {
        flightSearchPage.searchFlight(departure, arrival);
    }

    @When("user searches for a flight with {int} adults")
    public void user_searches_for_a_flight_with_adults(Integer adults) {
        flightSearchPage.searchFlightWithPassengers("New York", "London", adults);
    }

    @Then("flight results should be displayed")
    public void flight_results_should_be_displayed() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(20))
                    .until(ExpectedConditions.or(
                            ExpectedConditions.visibilityOfElementLocated(
                                    By.xpath("//button[normalize-space()='Select Flight']")),
                            ExpectedConditions.visibilityOfElementLocated(
                                    By.xpath("//div[contains(@class,'card-body')]"))
                    ));
            System.out.println("Flight results displayed.");
        } catch (Exception e) {
            throw new AssertionError("Flight results page not displayed!", e);
        }
    }

    @Then("system should not navigate to results page")
    public void system_should_not_navigate_to_results_page() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.urlContains("/flights/"));
            throw new AssertionError("❌ URL changed to results page, but it should NOT have.");
        } catch (Exception e) {
            
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.equals(initialUrl)) {
                System.out.println("⚠️ Invalid search handled correctly. URL did not change.");
            } else {
                System.out.println("⚠️ URL changed unexpectedly: " + currentUrl);
            }
        }
    }
}
