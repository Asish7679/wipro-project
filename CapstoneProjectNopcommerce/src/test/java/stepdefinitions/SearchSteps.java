package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.SearchPage;

public class SearchSteps {

	SearchPage searchPage = new SearchPage();

	@When("I search for {string}")
	public void i_search_for(String product) {
		searchPage.enterSearchText(product);
		searchPage.clickSearchButton();
	}

	@Then("I should see products related to {string}")
	public void i_should_see_products_related_to(String product) {
		Assert.assertTrue(searchPage.isProductVisible(product),
				"Expected product related to '" + product + "' is not visible.");
	}

	@Then("I should see a message saying {string}")
	public void i_should_see_a_message_saying(String message) {
		//Assert.assertEquals(searchPage.getNoResultMessage(), message);
	}

	@Given("I navigate to the {string} category")
	public void i_navigate_to_the_category(String category) {
		if (category.equalsIgnoreCase("Electronics")) {
			searchPage.navigateToElectronicsCategory();
		}
	}

	@When("I apply the price filter from {string} to {string}")
	public void i_apply_the_price_filter_from_to(String from, String to) {
		searchPage.applyPriceFilter(from, to);
	}

	@Then("I should see products within the price range {string}")
	public void i_should_see_products_within_the_price_range(String range) {
		String[] prices = range.replace("$", "").split("-");
		Assert.assertTrue(searchPage.verifyPriceFilterApplied(prices[0].trim(), prices[1].trim()),"Price filter did not apply correctly.");
	}
}
