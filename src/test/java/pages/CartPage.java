package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    // Locators
    By backpackName = By.className("inventory_item_name");

    By checkoutButton = By.id("checkout");

    By continueShoppingButton = By.id("continue-shopping");

    By removeBackpackButton = By.id("remove-sauce-labs-backpack");

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Verify product is displayed in cart
    public boolean isBackpackDisplayed() {
        return driver.findElement(backpackName).isDisplayed();
    }

    // Click Checkout
    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }

    // Click Continue Shopping
    public void clickContinueShopping() {
        driver.findElement(continueShoppingButton).click();
    }

    // Remove Backpack
    public void removeBackpack() {
        driver.findElement(removeBackpackButton).click();
    }
}
