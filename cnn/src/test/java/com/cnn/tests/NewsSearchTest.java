package com.cnn.tests;

import com.amazon.base.TestBase;
import com.amazon.base.report.ExtentTestManager;
import com.cnn.data.DataProviderForTests;
import com.cnn.pages.HomePage;
import com.cnn.pages.LandingPage;
import com.cnn.pages.LoginPage;
import com.cnn.pages.ReadNewsPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewsSearchTest extends TestBase {

    private static final Logger LOGGER = Logger.getLogger(ReadNewsTest.class);

    private HomePage homePage;
    private ReadNewsPage readNewsPage;

    @BeforeMethod
    private void setPOM() {

        homePage = PageFactory.initElements(driver,HomePage.class);
        readNewsPage = PageFactory.initElements(driver,ReadNewsPage.class);
    }

    @Test(dataProviderClass = DataProviderForTests.class, dataProvider = "getDataForNewsSearchTest")
    public void validateUserBeingAbleToSearchNews(String news){

        validateUrlWithExpected("https://www.cnn.com/");
        homePage.logoDisplay();
        ExtentTestManager.log("Logo is displayed",LOGGER);
        sleepFor(2);

        homePage.clickOnSearchIcon();
        ExtentTestManager.log("Clicked on search icon",LOGGER);
        sleepFor(2);

        homePage.typeOnSearchBar(news);
        ExtentTestManager.log("News typed on search bar",LOGGER);
        sleepFor(2);

        homePage.clickOnSearchButton();
        ExtentTestManager.log("Clicked on search button.",LOGGER);

        readNewsPage.verifySearchResult(news);
        ExtentTestManager.log("Search result displayed",LOGGER);


    }

}
