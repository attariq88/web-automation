package com.cnn.tests;

import com.amazon.base.TestBase;
import com.amazon.base.report.ExtentTestManager;
import com.cnn.data.DataProviderForTests;
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

    @Test(dataProviderClass = DataProviderForTests.class,dataProvider = "getDataForLoginTest")
    public void validateUserBeingAbleToLogOut(String email, String password){

        validateUrlWithExpected("https://www.cnn.com/");

        landingPage.clickOnUserAccountButton();
        ExtentTestManager.log("Clicked on 'user account icon'",LOGGER);
        sleepFor(2);

        loginPage.typeOnEmailField(email);
        ExtentTestManager.log("email typed successfully",LOGGER);
        sleepFor(1);

        loginPage.typeOnPasswordField(password);
        ExtentTestManager.log("password typed successfully",LOGGER);
        sleepFor(1);

        loginPage.clickOnLoginButton();
        ExtentTestManager.log("Clicked on login button",LOGGER);


    }
}
