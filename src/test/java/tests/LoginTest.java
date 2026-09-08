package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;

	public class LoginTest extends BaseTest {

	    @Test
	    public void validLoginTest() {

	        LoginPage loginPage = new LoginPage(driver);

	        loginPage.enterUsername("standard_user");

	        loginPage.enterPassword("secret_sauce");

	        loginPage.clickLogin();
	        
	        Assert.assertTrue(
	                driver.getCurrentUrl().contains("inventory"));
	    }
	}


