package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.DriverFactory;

public class LinkCheckPage {

	@FindBy(id = "react-burger-menu-btn")
	WebElement burgerMenuButton;

	@FindBy(className = "bm-menu-wrap")
	WebElement menuContainer;

	@FindBy(css = ".bm-item-list a")
	List<WebElement> menuLinks;

	public LinkCheckPage() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}

	public void openMenu() {
		DriverFactory.waitForElementClickable(burgerMenuButton, 10);
		burgerMenuButton.click();
	}

	public boolean isMenuVisible() {
		DriverFactory.waitForElementVisible(menuContainer, 10);
		return menuContainer.isDisplayed();
	}

	public List<WebElement> getMenuLinks() {
		DriverFactory.waitForElementVisible(menuContainer, 10);
		return menuLinks;
	}

	public void clickLink(WebElement link) {
		((JavascriptExecutor) DriverFactory.getDriver()).executeScript("arguments[0].click();", link);
	}
}
