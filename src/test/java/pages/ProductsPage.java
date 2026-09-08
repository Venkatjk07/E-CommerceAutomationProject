package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage {

    WebDriver driver;

    By backpack = By.id("add-to-cart-sauce-labs-backpack");
    
    By Secondbackpack = By.id("add-to-cart-sauce-labs-bike-light");
    
    By sort_dropdown = By.className("product_sort_container");
    By cartButton = By.className("shopping_cart_link");
    By productPrices = By.className("inventory_item_price");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addBackpackToCart() {
        driver.findElement(backpack).click();
    }
    
    public void addSecondpackToCart() {
    	driver.findElement(Secondbackpack).click();
    }
    

    public void clickCart() {
        driver.findElement(cartButton).click();
    }
}