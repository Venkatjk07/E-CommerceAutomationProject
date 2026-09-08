package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductTest extends BaseTest {

    @Test
    public void addProductTest() {

        // Login
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        // Product page
        ProductsPage productsPage = new ProductsPage(driver);

        // Add product
        
        
        
        productsPage.addBackpackToCart();
        
        productsPage.addSecondpackToCart();

        // Open cart
        productsPage.clickCart();

        // Verify cart
        Assert.assertTrue(driver.getCurrentUrl().contains("cart"));
    }
}