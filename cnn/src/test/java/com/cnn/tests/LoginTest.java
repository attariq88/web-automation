package com.cnn.tests;

import com.amazon.base.TestBase;
import com.cnn.pages.LandingPage;
import com.cnn.pages.LoginPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    private static final Logger LOGGER = Logger.getLogger(SignOutTest.class);

    private LandingPage landingPage;
    private LoginPage loginPage;

    @BeforeMethod
    private void setPOM() {
        landingPage = PageFactory.initElements(driver, LandingPage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Test
    public void validateUserBeingAbleToLogOut(){

    }
}
