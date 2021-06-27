package com.facebook.tests;

import com.amazon.base.TestBase;
import com.amazon.base.report.ExtentTestManager;
import com.facebook.data.DataProviderForTests;
import com.facebook.pages.AccountInfoPage;
import com.facebook.pages.LandingPage;
import com.facebook.pages.SignUpPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SignUpTest extends TestBase {

    private static final Logger LOGGER = Logger.getLogger(SignUpTest.class);

    private LandingPage landingPage;
    private SignUpPage signUpPage;
    private AccountInfoPage accountInfoPage;

    @BeforeMethod
    private void setPOM(){
        landingPage = PageFactory.initElements(driver,LandingPage.class);
        signUpPage = PageFactory.initElements(driver,SignUpPage.class);
        accountInfoPage = PageFactory.initElements(driver,AccountInfoPage.class);
    }

    @Test(dataProviderClass = DataProviderForTests.class, dataProvider = "getDataForSignUpTest")
    public void validateUserBeingAbleToSignUp(String firstName, String lastName, String email, String password){

        validateUrlWithExpected("https://www.facebook.com/");
        landingPage.facebookLogoIsDisplayed();
        ExtentTestManager.log("Logo display is validated",LOGGER);
        sleepFor(1);

        landingPage.clickOnCreateNewAccountButton();
        ExtentTestManager.log("Clicked on 'Create New Account' button",LOGGER);
        sleepFor(2);

        signUpPage.typeOnFirstNameField(firstName);
        ExtentTestManager.log("First name typed in successfully",LOGGER);
        sleepFor(1);

        signUpPage.typeOnLastNameField(lastName);
        ExtentTestManager.log("Last name typed in successfully",LOGGER);
        sleepFor(1);

        signUpPage.typeOnEmailField(email);
        ExtentTestManager.log("Email typed in successfully",LOGGER);
        sleepFor(1);

        signUpPage.typeOnReEnterEmailField(email);
        ExtentTestManager.log("Email typed in successfully",LOGGER);
        sleepFor(1);

        signUpPage.typeOnPasswordField(password);
        ExtentTestManager.log("Password typed in successfully",LOGGER);
        sleepFor(1);

        signUpPage.selectBirthMonth("Oct");
        ExtentTestManager.log("Birth month selected successfully",LOGGER);
        sleepFor(1);

        signUpPage.selectBirthDate("17");
        ExtentTestManager.log("Birth date selected successfully",LOGGER);
        sleepFor(1);

        signUpPage.selectBirthYear("1981");
        ExtentTestManager.log("Birth year selected successfully",LOGGER);
        sleepFor(1);

        signUpPage.selectGender();
        ExtentTestManager.log("Gender selected successfully",LOGGER);
        sleepFor(1);

        signUpPage.clickOnSignUpButton();
        ExtentTestManager.log("Clicked on 'Sign Up' button successfully",LOGGER);
        sleepFor(2);

        accountInfoPage.clickOnContinueButton();
        ExtentTestManager.log("Clicked on 'Continue' button",LOGGER);

    }
}
