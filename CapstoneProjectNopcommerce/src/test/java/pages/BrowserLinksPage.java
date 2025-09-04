package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.DriverFactory;

public class BrowserLinksPage {

	@FindBy(linkText = "Electronics")
	WebElement electronicsCategory;

	@FindBy(linkText = "Cell phones")
	WebElement cellPhonesSubcategory;

	@FindBy(linkText = "Sitemap")
	WebElement sitemapLink;

	@FindBy(linkText = "Shipping & returns")
	WebElement shippingReturnsLink;

	@FindBy(linkText = "Privacy notice")
	WebElement privacyNoticeLink;

	@FindBy(linkText = "Conditions of Use")
	WebElement conditionUse;

	@FindBy(linkText = "About us")
	WebElement aboutUs;

	@FindBy(linkText = "Contact us")
	WebElement contactUs;

	@FindBy(linkText = "News")
	WebElement news;

	@FindBy(linkText = "New products")
	WebElement products;

	@FindBy(linkText = "Blog")
	WebElement blog;

	@FindBy(css = "div.page-title h1")
	WebElement pageTitle;

	public BrowserLinksPage() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}

	public void clickElectronics() {
		DriverFactory.waitForElementClickable(electronicsCategory, 10);
		electronicsCategory.click();
	}

	public void clickCellPhonesSubcategory() {
		DriverFactory.waitForElementClickable(cellPhonesSubcategory, 10);
		cellPhonesSubcategory.click();
	}

	public void clickSitemap() {
		DriverFactory.waitForElementClickable(sitemapLink, 10);
		sitemapLink.click();
	}

	public void clickShippingReturns() {
		DriverFactory.waitForElementClickable(shippingReturnsLink, 10);
		shippingReturnsLink.click();
	}

	public void clickPrivacyNotice() {
		DriverFactory.waitForElementClickable(privacyNoticeLink, 10);
		privacyNoticeLink.click();
	}

	public String getPageTitle() {
		DriverFactory.waitForElementVisible(pageTitle, 10);
		return pageTitle.getText();
	}

	public void clickConditions() {
		DriverFactory.waitForElementClickable(conditionUse, 10);
		conditionUse.click();
	}

	public void clickContactUs() {
		DriverFactory.waitForElementClickable(contactUs, 10);
		contactUs.click();
	}

	public void clickAboutUs() {
		DriverFactory.waitForElementClickable(aboutUs, 10);
		aboutUs.click();
	}

	public void clickNews() {
		DriverFactory.waitForElementClickable(news, 10);
		news.click();
	}

	public void clickNewProducts() {
		DriverFactory.waitForElementClickable(products, 10);
		products.click();
	}

	public void clickBlog() {
		DriverFactory.waitForElementClickable(blog, 10);
		blog.click();
	}
}