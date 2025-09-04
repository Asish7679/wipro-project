package stepdefinitions;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BrowserLinksPage;
import utilities.ConfigReader;
import utilities.DriverFactory;

public class BrowserLinksSteps {

	BrowserLinksPage page = new BrowserLinksPage();
	String url = ConfigReader.get("URL");

	@Given("I am on the homepage")
	public void i_am_on_the_homepage() throws IOException {
		DriverFactory.getDriver().get(url);
	}

	@When("I click on {string} category")
	public void i_click_on_category(String category) {
		if (category.equalsIgnoreCase("Electronics")) {
			page.clickElectronics();
		}
	}

	@When("I select {string}")
	public void i_select(String subcategory) {
		if (subcategory.equalsIgnoreCase("Cell phones")) {
			page.clickCellPhonesSubcategory();
		}
	}

	@Then("I should see the list of cell phones displayed")
	public void i_should_see_the_list_of_cell_phones_displayed() {
		String title = page.getPageTitle();
		Assert.assertTrue(title.contains("Cell phones"), "Page title should contain 'Cell phones'");
	}

	@When("I click on the sitemap link in the footer")
	public void i_click_on_the_sitemap_link_in_the_footer() {
		page.clickSitemap();
	}

	@Then("I should see the full site map displayed")
	public void i_should_see_the_full_site_map_displayed() {
		String title = page.getPageTitle();
		Assert.assertTrue(title.contains("Sitemap"), "Page title should contain 'Sitemap'");
	}

	@When("I click on {string} link")
	public void i_click_on_link(String linkName) {
		if (linkName.equalsIgnoreCase("Shipping & returns")) {
			page.clickShippingReturns();
		} else if (linkName.equalsIgnoreCase("Privacy notice")) {
			page.clickPrivacyNotice();
		} else if (linkName.equalsIgnoreCase("Conditions of Use")) {
			page.clickConditions();
		} else if (linkName.equalsIgnoreCase("About us")) {
			page.clickAboutUs();
		} else if (linkName.equalsIgnoreCase("Contact us")) {
			page.clickContactUs();
		} else if (linkName.equalsIgnoreCase("News")) {
			page.clickNews();
		} else if (linkName.equalsIgnoreCase("New products")) {
			page.clickNewProducts();
		} else if (linkName.equalsIgnoreCase("Blog")) {
			page.clickBlog();
		}
	}

	@Then("I should see the Shipping & Returns page content")
	public void i_should_see_the_shipping_returns_page_content() {
		String title = page.getPageTitle();
		Assert.assertTrue(title.contains("Shipping & returns"), "Page title should contain 'Shipping & returns'");
	}

	@Then("I should see the Privacy Notice page content")
	public void i_should_see_the_privacy_notice_page_content() {
		String title = page.getPageTitle();
		System.out.println(title + "Title");
		Assert.assertTrue(title.contains("Privacy notice"), "Page title should contain 'Privacy Notice'");
	}

	@Then("I should see the Conditions of Use page content")
	public void i_should_see_the_conditions_of_use_page_content() {
		String title = page.getPageTitle();
		Assert.assertTrue(title.contains("Conditions of Use"), "Page title should contain 'Conditions of Use'");
	}

	@Then("I should see the About us page content")
	public void i_should_see_the_about_us_page_content() {
		String title = page.getPageTitle();
		Assert.assertTrue(title.contains("About us"), "Page title should contain 'About us'");
	}

	@Then("I should see the Contact us page content")
	public void i_should_see_the_contact_us_page_content() {
		String title = page.getPageTitle();
		Assert.assertTrue(title.contains("Contact Us"), "Page title should contain 'Contact Us'");
	}

	@Then("I should see the News content")
	public void i_should_see_the_news_content() {
		String title = page.getPageTitle();
		Assert.assertTrue(title.contains("News"), "Page title should contain 'News'");
	}

	@Then("I should see the New products content")
	public void i_should_see_the_new_products_content() {
		String title = page.getPageTitle();
		Assert.assertTrue(title.contains("New products"), "Page title should contain 'New products'");
	}

	@Then("I should see the Blog content")
	public void i_should_see_the_blog_content() {
		String title = page.getPageTitle();
		Assert.assertTrue(title.contains("Blog"), "Page title should contain 'Blog'");
	}

}
