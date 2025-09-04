package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/registration.html",
                "json:target/cucumber-registration.json"
        },
        monochrome = true,
        tags = "@config or @dregistration"
)
public class registrationRunner extends AbstractTestNGCucumberTests {
}
