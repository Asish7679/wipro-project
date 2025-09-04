package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/booking.html",
                "json:target/cucumber-booking.json"
        },
        monochrome = true,
        tags = "@config or @fbooking"
)
public class bookingRunner extends AbstractTestNGCucumberTests {
}
