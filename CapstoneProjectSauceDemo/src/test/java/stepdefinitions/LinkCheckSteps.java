package stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LinkCheckPage;

public class LinkCheckSteps {

	LinkCheckPage page = new LinkCheckPage();

	@When("User opens the burger menu")
	public void user_opens_the_burger_menu() {
		page.openMenu();
	}

	@Then("Burger menu should be visible")
	public void burger_menu_should_be_visible() {
		assertTrue(page.isMenuVisible(), "Burger menu is not visible");
	}

	@Then("All menu links should be visible")
	public void all_menu_links_should_be_visible() {
		List<WebElement> links = page.getMenuLinks();
		for (WebElement link : links) {
			assertTrue(link.isDisplayed(), "Link not visible: " + link.getText());
		}
	}

	@Then("All menu links should be clickable")
	public void all_menu_links_should_be_clickable() {
		List<WebElement> links = page.getMenuLinks();
		for (WebElement link : links) {
			assertTrue(link.isEnabled(), "Link not clickable: " + link.getText());
		}
	}
}
