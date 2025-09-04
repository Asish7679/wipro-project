package stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FooterPage;

public class FooterSteps {

	FooterPage footerPage = new FooterPage();

	@When("User checks the social media links")
	public void user_checks_social_media_links() {
		// just ensuring the links are present
		assertTrue(footerPage.getTwitterLink().isDisplayed());
		assertTrue(footerPage.getFacebookLink().isDisplayed());
		assertTrue(footerPage.getLinkedinLink().isDisplayed());
	}

	@Then("Clicking each link should navigate to the expected URL")
	public void clicking_each_link_should_navigate_to_expected_url() {
		String twitterUrl = footerPage.getLinkUrl(footerPage.getTwitterLink());
		String facebookUrl = footerPage.getLinkUrl(footerPage.getFacebookLink());
		String linkedinUrl = footerPage.getLinkUrl(footerPage.getLinkedinLink());

		assertTrue(twitterUrl.contains("twitter.com/saucelabs"));
		assertTrue(facebookUrl.contains("facebook.com/saucelabs"));
		assertTrue(linkedinUrl.contains("linkedin.com/company/sauce-labs"));
	}
}
