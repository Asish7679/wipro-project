package stepdefinitions;

import org.testng.Assert;
import io.cucumber.java.en.*;
import pages.ProductPage;

public class WishlistSteps {

	ProductPage productPage = new ProductPage();

	@When("I add Apple MacBook Pro to the wishlist")
	public void i_add_apple_macbook_to_the_wishlist() {
		productPage.addAppleMacToWishlist();
	}

	@Then("Apple MacBook Pro should appear in my wishlist")
	public void apple_macbook_pro_should_appear_in_my_wishlist() {
		Assert.assertTrue(productPage.isWishlisted());
	}
}
