package com.amazon.tests;

import com.amazon.base.ConnectDB;
import com.amazon.base.TestBase;
import com.amazon.base.report.ExtentTestManager;
import com.amazon.data.DataProviderForTests;
import com.amazon.pages.HomePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchTest extends TestBase {

    private static final Logger LOGGER = Logger.getLogger(SearchTest.class);

    private HomePage homePage;

    @BeforeMethod
    private void setPOM(){
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test(enabled = false)
    public void validateUserBeingAbleToSearchForAnItem1(){

        homePage.typeOnSearchBar();
        ExtentTestManager.log("Nike typed on the search bar.",LOGGER);
        sleepFor(2);

        homePage.clickOnSearchButton();
        ExtentTestManager.log("Clicked on the search button.",LOGGER);
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

        homePage.verifyAutosuggestion();
        ExtentTestManager.log("Autosuggestion displayed",LOGGER);

//        homePage.selectProductCategoryAfterSearch();
//        ExtentTestManager.log("Item's category selected",LOGGER);

        homePage.navigateProductFromSearchResult();
        ExtentTestManager.log("Item selected from search result list",LOGGER);


    }

    @Test(enabled = false)
    public void validateUserBeingAbleToSearchForAnItemFromDatabase() throws SQLException {

        String query = "select * from testdata";

        ArrayList<String> datas = ConnectDB.connectToDbAndGetTheData(query,"brandName");

        homePage.typeOnSearchBar(datas.get(0));
        ExtentTestManager.log(datas.get(0) + " typed on the search bar.",LOGGER);
        sleepFor(2);
        homePage.clickOnSearchButton();
        ExtentTestManager.log("Clicked on the search button.",LOGGER);

        homePage.navigateProductFromSearchResult();
        ExtentTestManager.log("Item selected from search result list",LOGGER);

    }



}
