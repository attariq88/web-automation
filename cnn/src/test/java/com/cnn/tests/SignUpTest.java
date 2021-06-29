package com.cnn.tests;

import com.amazon.base.TestBase;
import com.amazon.base.report.ExtentTestManager;
import com.cnn.data.DataProviderForTests;
import com.cnn.pages.LandingPage;
import com.cnn.pages.LoginPage;
import com.cnn.pages.SignUpPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sun.java2d.pipe.hw.ExtendedBufferCapabilities;

public class SignUpTest extends TestBase {

    private static final Logger LOGGER = Logger.getLogger(SignUpTest.class);

    private LandingPage landingPage;
    private LoginPage loginPage;
    private SignUpPage signUpPage;

    @BeforeMethod
    private void setPOM(){
        landingPage = PageFactory.initElements(driver,LandingPage.class);
        loginPage = PageFactory.initElements(driver,LoginPage.class);
        signUpPage = PageFactory.initElements(driver,SignUpPage.class);
    }

    @Test(dataProviderClass = DataProviderForTests.class,dataProvider = "getDataForSignUpTest")
    public void validateUserBeingAbleToSignUp(String email, String password, String zipcode){

        validateUrlWithExpected("https://www.cnn.com/");

        landingPage.clickOnUserAccountButton();
        ExtentTestManager.log("Clicked on 'user account' button",LOGGER);

        loginPage.clickOnSignUpButton();
        ExtentTestManager.log("Clicked on 'sign up' button",LOGGER);

        signUpPage.typeOnEmailField(email);
        ExtentTestManager.log("email typed successfully",LOGGER);
        sleepFor(2);

        signUpPage.typeOnPasswordField(password);
        ExtentTestManager.log("password typed successfully",LOGGER);
        sleepFor(2);

        signUpPage.typeOnZipcodeField(zipcode);
        ExtentTestManager.log("zipcode typed successfully",LOGGER);
        sleepFor(2);

        signUpPage.clickOnCreateAccountButton();
        ExtentTestManager.log("Clicked on 'create account' button",LOGGER);
        sleepFor(2);



    }

}
