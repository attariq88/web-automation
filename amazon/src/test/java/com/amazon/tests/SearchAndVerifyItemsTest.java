package com.amazon.tests;

import com.amazon.base.ConnectDB;
import com.amazon.base.TestBase;
import com.amazon.base.report.ExtentTestManager;
import com.amazon.data.DataProviderForTests;
import com.amazon.pages.CreateAccountPage;
import com.amazon.pages.HomePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.ArrayList;

public class SearchAndVerifyItemsTest extends TestBase {

    private static final Logger LOGGER = Logger.getLogger(SearchAndVerifyItemsTest.class);

    private HomePage homePage;
    private CreateAccountPage createAccountPage;

    @BeforeMethod
    private void setPOM(){
        homePage = PageFactory.initElements(driver, HomePage.class);
        createAccountPage = PageFactory.initElements(driver,CreateAccountPage.class);
    }

    @Test(enabled = false)
    public void validateUserBeingAbleToSearchForAnItem1(){

        validateUrlWithExpected("https://www.amazon.com/");
        homePage.amazonLogoIsDisplayed();

        homePage.typeOnSearchBar();
        ExtentTestManager.log("Nike typed on the search bar.",LOGGER);
        sleepFor(2);

        homePage.clickOnSearchButton();
        ExtentTestManager.log("Clicked on the search button.",LOGGER);
    }

    @Test(enabled = true,dataProviderClass = DataProviderForTests.class, dataProvider = "getDataForSearchtest")
    public void validateUserBeingAbleToSearchForAnItem2(String booksName){

        validateUrlWithExpected("https://www.amazon.com/");
        homePage.amazonLogoIsDisplayed();

        homePage.typeOnSearchBar(booksName);
        ExtentTestManager.log(booksName + " typed on the search bar.",LOGGER);
        sleepFor(2);

        homePage.clickOnSearchButton();
        ExtentTestManager.log("Clicked on the search button.",LOGGER);

        homePage.verifySearchResult(booksName);
        ExtentTestManager.log("Search result displayed",LOGGER);
        sleepFor(2);


    }

    @Test(enabled = false)
    public void validateUserBeingAbleToSearchForAnItemFromDatabase() throws SQLException {

        validateUrlWithExpected("https://www.amazon.com/");
        homePage.amazonLogoIsDisplayed();

        String query = "select * from testdata";

        ArrayList<String> datas = ConnectDB.connectToDbAndGetTheData(query,"brandName");

        homePage.typeOnSearchBar(datas.get(0));
        ExtentTestManager.log(datas.get(0) + " typed on the search bar.",LOGGER);
        sleepFor(2);
        homePage.clickOnSearchButton();
        ExtentTestManager.log("Clicked on the search button.",LOGGER);

        homePage.verifyAutosuggestion();
        ExtentTestManager.log("Autosuggestion displayed",LOGGER);
        sleepFor(5);

    }



}
