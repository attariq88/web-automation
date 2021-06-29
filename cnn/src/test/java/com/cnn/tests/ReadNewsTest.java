package com.cnn.tests;

import com.amazon.base.TestBase;
import com.amazon.base.report.ExtentTestManager;
import com.cnn.data.DataProviderForTests;
import com.cnn.pages.HomePage;
import com.cnn.pages.LandingPage;
import com.cnn.pages.LoginPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReadNewsTest extends TestBase {

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

    @Test(enabled = false,dataProviderClass = DataProviderForTests.class,dataProvider = "getDataForLoginTest")
    public void validateUserBeingAbleToReadNews(String email, String password){

        validateUrlWithExpected("https://www.cnn.com/");
        homePage.logoDisplay();
        ExtentTestManager.log("Logo is displayed",LOGGER);
        sleepFor(2);

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

        homePage.clickOnNewsHeadline();
        ExtentTestManager.log("Clicked on News headline",LOGGER);
        sleepFor(3);

        driver.navigate().back();

    }

    @Test(enabled = true)
    public void verifyNews(){

        validateUrlWithExpected("https://www.cnn.com/");
        homePage.logoDisplay();
        ExtentTestManager.log("Logo is displayed",LOGGER);
        sleepFor(2);


        String actualHeadLineTile = driver.findElement(By.xpath("(//span[@class='cd__headline-text vid-left-enabled'])[19]")).getText();

        homePage.clickOnNewsHeadline();
        ExtentTestManager.log("Clicked on headline",LOGGER);
        sleepFor(2);


        String expectedHeadlineTitle = driver.findElement(By.xpath("//h1[@class='pg-headline']")).getText();
        Assert.assertEquals(actualHeadLineTile,expectedHeadlineTitle,"Headline not matched");
        ExtentTestManager.log("News verified",LOGGER);

        userAbleToScrollDown();
        ExtentTestManager.log("Page scrolled down",LOGGER);
        sleepFor(2);

        userAbleToScrollDown();
        ExtentTestManager.log("Page scrolled down",LOGGER);
        sleepFor(2);

        userAbleToScrollDown();
        ExtentTestManager.log("Page scrolled down",LOGGER);
        sleepFor(2);

        driver.navigate().back();
        ExtentTestManager.log("Back to the home page",LOGGER);
    }
}
