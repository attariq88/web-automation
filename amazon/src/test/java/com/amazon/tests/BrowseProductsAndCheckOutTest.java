package com.amazon.tests;

import com.amazon.base.TestBase;
import com.amazon.base.report.ExtentTestManager;
import com.amazon.pages.HomePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowseProductsAndCheckOutTest extends TestBase {

    private static final Logger LOGGER = Logger.getLogger(SearchTest.class);

    private HomePage homePage;

    @BeforeMethod
    private void setPOM(){
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test(enabled = true)
    public void validateUserBeingAbleToBrowseAnItem() {

        homePage.clickOnProductsCategories("Today's Deals");
        ExtentTestManager.log("Clicked on the  button.",LOGGER);
    }
}
