package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.DriverFactory;

public class LoginPage {

	@FindBy(id = "Email")
	WebElement emailInput;

	@FindBy(id = "Password")
	WebElement passwordInput;

	@FindBy(xpath = "//button[contains(text(),'Log in')]")
	WebElement loginButton;

	@FindBy(className = "message-error")
	WebElement errorMessage;

	@FindBy(linkText = "Log out")
	private WebElement logoutLink;

	@FindBy(linkText = "Log in")
	private WebElement loginLink;

	@FindBy(linkText = "Register")
	private WebElement registerLink;

	@FindBy(className = "ico-login")
	WebElement loginHomePage;

	public LoginPage() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}

	public void enterEmail(String email) {
		DriverFactory.waitForElementClickable(emailInput, 10);
		emailInput.clear();
		emailInput.sendKeys(email);
	}

	public void enterPassword(String password) {
		DriverFactory.waitForElementClickable(passwordInput, 10);
		passwordInput.clear();
		passwordInput.sendKeys(password);
	}

	public void clickLogin() {
		DriverFactory.waitForElementClickable(loginButton, 10);
		loginButton.click();
	}

	public String getErrorMessage() {
		DriverFactory.waitForElementVisible(errorMessage, 10);
		return errorMessage.getText();
	}

	public boolean isLogoutDisplayed() {
		DriverFactory.waitForElementVisible(logoutLink, 10);
		return logoutLink.isDisplayed();
	}

	public void clickLogout() {
		DriverFactory.waitForElementClickable(logoutLink, 10);
		logoutLink.click();
	}

	public boolean isLoginAndRegisterVisible() {
		DriverFactory.waitForElementVisible(loginLink , 10);
		DriverFactory.waitForElementVisible(registerLink , 10);
		return loginLink.isDisplayed() && registerLink.isDisplayed();
	}

	public void navigateLoginPage() {
		DriverFactory.waitForElementClickable(loginHomePage, 10);
		loginHomePage.click();
	}

}
