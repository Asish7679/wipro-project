package stepdefinitions;

import org.testng.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckoutPage;

public class CheckoutSteps {

	CheckoutPage checkoutPage = new CheckoutPage();

	@When("I proceed to checkout")
	public void i_proceed_to_checkout() {
		checkoutPage.clickCheckout();
	}

	@When("I complete the checkout form")
	public void i_complete_the_checkout_form() throws InterruptedException {
		// Hardcoded test values
		checkoutPage.fillCheckoutForm("John", // First Name
				"Doe", // Last Name
				"john.doe@example.com", // Email
				"India", // Country
				"Bhubaneswar", // City
				"Odisha", // State
				"123 Main Street", // Address
				"751024", // Zip Code
				"9876543210" // Phone
		);
	}

	@Then("I should complete the checkout successfully")
	public void i_should_complete_the_checkout_successfully() {
		// Verify the order confirmation message
		Assert.assertTrue(checkoutPage.verifyOrderSuccess(),
				"Order confirmation message should be displayed after checkout");
	}
}
