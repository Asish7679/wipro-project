package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.DriverFactory;

public class CheckoutPage {

	@FindBy(css = "div.page.checkout-page")
	WebElement checkoutPage;

	@FindBy(css = "button.checkout-button")
	WebElement checkoutButton;

	@FindBy(id = "termsofservice")
	WebElement privacy;

	@FindBy(id = "BillingNewAddress_FirstName")
	WebElement firstName;

	@FindBy(id = "BillingNewAddress_LastName")
	WebElement lastName;

	@FindBy(id = "BillingNewAddress_Email")
	WebElement email;

	@FindBy(id = "BillingNewAddress_CountryId")
	WebElement country;

	@FindBy(id = "BillingNewAddress_StateProvinceId")
	WebElement state;

	@FindBy(id = "BillingNewAddress_City")
	WebElement city;

	@FindBy(id = "BillingNewAddress_Address1")
	WebElement address1;

	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement zip;

	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement phone;

	@FindBy(xpath = "//button[@name='save']")
	WebElement continueButton;

	@FindBy(id = "shippingoption_1")
	WebElement shippingDay;

	@FindBy(xpath = "//*[@id=\"shipping-method-buttons-container\"]/button")
	WebElement afterShippingButton;

	@FindBy(id = "paymentmethod_0")
	WebElement payment;

	@FindBy(xpath = "//*[@id=\"payment-method-buttons-container\"]/button")
	WebElement paymentNextButton;

	@FindBy(xpath = "//*[@id=\"payment-info-buttons-container\"]/button")
	WebElement paymentConfirmation;

	@FindBy(xpath = "//*[@id=\"confirm-order-buttons-container\"]/button")
	WebElement confirmationButton;

	@FindBy(css = "div.title strong")
	WebElement orderSuccessMessage;

	public CheckoutPage() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}

	public void clickCheckout() {
		DriverFactory.waitForElementClickable(privacy, 10);
		privacy.click();
		DriverFactory.waitForElementClickable(checkoutButton, 10);
		checkoutButton.click();
	}

	public boolean verifyCheckoutPage() {
		DriverFactory.waitForElementVisible(checkoutPage, 10);
		return checkoutPage.isDisplayed();
	}

	public void fillCheckoutForm(String fn, String ln, String em, String ctry, String ct, String st, String addr,
			String zipCode, String ph) throws InterruptedException {

		DriverFactory.waitForElementClickable(firstName, 10);
		firstName.clear();
		firstName.sendKeys(fn);

		DriverFactory.waitForElementClickable(lastName, 10);
		lastName.clear();
		lastName.sendKeys(ln);

		DriverFactory.waitForElementClickable(email, 10);
		email.clear();
		email.sendKeys(em);

		DriverFactory.waitForElementClickable(country, 10);
		Select countryDropdown = new Select(country);
		countryDropdown.selectByVisibleText(ctry);

		DriverFactory.waitForElementClickable(state, 10);
		Select stateDropdown = new Select(state);
		stateDropdown.selectByVisibleText(st);

		DriverFactory.waitForElementClickable(city, 10);
		city.clear();
		city.sendKeys(ct);

		DriverFactory.waitForElementClickable(address1, 10);
		address1.clear();
		address1.sendKeys(addr);

		DriverFactory.waitForElementClickable(zip, 10);
		zip.clear();
		zip.sendKeys(zipCode);

		DriverFactory.waitForElementClickable(phone, 10);
		phone.clear();
		phone.sendKeys(ph);

		DriverFactory.waitForElementClickable(continueButton, 10);
		continueButton.click();

		// Shipping step
		DriverFactory.waitForElementClickable(shippingDay, 10);
		shippingDay.click();
		DriverFactory.waitForElementClickable(afterShippingButton, 10);
		afterShippingButton.click();

		// Payment step
		DriverFactory.waitForElementClickable(payment, 10);
		payment.click();
		DriverFactory.waitForElementClickable(paymentNextButton, 10);
		paymentNextButton.click();
		DriverFactory.waitForElementClickable(paymentConfirmation, 10);
		paymentConfirmation.click();

		// Confirm order
		DriverFactory.waitForElementClickable(confirmationButton, 10);
		confirmationButton.click();
	}

	// Verify order success
	public boolean verifyOrderSuccess() {
		DriverFactory.waitForElementVisible(orderSuccessMessage, 10);
		return orderSuccessMessage.isDisplayed();
	}
}
