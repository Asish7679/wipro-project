package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.DriverFactory;

public class LoginPage {

	@FindBy(id = "user-name")
	WebElement username;

	@FindBy(id = "password")
	WebElement passwordField;

	@FindBy(id = "login-button")
	WebElement loginButton;

	@FindBy(css = "#login_button_container > div > form > div.error-message-container.error > h3 > button")
	WebElement errorMessage;

	@FindBy(id = "react-burger-menu-btn")
	WebElement logoutMenu;

	@FindBy(id = "logout_sidebar_link")
	WebElement logoutButton;

	public LoginPage() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}

	public void enterUsername(String user) {
		DriverFactory.waitForElementVisible(username, 10);
		username.clear();
		username.sendKeys(user);
	}

	public void enterPassword(String password) {
		DriverFactory.waitForElementVisible(passwordField, 10);
		passwordField.clear();
		passwordField.sendKeys(password);
	}

	public void clickLoginButton() {
		DriverFactory.waitForElementClickable(loginButton, 10);
		loginButton.click();
	}

	public boolean isHomePageDisplayed() {
		return DriverFactory.getDriver().getCurrentUrl().contains("inventory");
	}

	public boolean isErrorMessageDisplayed() {
		DriverFactory.waitForElementVisible(errorMessage, 10);
		return errorMessage.isDisplayed();
	}

	public void clickLogout() {
		DriverFactory.waitForElementClickable(logoutMenu, 10);
		logoutMenu.click();
		DriverFactory.waitForElementClickable(logoutButton, 10);
		logoutButton.click();
	}
}
