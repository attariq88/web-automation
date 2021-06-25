package com.amazon.tests;

import com.amazon.base.ConnectDB;
import com.amazon.base.TestBase;
import com.amazon.base.report.ExtentTestManager;
import com.amazon.data.DataProviderForTests;
import com.amazon.pages.CreateAccountPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.SignInPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.ArrayList;

public class CreateAccountTest extends TestBase {
    private static final Logger LOGGER = Logger.getLogger(CreateAccountTest.class);

    private HomePage homePage;
    private SignInPage signInPage;
    private CreateAccountPage createAccountPage;

    @BeforeMethod
    private void setPOM(){
        homePage = PageFactory.initElements(driver,HomePage.class);
        signInPage = PageFactory.initElements(driver,SignInPage.class);
        createAccountPage = PageFactory.initElements(driver,CreateAccountPage.class);

    }

    @Test(enabled = false,dataProviderClass = DataProviderForTests.class,dataProvider = "getDataForCreateAccountTest")
    public void validateUserCanCreateAccountFromDataProvider(String userName, String email,String password){

        validateUrlWithExpected("https://www.amazon.com/");
        amazonLogoIsDisplayed();

        homePage.clickOnSignButton();
        ExtentTestManager.log("Sign in button clicked.",LOGGER);
        sleepFor(2);

        signInPage.clickOnCreateAccountButton();
        ExtentTestManager.log("Create your Amazon account clicked",LOGGER);
        sleepFor(2);

        createAccountPage.typeInNameField(userName);
        ExtentTestManager.log("user name typed in successfully",LOGGER);
        sleepFor(1);

        createAccountPage.typeInMobileNumberOrEmailField(email);
        ExtentTestManager.log("email address typed in successfully",LOGGER);
        sleepFor(1);

        createAccountPage.typeInPasswordFiled(password);
        ExtentTestManager.log("password typed in successfully",LOGGER);
        sleepFor(1);

        createAccountPage.typeInReEnterField(password);
        ExtentTestManager.log("password re-entered successfully",LOGGER);
        sleepFor(1);

        createAccountPage.validateTheFieldLabelsAreDisplayed();
        ExtentTestManager.log("Field's label are displayed",LOGGER);
        sleepFor(2);

        createAccountPage.clickOnVerifyEmailButton();
        ExtentTestManager.log("verify email button clicked successfully",LOGGER);
        sleepFor(10);

//        createAccountPage.clickOnSolePuzzleButton();

    }

    @Test(enabled = true)
    public void validateUserBeingAbleToCreateAccountDatabase() throws SQLException {

        String query = "select * from information_for_account_create";

        ArrayList<String> username = ConnectDB.connectToDbAndGetTheData(query,"username");
        ArrayList<String> email = ConnectDB.connectToDbAndGetTheData(query,"email");
        ArrayList<String> password = ConnectDB.connectToDbAndGetTheData(query,"password");

        validateUrlWithExpected("https://www.amazon.com/");
        homePage.amazonLogoIsDisplayed();

        homePage.clickOnSignButton();
        ExtentTestManager.log("Sign in button clicked.",LOGGER);
        sleepFor(2);

        signInPage.clickOnCreateAccountButton();
        ExtentTestManager.log("Create your Amazon account clicked",LOGGER);
        sleepFor(2);

        createAccountPage.typeInNameField(username.get(0));
        ExtentTestManager.log(username.get(0) + " typed on the name field.",LOGGER);
        sleepFor(1);

        createAccountPage.typeInMobileNumberOrEmailField(email.get(0));
        ExtentTestManager.log(email.get(0) + " typed on the email field.",LOGGER);
        sleepFor(1);

        createAccountPage.typeInPasswordFiled(password.get(0));
        ExtentTestManager.log(password.get(0) + " typed on the password field.",LOGGER);
        sleepFor(1);

        createAccountPage.typeInReEnterField(password.get(0));
        ExtentTestManager.log(password.get(0) + " typed on the re-enter password field.",LOGGER);
        sleepFor(1);

        createAccountPage.clickOnVerifyEmailButton();
        ExtentTestManager.log("verify email button clicked successfully",LOGGER);
        sleepFor(10);


    }


}
