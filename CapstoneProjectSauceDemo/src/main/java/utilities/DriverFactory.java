package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {

	private static WebDriver driver;

	public static WebDriver getDriver() {
		if (driver == null) {
			String browser = ConfigReader.get("browser").toLowerCase();

			switch (browser) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			case "edge":
				System.setProperty("webdriver.edge.driver", "C:\\Drivers\\Edge\\msedgedriver.exe\\");
				driver = new EdgeDriver();
				break;
			default:
				throw new RuntimeException("Browser not supported: " + browser);
			}

			driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		return driver;
	}

	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

	public static void waitForElementVisible(WebElement element, int timeoutInSeconds) {
		new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutInSeconds))
				.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitForElementClickable(WebElement element, int timeoutInSeconds) {
		new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutInSeconds))
				.until(ExpectedConditions.elementToBeClickable(element));
	}
}
