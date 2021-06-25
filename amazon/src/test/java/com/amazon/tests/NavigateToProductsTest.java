package com.amazon.tests;

import com.amazon.base.TestBase;
import com.amazon.base.report.ExtentTestManager;
import com.amazon.data.DataProviderForTests;
import com.amazon.pages.HomePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NavigateToProductsTest extends TestBase {

    private static final Logger LOGGER = Logger.getLogger(SearchAndVerifyItemTest.class);

    private HomePage homePage;

    @BeforeMethod
    private void setPOM(){
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test(enabled = true,dataProviderClass = DataProviderForTests.class, dataProvider = "getDataForSearchtest")
    public void validateUserBeingAbleToSearchForAnItem2(String brandName){

        homePage.typeOnSearchBar(brandName);
        ExtentTestManager.log(brandName + " typed on the search bar.",LOGGER);
        sleepFor(2);

        homePage.clickOnSearchButton();
        ExtentTestManager.log("Clicked on the search button.",LOGGER);

        homePage.verifySearchResult(brandName);
        ExtentTestManager.log("Search result displayed",LOGGER);
        sleepFor(2);

        homePage.verifyAutosuggestion();
        ExtentTestManager.log("Autosuggestion displayed",LOGGER);

//        homePage.selectProductCategoryAfterSearch();
//        ExtentTestManager.log("Item's category selected",LOGGER);

        homePage.navigateProductFromSearchResult();
        ExtentTestManager.log("Item selected from search result list",LOGGER);


    }
}
