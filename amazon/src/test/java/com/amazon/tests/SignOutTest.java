package com.amazon.tests;

import com.amazon.base.TestBase;
import com.amazon.base.report.ExtentTestManager;
import com.amazon.data.DataProviderForTests;
import com.amazon.pages.HomePage;
import com.amazon.pages.SignInPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignOutTest extends TestBase {

    private static final Logger LOGGER = Logger.getLogger(SignOutTest.class);

    private HomePage homePage;
    private SignInPage signInPage;


    @BeforeMethod
    private void setPOM(){
        homePage = PageFactory.initElements(driver, HomePage.class);
        signInPage = PageFactory.initElements(driver,SignInPage.class);
    }

    @Test(dataProviderClass = DataProviderForTests.class,dataProvider = "getDataForLoginTest")
    public void validateUserBeingAbleToSignOutFromTheirAccount(String email, String password){

        validateUrlWithExpected("https://www.amazon.com/");
        amazonLogoIsDisplayed();

        homePage.clickOnSignButton();
        ExtentTestManager.log("Sign in button clicked.",LOGGER);
        sleepFor(2);

        signInPage.typeInMobileNumberOrEmailField(email);
        ExtentTestManager.log("Email field typed in successfully",LOGGER);
        sleepFor(2);

        signInPage.clickOnContinueButton();
        ExtentTestManager.log("Continue button clicked",LOGGER);
        sleepFor(2);

        signInPage.typeInPasswordFiled(password);
        ExtentTestManager.log("Password field typed in successfully",LOGGER);
        sleepFor(2);

        signInPage.clickOnSignInButton();
        ExtentTestManager.log("Sign in button clicked",LOGGER);
        sleepFor(5);

        homePage.signOutFromAccount();
        ExtentTestManager.log("Sign out",LOGGER);


    }
}
