package stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import io.cucumber.java.en.*;
import pages.CartPage;
import utilities.DriverFactory;

public class CartSteps {

	CartPage cartPage = new CartPage();

	@When("User adds single item to the cart")
	public void user_adds_single_item_to_the_cart() {
		cartPage.addSingleItem();
	}

	@When("User adds multiple items to the cart")
	public void user_adds_multiple_items_to_the_cart() {
		cartPage.addMultipleItems();
	}

	@When("User opens the cart page")
	public void user_opens_the_cart_page() {
		cartPage.openCart();
	}

	@Then("User should see the item in the cart")
	public void user_should_see_the_item_in_the_cart() {
		assertTrue(cartPage.isCartUpdated());
	}

	@Then("User should see multiple items in the cart")
	public void user_should_see_multiple_items_in_the_cart() {
		assertTrue(cartPage.getCartItemsCount() >= 2);
	}

	@When("User removes one item from the cart")
	public void user_removes_one_item_from_the_cart() {
		cartPage.removeSingleItem();
	}

	@Then("The removed item should no longer be in the cart")
	public void the_removed_item_should_no_longer_be_in_the_cart() {
		assertTrue(cartPage.getCartItemsCount() < 2);
	}

	@Then("Cart badge count should match number of items added")
	public void cart_badge_count_should_match_number_of_items_added() {
		cartPage.openCart();
		assertEquals(cartPage.getCartItemsCount(), cartPage.getCartBadgeCount(),
				"Cart badge count and cart items count did not match!");
	}

	@When("User removes all items from the cart")
	public void user_removes_all_items_from_the_cart() {
		cartPage.removeAllItems();
	}

	@Then("Cart badge should not be visible")
	public void cart_badge_should_not_be_visible() {
		assertEquals(0, cartPage.getCartBadgeCount());
	}

	@When("User clicks on cart icon")
	public void user_clicks_on_cart_icon() {
		cartPage.openCart();
	}

	@Then("User should be navigated to the cart page")
	public void user_should_be_navigated_to_the_cart_page() {
		assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("cart"));
	}

	@Then("Cart should be empty")
	public void cart_should_be_empty() {
		assertTrue(cartPage.isCartEmpty());
	}
}
