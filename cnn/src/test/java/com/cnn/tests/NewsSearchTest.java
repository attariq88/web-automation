package com.cnn.tests;

import com.amazon.base.TestBase;
import com.cnn.pages.HomePage;
import com.cnn.pages.LandingPage;
import com.cnn.pages.LoginPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

public class NewsSearchTest extends TestBase {

    private static final Logger LOGGER = Logger.getLogger(ReadNewsTest.class);

    private LandingPage landingPage;
    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeMethod
    private void setPOM() {
        landingPage = PageFactory.initElements(driver, LandingPage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        homePage = PageFactory.initElements(driver,HomePage.class);
    }

}
