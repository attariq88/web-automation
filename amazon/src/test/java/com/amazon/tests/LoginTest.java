package com.amazon.tests;

import com.amazon.base.TestBase;
import com.amazon.base.report.ExtentTestManager;
import com.amazon.data.DataProviderForTests;
import com.amazon.pages.CreateAccountPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.SignInPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    private static final Logger LOGGER = Logger.getLogger(LoginTest.class);

    private HomePage homePage;
    private SignInPage signInPage;
    private CreateAccountPage createAccountPage;

    @BeforeMethod
    private void setPOM(){
        homePage = PageFactory.initElements(driver,HomePage.class);
        signInPage = PageFactory.initElements(driver,SignInPage.class);
        createAccountPage = PageFactory.initElements(driver,CreateAccountPage.class);

    }

    @Test(dataProviderClass = DataProviderForTests.class,dataProvider = "getDataForLoginTest")
    public void validateUserCanCreateAccount(String userName, String email,String password){

        validateUrlWithExpected("https://www.amazon.com/");
        createAccountPage.amazonLogoIsDisplayed();

        homePage.clickOnSignButton();
        ExtentTestManager.log("Sign in button clicked.",LOGGER);
        sleepFor(2);

        signInPage.clickOnCreateAccountButton();
        ExtentTestManager.log("Create your Amazon account clicked",LOGGER);
        sleepFor(2);

        createAccountPage.typeInNameField(userName);
        ExtentTestManager.log("user name typed in successfully",LOGGER);

        createAccountPage.typeInMobileNumberOrEmailField(email);
        ExtentTestManager.log("email address typed in successfully",LOGGER);

        createAccountPage.typeInPasswordFiled(password);
        ExtentTestManager.log("password typed in successfully",LOGGER);

        createAccountPage.typeInReEnterField(password);
        ExtentTestManager.log("password re-entered successfully",LOGGER);

        createAccountPage.validateTheFieldLabelsAreDisplayed();
        sleepFor(2);

        createAccountPage.clickOnVerifyEmailButton();
        ExtentTestManager.log("verify email button clicked successfully",LOGGER);
        sleepFor(10);

//        createAccountPage.clickOnSolePuzzleButton();

    }


}
