package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.DriverFactory;

public class RegistrationPage {

	@FindBy(id = "gender-male")
	WebElement genderMale;

	@FindBy(id = "FirstName")
	WebElement firstName;

	@FindBy(id = "LastName")
	WebElement lastName;

	@FindBy(id = "Email")
	WebElement email;

	@FindBy(id = "Password")
	WebElement password;

	@FindBy(id = "ConfirmPassword")
	WebElement confirmPassword;

	@FindBy(id = "register-button")
	WebElement registerButton;

	@FindBy(className = "result")
	WebElement completeMessage;

	@FindBy(className = "message-error")
	WebElement errorMessage;

	@FindBy(id = "Email-error")
	WebElement emailError;

	@FindBy(id = "Password-error")
	WebElement passwordError;

	@FindBy(id = "ConfirmPassword-error")
	WebElement confirmPasswordError;

	@FindBy(className = "ico-register")
	WebElement registerHomePage;

	@FindBy(className = "ico-logout")
	WebElement logoutHomePage;

	public RegistrationPage() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}
	
	public void selectGender() {
		DriverFactory.waitForElementClickable(genderMale, 10);
		genderMale.click();
	}
	
	public void enterFirstname(String name) {
		DriverFactory.waitForElementClickable(firstName, 10);
		firstName.sendKeys(name);
	}

	public void enterLastname(String name) {
		DriverFactory.waitForElementClickable(lastName, 10);
		lastName.sendKeys(name);
	}

	public void enterEmail(String mail) {
		DriverFactory.waitForElementClickable(email, 10);
		email.sendKeys(mail);
	}

	public void enterPassword(String pass) {
		DriverFactory.waitForElementClickable(password, 10);
		password.sendKeys(pass);
	}

	public void enterConfirmPassword(String confirm) {
		DriverFactory.waitForElementClickable(confirmPassword, 10);
		confirmPassword.sendKeys(confirm);
	}

	public void clickRegister() {
		DriverFactory.waitForElementClickable(registerButton, 10);
		registerButton.click();
	}

	public String getSuccessMessage() {
		DriverFactory.waitForElementVisible(completeMessage, 10);
		return completeMessage.getText();
	}

	public String getErrorMessage() {
		DriverFactory.waitForElementVisible(errorMessage, 10);
		WebElement innerError = errorMessage.findElement(By.tagName("li"));
		DriverFactory.waitForElementVisible(innerError, 10);
		return innerError.getText();
	}

	public String getEmailError() {
		DriverFactory.waitForElementVisible(emailError, 10);
		return emailError.getText();
	}

	public String getPasswordError() {
		DriverFactory.waitForElementVisible(passwordError, 10);
		return passwordError.getText();
	}

	public String getConfirmPasswordError() {
		DriverFactory.waitForElementVisible(confirmPasswordError, 10);
		return confirmPasswordError.getText();
	}

	public void goToRegisterPage() {
		DriverFactory.waitForElementClickable(registerHomePage, 10);
		registerHomePage.click();
	}

	public void clickLogout() {
		DriverFactory.waitForElementClickable(logoutHomePage, 10);
		logoutHomePage.click();
	}

	public String getMismatchedErrorMessage() {
		DriverFactory.waitForElementVisible(confirmPasswordError, 10);
		return confirmPasswordError.getText();
	}
}
