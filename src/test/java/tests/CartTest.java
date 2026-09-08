package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class CartTest extends BaseTest {

    @Test
    public void verifyProductInCart() {

        // Login
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        // Product page
        ProductsPage productsPage = new ProductsPage(driver);

        productsPage.addBackpackToCart();

        productsPage.clickCart();

        // Cart page
        CartPage cartPage = new CartPage(driver);

        // Verify product
        Assert.assertTrue(
                cartPage.isBackpackDisplayed(),
                "Backpack is not displayed in cart"
        );
    }
}
