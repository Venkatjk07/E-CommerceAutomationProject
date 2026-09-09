package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;

    By firstName = By.xpath("//input[@id='first-name']");
    By lastName = By.xpath("//input[@id='last-name']");
    By postalCode = By.xpath("//input[@id='postal-code']");
    	
    By continueButton = By.xpath("//input[@id='continue']");

    By checkoutOverview = By.className("title");

    By finishButton = By.id("finish");

    By successMessage = By.xpath("//h2[text()='Thank you for your order!']");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void enterFirstName(String fname) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(firstName)
        ).sendKeys(fname);
    }

    public void enterLastName(String lname) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(lastName)
        ).sendKeys(lname);
    }

    public void enterPostalCode(String postal) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(postalCode)
        ).sendKeys(postal);
    }

    public void clickContinue() {

        wait.until(
                ExpectedConditions.elementToBeClickable(continueButton)
        ).click();
    }

    public boolean isCheckoutOverviewDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(checkoutOverview)
        ).isDisplayed();
    }

    public void clickFinish() {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(finishButton)
        );

        wait.until(
                ExpectedConditions.elementToBeClickable(finishButton)
        );

        driver.findElement(finishButton).click();
    }
    
    public boolean isOrderSuccessful() {

        wait.until(
                ExpectedConditions.urlContains("checkout-complete")
        );

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(successMessage)
        ).isDisplayed();
    }
}