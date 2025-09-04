package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/search.html",
                "json:target/cucumber-search.json"
        },
        monochrome = true,
        tags = "config or @eflightsearch"
)
public class searchRunner extends AbstractTestNGCucumberTests {
}
