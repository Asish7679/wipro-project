package stepdefinitions;

import java.io.IOException;
import java.util.Base64;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.ConfigReader;
import utilities.DriverFactory;
import utilities.ReportManager;

public class Hooks {

	private static ExtentReports extent = ReportManager.getExtentReports();
	private static ExtentTest test;

	// Global delay in milliseconds
	private static final long STEP_DELAY = 3000;

	@Before
	public void setUp(Scenario scenario) throws IOException {
		ConfigReader.loadConfig();
		DriverFactory.getDriver();

		test = extent.createTest(scenario.getName());
	}

	@AfterStep
	public void afterEachStep() {
		try {
			Thread.sleep(STEP_DELAY);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);

			test.fail("Scenario failed", MediaEntityBuilder
					.createScreenCaptureFromBase64String(Base64.getEncoder().encodeToString(screenshot)).build());
		} else {
			test.pass("Scenario passed");
		}
		DriverFactory.quitDriver();

		extent.flush();
	}
}
