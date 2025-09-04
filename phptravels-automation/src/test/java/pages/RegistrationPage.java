package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BasePage {

    private By firstName = By.name("first_name");
    private By lastName = By.name("last_name");
    private By phone = By.name("phone");
    private By email = By.id("user_email");
    private By password = By.name("password");
    private By countryDropdown = By.xpath("//button[@title='Select Country']");
    private By countrySearchBox = By.xpath("//div[@class='dropdown-menu show']//input[@type='search']");
    private By indiaOption = By.xpath("//a[contains(.,'India')]");
  //  private By submitBtn = By.xpath("//button[@type='submit']");

    // Error message container (Bootstrap usually uses these)
    private By errorMessage = By.cssSelector("div.invalid-feedback, small.text-danger, span.error");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://www.phptravels.net/signup");
    }

    public void register(String fName, String lName, String country, String phoneNum, String mail, String pwd) {
        type(firstName, fName);
        type(lastName, lName);

        click(countryDropdown);
        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(countrySearchBox));
        search.clear();
        search.sendKeys(country);
        wait.until(ExpectedConditions.elementToBeClickable(indiaOption)).click();

        type(phone, phoneNum);
        type(email, mail);
        type(password, pwd);

        try {
            Thread.sleep(40000); // wait for manual captcha solve
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        button.click();

    }

    public String getValidationMessage(String fieldName) {
        By locator;
        switch (fieldName.toLowerCase()) {
            case "email":
                locator = email;
                break;
            case "password":
                locator = password;
                break;
            case "phone":
                locator = phone;
                break;
            case "firstname":
                locator = firstName;
                break;
            case "lastname":
                locator = lastName;
                break;
            default:
                throw new IllegalArgumentException("Unknown field: " + fieldName);
        }

        // First try HTML5 validation
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        String nativeMsg = element.getAttribute("validationMessage");
        if (nativeMsg != null && !nativeMsg.isEmpty()) {
            return nativeMsg;
        }

        // Fallback: check for custom error messages rendered on page
        try {
            WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
            return error.getText();
        } catch (TimeoutException e) {
            return "No validation message found";
        }
    }
}
