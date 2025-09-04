package stepdefinitions;

import org.testng.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;

public class CartSteps {

	CartPage page = new CartPage();

	@When("I add a product to the cart")
	public void i_add_a_product_to_the_cart() throws InterruptedException {
		Thread.sleep(3000);
		page.clickOnProduct();
		Thread.sleep(3000);
		page.clickOnCart();
		Thread.sleep(2000);
		page.popUpButton();
	}

	@Then("product should appear in my shopping cart")
	public void product_should_appear_in_my_shopping_cart() {
		Assert.assertTrue(page.verifyCart(), "Product should be displayed in cart");
	}
}
