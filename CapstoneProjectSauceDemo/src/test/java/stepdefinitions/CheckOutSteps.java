package stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckOutPage;

public class CheckOutSteps {

	CheckOutPage checkoutPage = new CheckOutPage();

	@When("User clicks on Checkout button")
	public void user_clicks_on_checkout() {
		assertTrue(checkoutPage.isCartPageDisplayed(), "Not on cart page before clicking Checkout");
		checkoutPage.clickCheckout();
	}

	@When("User fills checkout information")
	public void user_fills_checkout_information() {
		checkoutPage.enterFirstName("Anurag");
		checkoutPage.enterLastName("Dos");
		checkoutPage.enterPostalCode("12345");
	}

	@When("User clicks on Continue button")
	public void user_clicks_on_continue() {
		checkoutPage.clickContinue();
	}

	@When("User clicks on Finish button")
	public void user_clicks_on_finish() {
		checkoutPage.clickFinish();
	}

	@When("User clicks on Cancel button")
	public void user_clicks_on_cancel() {
		checkoutPage.clickCancel();
	}

	@Then("User should be on the Checkout Information page")
	public void user_should_be_on_checkout_information_page() {
		assertTrue(checkoutPage.isCheckoutInfoPageDisplayed(), "Checkout Information page not displayed");
	}

	@Then("User should be on the Checkout Overview page")
	public void user_should_be_on_checkout_overview_page() {
		assertTrue(checkoutPage.isCheckoutOverviewPageDisplayed(), "Checkout Overview page not displayed");
	}

	@Then("Error message should be displayed")
	public void error_message_should_be_displayed() {
		assertTrue(checkoutPage.isErrorMessageDisplayed(), "Error message not displayed");
	}

	@Then("User should see selected items in the summary")
	public void user_should_see_selected_items_in_summary() {
		assertTrue(checkoutPage.isItemSummaryDisplayed(), "Item summary not displayed");
	}

	@Then("Total price should be displayed")
	public void total_price_should_be_displayed() {
		assertTrue(checkoutPage.isTotalPriceDisplayed(), "Total price not displayed");
	}

	@Then("User should see order confirmation message")
	public void user_should_see_order_confirmation_message() {
		assertTrue(checkoutPage.isOrderCompleteMessageDisplayed(), "Order confirmation message not displayed");
	}

	@Then("User should be navigated back to the cart page")
	public void user_should_be_navigated_back_to_the_cart_page() {
		assertTrue(checkoutPage.isCartPageDisplayed(), "User is not on cart page");
	}

	@Then("User should be navigated back to the products page")
	public void user_should_be_navigated_back_to_the_products_page() {
		assertTrue(checkoutPage.isProductsPageDisplayed(), "User is not on products page");
	}

	@Then("User should see order completion page")
	public void user_should_see_order_completion_page() {
		assertTrue(checkoutPage.isOrderCompleteMessageDisplayed(), "Order completion page not displayed");
	}
}
