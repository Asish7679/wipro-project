package pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverFactory;

public class CartPage {

	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	WebElement addToCartBackpack;

	@FindBy(id = "add-to-cart-sauce-labs-bike-light")
	WebElement addToCartBikeLight;

	@FindBy(className = "shopping_cart_link")
	WebElement cartIcon;

	@FindBy(className = "shopping_cart_badge")
	WebElement cartBadge;

	@FindBy(className = "cart_item")
	List<WebElement> cartItems;

	@FindBy(xpath = "//button[contains(text(),'Remove')]")
	List<WebElement> removeButtons;

	public CartPage() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}


	public void addSingleItem() {
		DriverFactory.waitForElementClickable(addToCartBackpack, 10);
		addToCartBackpack.click();
	}

	public void addMultipleItems() {
		DriverFactory.waitForElementClickable(addToCartBackpack, 10);
		addToCartBackpack.click();

		DriverFactory.waitForElementClickable(addToCartBikeLight, 10);
		addToCartBikeLight.click();
	}


	public void openCart() {
		DriverFactory.waitForElementClickable(cartIcon, 10);
		cartIcon.click();
	}


	public boolean isCartUpdated() {
		try {
			DriverFactory.waitForElementVisible(cartBadge, 10);
			return cartBadge.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}


	public int getCartBadgeCount() {
		try {
			String text = cartBadge.getText().trim();
			if (text.isEmpty()) {
				return 0;
			}
			return Integer.parseInt(text);
		} catch (Exception e) {
			return 0;
		}
	}


	public int getCartItemsCount() {
		try {
			DriverFactory.waitForElementVisible(cartItems.get(0), 10);
			return cartItems.size();
		} catch (Exception e) {
			return 0; // if cart is empty
		}
	}


	public void removeSingleItem() {
		if (!removeButtons.isEmpty()) {
			DriverFactory.waitForElementClickable(removeButtons.get(0), 10);
			removeButtons.get(0).click();
		}
	}

	public void removeAllItems() {
		for (WebElement btn : removeButtons) {
			DriverFactory.waitForElementClickable(btn, 10);
			btn.click();
		}
	}


	public boolean isCartEmpty() {
		return cartItems.isEmpty();
	}
}
