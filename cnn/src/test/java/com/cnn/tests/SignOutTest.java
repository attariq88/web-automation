package com.cnn.tests;

import com.amazon.base.TestBase;
import com.amazon.base.report.ExtentTestManager;
import com.cnn.data.DataProviderForTests;
import com.cnn.pages.HomePage;
import com.cnn.pages.LandingPage;
import com.cnn.pages.LoginPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignOutTest extends TestBase {

    private static final Logger LOGGER = Logger.getLogger(SignOutTest.class);

    private LandingPage landingPage;
    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeMethod
    private void setPOM() {
        landingPage = PageFactory.initElements(driver, LandingPage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        homePage = PageFactory.initElements(driver,HomePage.class);
    }

    @Test(dataProviderClass = DataProviderForTests.class,dataProvider = "getDataForLoginTest")
    public void validateUserBeingAbleToSignOut(String email, String password) {

        validateUrlWithExpected("https://www.cnn.com/");
        homePage.logoDisplay();
        ExtentTestManager.log("Logo is displayed",LOGGER);

        landingPage.clickOnUserAccountButton();
        ExtentTestManager.log("Clicked on 'user account' button",LOGGER);
        sleepFor(2);

        loginPage.typeOnEmailField(email);
        ExtentTestManager.log("email typed successfully",LOGGER);
        sleepFor(1);

        loginPage.typeOnPasswordField(password);
        ExtentTestManager.log("password typed successfully",LOGGER);
        sleepFor(1);

        loginPage.clickOnLoginButton();
        ExtentTestManager.log("Clicked on login button",LOGGER);
        sleepFor(2);

        landingPage.clickOnUserAccountButton();
        ExtentTestManager.log("Clicked on 'user account' button", LOGGER);
        sleepFor(2);

        homePage.clickONLogOutButton();
        ExtentTestManager.log("Clicked on 'Log Out' button", LOGGER);


    }

}
