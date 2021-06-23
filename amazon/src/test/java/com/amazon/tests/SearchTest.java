package com.amazon.tests;

import com.amazon.base.TestBase;
import com.amazon.base.report.ExtentTestManager;
import com.amazon.pages.CreateAccountPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.SignInPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest extends TestBase {

    private static final Logger LOGGER = Logger.getLogger(SearchTest.class);

    private HomePage homePage;

    @BeforeMethod
    private void setPOM(){
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test(enabled = false)
    public void validateUserBeingAbleToSearchForAnItem1(){

        homePage.typeOnSearchBar1();
        ExtentTestManager.log("Nike typed on the search bar.",LOGGER);
        homePage.clickOnSearchButton();
        ExtentTestManager.log("Clicked on the search button.",LOGGER);
    }
}
