package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.DriverFactory;

public class FooterPage {

	@FindBy(css = "footer .social_twitter a")
	WebElement twitterLink;

	@FindBy(css = "footer .social_facebook a")
	WebElement facebookLink;

	@FindBy(css = "footer .social_linkedin a")
	WebElement linkedinLink;

	public FooterPage() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}

	public WebElement getTwitterLink() {
		return twitterLink;
	}

	public WebElement getFacebookLink() {
		return facebookLink;
	}

	public WebElement getLinkedinLink() {
		return linkedinLink;
	}

	public String getLinkUrl(WebElement link) {
		return link.getAttribute("href");
	}

	public void clickLink(WebElement link) {
		DriverFactory.waitForElementClickable(link, 10);
		link.click();
	}
}
