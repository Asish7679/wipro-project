package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.DriverFactory;

public class CheckOutPage {

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "postal-code")
    private WebElement postalCode;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(css = "h3[data-test='error']")
    private WebElement errorMessage;

    @FindBy(id = "cancel")
    private WebElement cancelButton;

    @FindBy(id = "finish")
    private WebElement finishButton;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> itemSummaryList;

    @FindBy(className = "summary_total_label")
    private WebElement totalPrice;

    @FindBy(className = "complete-header")
    private WebElement orderCompleteMessage;

    public CheckOutPage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public void clickCheckout() {
        DriverFactory.waitForElementClickable(checkoutButton, 10);
        checkoutButton.click();
    }

    public void enterFirstName(String fName) {
        DriverFactory.waitForElementVisible(firstName, 10);
        firstName.clear();
        firstName.sendKeys(fName);
    }

    public void enterLastName(String lName) {
        DriverFactory.waitForElementVisible(lastName, 10);
        lastName.clear();
        lastName.sendKeys(lName);
    }

    public void enterPostalCode(String pin) {
        DriverFactory.waitForElementVisible(postalCode, 10);
        postalCode.clear();
        postalCode.sendKeys(pin);
    }

    public void clickContinue() {
        DriverFactory.waitForElementClickable(continueButton, 10);
        continueButton.click();
    }

    public void clickCancel() {
        DriverFactory.waitForElementClickable(cancelButton, 10);
        cancelButton.click();
    }

    public void clickFinish() {
        DriverFactory.waitForElementClickable(finishButton, 10);
        finishButton.click();
    }

    public boolean isCheckoutInfoPageDisplayed() {
        return DriverFactory.getDriver().getCurrentUrl().contains("checkout-step-one");
    }

    public boolean isCheckoutOverviewPageDisplayed() {
        return DriverFactory.getDriver().getCurrentUrl().contains("checkout-step-two");
    }

    public boolean isCartPageDisplayed() {
        return DriverFactory.getDriver().getCurrentUrl().contains("cart");
    }

    public boolean isProductsPageDisplayed() {
        return DriverFactory.getDriver().getCurrentUrl().contains("inventory");
    }

    public boolean isErrorMessageDisplayed() {
        DriverFactory.waitForElementVisible(errorMessage, 10);
        return errorMessage.isDisplayed();
    }

    public boolean isItemSummaryDisplayed() {
        return !itemSummaryList.isEmpty();
    }

    public boolean isTotalPriceDisplayed() {
        return totalPrice.isDisplayed();
    }

    public boolean isOrderCompleteMessageDisplayed() {
        return orderCompleteMessage.isDisplayed();
    }
}
