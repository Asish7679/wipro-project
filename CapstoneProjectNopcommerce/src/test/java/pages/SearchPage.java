package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverFactory;

import java.util.List;

public class SearchPage {

	@FindBy(id = "small-searchterms")
	WebElement searchBox;

	@FindBy(css = "button[type='submit']")
	WebElement searchButton;

	@FindBy(css = ".product-title a")
	List<WebElement> productTitles;

	@FindBy(css = "div.no-result, div.warning")
	WebElement noResultMessage;

	@FindBy(linkText = "Electronics")
	WebElement electronicsCategory;

	@FindBy(id = "PriceFrom")
	WebElement priceFromInput;

	@FindBy(id = "PriceTo")
	WebElement priceToInput;

	@FindBy(css = "button#filter-price-range")
	WebElement priceFilterButton;

	public SearchPage() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}

	public void enterSearchText(String text) {
		DriverFactory.waitForElementClickable(searchBox, 10);
		searchBox.clear();
		searchBox.sendKeys(text);
	}

	public void clickSearchButton() {
		DriverFactory.waitForElementClickable(searchButton, 10);
		searchButton.click();
	}

	public boolean isProductVisible(String productName) {
		for (WebElement product : productTitles) {
			if (product.getText().contains(productName)) {
				return true;
			}
		}
		return false;
	}

	public String getNoResultMessage() {
		DriverFactory.waitForElementVisible(noResultMessage, 10);
		return noResultMessage.getText();
	}

	public void navigateToElectronicsCategory() {
		DriverFactory.waitForElementClickable(electronicsCategory, 10);
		electronicsCategory.click();
	}

	public void applyPriceFilter(String from, String to) {
		DriverFactory.waitForElementClickable(priceFromInput, 10);
		priceFromInput.clear();
		priceFromInput.sendKeys(from);
		DriverFactory.waitForElementClickable(priceToInput, 10);
		priceToInput.clear();
		priceToInput.sendKeys(to);
		DriverFactory.waitForElementClickable(priceFilterButton, 10);
		priceFilterButton.click();
	}

	public boolean verifyPriceFilterApplied(String from, String to) {
		return DriverFactory.getDriver().getPageSource().contains("$" + from)
				|| DriverFactory.getDriver().getPageSource().contains("$" + to);
	}
}
