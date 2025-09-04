package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.datatable.DataTable;
import utils.ConfigReader;
import utils.DriverFactory;

import org.openqa.selenium.WebDriver;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setup() {
        System.out.println("=== Test Started ===");

        
        if (ConfigReader.get("browser") != null) {
            driver = DriverFactory.getDriver();
        }
    }

    @After
    public void teardown() {
        DriverFactory.quitDriver();
        System.out.println("=== Test Finished ===");
    }

    @Given("the following application config")
    public void the_following_application_config(DataTable table) {
        ConfigReader.setConfig(table);
        driver = DriverFactory.getDriver();
    }
}
