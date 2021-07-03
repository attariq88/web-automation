package com.cigna.tests;

import com.amazon.base.TestBase;
import com.amazon.base.report.ExtentTestManager;
import com.cigna.data.DataProviderForTests;
import com.cigna.pages.HomePage;
import com.cigna.pages.LoginPage;
import com.cigna.pages.RegistrationPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class RegisterTest extends TestBase {

    private static final Logger LOGGER = Logger.getLogger(RegisterTest.class);

    private HomePage homePage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;

    @BeforeMethod
    private void setPOM(){
        homePage = PageFactory.initElements(driver,HomePage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        registrationPage = PageFactory.initElements(driver,RegistrationPage.class);
    }

    @Test(dataProviderClass = DataProviderForTests.class,dataProvider = "getDataForRegistrationTest")
    public void validateUserBeingAbleToRegister(String firstname, String lastname, String birthMonth, String birthDate, String birthYear,
                                                String zipcode){

        validateUrlWithExpected("https://www.cigna.com/");
        homePage.logoDisplayed();
        ExtentTestManager.log("Logo is displayed.",LOGGER);
        sleepFor(2);

        homePage.clickOnLoginButton();
        ExtentTestManager.log("Clicked on log in button",LOGGER);

        Set<String> windowsAfterOpeningNewTab = driver.getWindowHandles();
        String currentWindowsHash = driver.getWindowHandle();
        for(String window: windowsAfterOpeningNewTab){
            if(!window.equalsIgnoreCase(currentWindowsHash)){
                driver.switchTo().window(window);
            }
        }

        loginPage.clickOnRegisterButton();
        ExtentTestManager.log("Clicked on register button",LOGGER);
        sleepFor(2);

        registrationPage.typeOnFirstnameField(firstname);
        ExtentTestManager.log("First name type on the field",LOGGER);
        sleepFor(2);

        registrationPage.typeOnLastnameField(lastname);
        ExtentTestManager.log("Last name type on the field",LOGGER);
        sleepFor(2);

        registrationPage.clickOnNextButton();
        ExtentTestManager.log("Clicked on next button",LOGGER);
        sleepFor(2);

        registrationPage.selectBirthMonth(birthMonth);
        ExtentTestManager.log("Birth month selected",LOGGER);
        sleepFor(2);

        registrationPage.typeOnBirthDayField(birthDate);
        ExtentTestManager.log("Date type on the field",LOGGER);
        sleepFor(2);

        registrationPage.typeOnBirthYearField(birthYear);
        ExtentTestManager.log("Year type on the field",LOGGER);
        sleepFor(2);

        registrationPage.clickOnNextButton();
        ExtentTestManager.log("Clicked on next button",LOGGER);
        sleepFor(2);

        registrationPage.typeOnZipcodeField(zipcode);
        ExtentTestManager.log("zipcode type on the field",LOGGER);
        sleepFor(2);

        registrationPage.clickOnNextButton();
        ExtentTestManager.log("Clicked on next button",LOGGER);
        sleepFor(2);

        registrationPage.selectProfilePlan();
        ExtentTestManager.log("Plan selected",LOGGER);
        sleepFor(2);

        registrationPage.clickOnNextButton();
        ExtentTestManager.log("Clicked on next button",LOGGER);
        sleepFor(2);
    }
}
