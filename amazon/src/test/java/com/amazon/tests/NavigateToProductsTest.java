package com.amazon.tests;

import com.amazon.base.TestBase;
import com.amazon.base.report.ExtentTestManager;
import com.amazon.data.DataProviderForTests;
import com.amazon.pages.CreateAccountPage;
import com.amazon.pages.HomePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NavigateToProductsTest extends TestBase {

    private static final Logger LOGGER = Logger.getLogger(NavigateToProductsTest.class);

    private HomePage homePage;
    private CreateAccountPage createAccountPage;

    @BeforeMethod
    private void setPOM(){
        homePage = PageFactory.initElements(driver, HomePage.class);
        createAccountPage = PageFactory.initElements(driver,CreateAccountPage.class);
    }

    @Test(enabled = true,dataProviderClass = DataProviderForTests.class, dataProvider = "getDataForSearchtest")
    public void validateUserBeingAbleToNavigateProductsAfterSearch(String brandName){

        validateUrlWithExpected("https://www.amazon.com/");
        homePage.amazonLogoIsDisplayed();

        homePage.typeOnSearchBar(brandName);
        ExtentTestManager.log(brandName + " typed on the search bar.",LOGGER);
        sleepFor(2);

        homePage.clickOnSearchButton();
        ExtentTestManager.log("Clicked on the search button.",LOGGER);
        sleepFor(2);

//        homePage.selectProductCategoryAfterSearch();
//        ExtentTestManager.log("Item's category selected",LOGGER);

        homePage.navigateProductFromSearchResult();
        ExtentTestManager.log("Item selected from search result list",LOGGER);

    }
}
