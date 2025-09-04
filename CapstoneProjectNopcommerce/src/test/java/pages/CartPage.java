package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.DriverFactory;

public class CartPage {

	@FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div[4]/div[2]/div[2]/div/div[2]/div[3]/div[2]/button[1]")
	WebElement productMacbook;

	@FindBy(id = "add-to-cart-button-4")
	WebElement cartButton;

	@FindBy(css = "div.bar-notification.success p.content a")
	WebElement popUpButton;

	@FindBy(className = "sku")
	WebElement cartPage;

	public CartPage() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}

	public void clickOnProduct() {
		DriverFactory.waitForElementClickable(productMacbook, 10);
		productMacbook.click();
	}

	public void clickOnCart() {
		DriverFactory.waitForElementClickable(cartButton, 10);
		cartButton.click();
	}

	public void popUpButton() {
		DriverFactory.waitForElementClickable(popUpButton, 10);
		popUpButton.click();
	}

	public boolean verifyCart() {
		DriverFactory.waitForElementVisible(cartPage, 10);
		return cartPage.isDisplayed();
	}
}
