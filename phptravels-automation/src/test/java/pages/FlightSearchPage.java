package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class FlightSearchPage extends BasePage {
    WebDriver driver;

    // Locators
    By departureField = By.xpath("//input[@name='from']");
    By arrivalField   = By.xpath("//input[@name='to']");
    By searchButton   = By.id("flights-search");
    By suggestionList = By.xpath("//div[contains(@class,'result-option')]");

    By passengerDropdown = By.xpath("//*[@id=\"onereturn\"]/div[4]/div/div/div/a");
    By adultPlusBtn =  By.xpath("//*[@id=\"onereturn\"]/div[4]/div/div/div/div/div[1]/div/div/div[2]");

    public FlightSearchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void searchFlight(String departure, String arrival) {
        try {
            // Departure
            WebElement fromInput = wait.until(ExpectedConditions.visibilityOfElementLocated(departureField));
            fromInput.clear();

            if (!departure.isEmpty()) {
                fromInput.sendKeys(departure);
                Thread.sleep(2000); // wait for suggestions
                try {
                    List<WebElement> fromSuggestions = driver.findElements(suggestionList);
                    if (!fromSuggestions.isEmpty()) {
                        fromSuggestions.get(0).click();
                    } else {
                        fromInput.sendKeys(Keys.ENTER);
                    }
                } catch (Exception e) {
                    fromInput.sendKeys(Keys.ENTER);
                }
            }

            // Arrival
            WebElement toInput = wait.until(ExpectedConditions.visibilityOfElementLocated(arrivalField));
            toInput.clear();

            if (!arrival.isEmpty()) {
                toInput.sendKeys(arrival);
                Thread.sleep(2000); // wait for suggestions
                try {
                    List<WebElement> toSuggestions = driver.findElements(suggestionList);
                    if (!toSuggestions.isEmpty()) {
                        toSuggestions.get(0).click();
                    } else {
                        toInput.sendKeys(Keys.ENTER);
                    }
                } catch (Exception e) {
                    toInput.sendKeys(Keys.ENTER);
                }
            }

            Thread.sleep(1000); // extra wait before clicking search
            driver.findElement(searchButton).click();
            System.out.println("✅ Search button clicked successfully");

            Thread.sleep(5000); // wait for results page load

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void searchFlightWithPassengers(String departure, String arrival, int adults) {
        searchFlight(departure, arrival);

        try {
            Thread.sleep(2000);
            driver.findElement(passengerDropdown).click();

            for (int i = 1; i < adults; i++) {
                try {
                    Thread.sleep(500);
                    driver.findElement(adultPlusBtn).click();
                } catch (Exception e) {
                    break;
                }
            }

            Thread.sleep(1000);
            driver.findElement(searchButton).click();
            Thread.sleep(5000); // wait for results
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
