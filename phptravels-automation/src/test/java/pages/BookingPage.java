package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.TimeoutException;

public class BookingPage extends BasePage {

   
    private By firstSelectFlight = By.xpath("(//button[contains(text(),'Select Flight')])[1]");
    private By firstName = By.id("p-first-name");
    private By lastName = By.id("p-last-name");
    private By email = By.id("p-email");
    private By phone = By.id("p-phone");
    private By address = By.id("p-address");
    private By travellerFirstName = By.id("t-first-name-1");
    private By travellerLastName = By.id("t-last-name-1");
    private By travellerPassport = By.id("t-passport-1");
    private By travellerEmail = By.id("t-email-1");
    private By travellerPhone = By.id("t-phone-1");
    private By paypalOption = By.id("gateway_paypal");
    private By termsCheckbox = By.id("agreechb");
    private By confirmBookingBtn = By.id("booking");


    private By errorMessage = By.cssSelector("div.invalid-feedback, small.text-danger, span.error");

    public BookingPage(WebDriver driver) {
        super(driver);
    }

    public void openResultsPage() {
        driver.get("https://www.phptravels.net/flights/ber/ist/oneway/economy/06-09-2025/1/0/0");
        try {
            Thread.sleep(20000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void selectFirstFlight() {
        try {
            Thread.sleep(5000);
            driver.findElement(firstSelectFlight).click();
            System.out.println("✅ First flight selected");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

  
    public void fillPassengerDetails(String fName, String lName, String mail, String phoneNum, String addr) {
        type(firstName, fName);
        type(lastName, lName);
        type(email, mail);
        type(phone, phoneNum);
        type(address, addr);
    }

    public void fillTravellerDetails() {
        type(travellerFirstName, "Asish");
        type(travellerLastName, "Kumar");
        type(travellerPassport, "123456789");
        type(travellerEmail, "asish.auto@test.com");
        type(travellerPhone, "9876543210");

        System.out.println("✅ Traveller details filled");
    }


    public void fillTravellerDetailsCustom(String fName, String lName, String passport, String mail, String phoneNum) {
        type(travellerFirstName, fName);
        type(travellerLastName, lName);
        type(travellerPassport, passport);
        type(travellerEmail, mail);
        type(travellerPhone, phoneNum);
    }

   
    public String getValidationMessage(By locator) {
        WebElement element = driver.findElement(locator);
        String nativeMsg = element.getAttribute("validationMessage");
        if (nativeMsg != null && !nativeMsg.isEmpty()) {
            return nativeMsg;
        }

        try {
            WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
            return error.getText();
        } catch (TimeoutException e) {
            return "No validation message found";
        }
    }

    // ✅ Payment Flow
    public void choosePaypalAndConfirm() {
        try {
            Thread.sleep(2000);

            WebElement paypalRadio = driver.findElement(paypalOption);
            ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", paypalRadio);
            ((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new Event('change'));", paypalRadio);
            System.out.println(" PayPal option selected");

            Thread.sleep(1000);

            WebElement checkbox = driver.findElement(termsCheckbox);
            ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", checkbox);
            ((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new Event('change'));", checkbox);
            System.out.println(" Terms checkbox selected");

            Thread.sleep(1000);

            WebElement confirmBtn = driver.findElement(confirmBookingBtn);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", confirmBtn);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", confirmBtn);
            System.out.println(" Booking Confirm clicked");

            Thread.sleep(5000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
 
    private By proceedBtn = By.id("form");

    public void clickProceedOnInvoice() {
        try {
            WebElement proceed = driver.findElement(proceedBtn);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", proceed);
            Thread.sleep(1000);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", proceed);
            System.out.println("✅ Proceed button clicked on Invoice page");
            Thread.sleep(3000); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
