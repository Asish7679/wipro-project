package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverFactory;

public class ProductPage {

    public ProductPage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public void addAppleMacToWishlist() {
        WebElement productLink = DriverFactory.getDriver().findElement(By.linkText("Apple MacBook Pro"));
        DriverFactory.waitForElementClickable(productLink, 10);
        productLink.click();


        WebElement wishlistButton = DriverFactory.getDriver()
                .findElement(By.id("add-to-wishlist-button-4"));
        DriverFactory.waitForElementClickable(wishlistButton, 10);
        wishlistButton.click();
    }

    public boolean isWishlisted() {
        DriverFactory.getDriver().findElement(By.linkText("Wishlist")).click();
        return DriverFactory.getDriver().findElement(By.className("product-name")).isDisplayed();
    }
}
