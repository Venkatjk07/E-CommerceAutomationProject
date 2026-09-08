package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CheckoutPage;
import pages.LoginPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkout() {

        // Login
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        // Add product
        driver.findElement(
                By.id("add-to-cart-sauce-labs-backpack")
        ).click();

        // Open cart
        driver.findElement(
                By.className("shopping_cart_link")
        ).click();

        // Click checkout
        driver.findElement(
                By.id("checkout")
        ).click();

        // Checkout
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        checkoutPage.enterFirstName("Venkat");
        checkoutPage.enterLastName("K");
        checkoutPage.enterPostalCode("600063");

        checkoutPage.clickContinue();

        // Verify Checkout Overview
        Assert.assertTrue(
                checkoutPage.isCheckoutOverviewDisplayed(),
                "Checkout Overview page is not displayed"
        );

        // Finish order
        checkoutPage.clickFinish();

        // Verify successful order
        Assert.assertTrue(
                checkoutPage.isOrderSuccessful(),
                "Order was not completed successfully"
        );
    }
}