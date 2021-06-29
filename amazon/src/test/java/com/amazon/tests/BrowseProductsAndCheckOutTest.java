package com.amazon.tests;

import com.amazon.base.TestBase;
import com.amazon.base.report.ExtentTestManager;
import com.amazon.data.DataProviderForTests;
import com.amazon.pages.CreateAccountPage;
import com.amazon.pages.HomePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowseProductsAndCheckOutTest extends TestBase {

    private static final Logger LOGGER = Logger.getLogger(BrowseProductsAndCheckOutTest.class);

    private HomePage homePage;
    private CreateAccountPage createAccountPage;

    @BeforeMethod
    private void setPOM(){
        homePage = PageFactory.initElements(driver, HomePage.class);
        createAccountPage = PageFactory.initElements(driver, CreateAccountPage.class);
    }

    @Test(enabled = false, dataProviderClass = DataProviderForTests.class, dataProvider = "getDataForBrowseProductsTest")
    public void validateUserBeingAbleToBrowseAnItemByMouseHover(String linkText) {

        WebElement category = driver.findElement(By.linkText(linkText));
        Actions actions = new Actions(driver);
        actions.moveToElement(category).build().perform();
        category.click();
        ExtentTestManager.log("Clicked on the button.",LOGGER);

    }

    @Test(enabled = false,dataProviderClass = DataProviderForTests.class, dataProvider = "getDataForSearchDropDownTest")
    public void validateUserCanSelectCategoryFromDropDownList(String data){
        homePage.productCategoryDropDown(data);
        ExtentTestManager.log("Category drop down work",LOGGER);
    }

    @Test
    public void validateUserCanSelectProductFromHamburgerMenu(){
        homePage.selectProductsFromHamburgerMenu1();
        ExtentTestManager.log("Select product from hamburger menu work successfully",LOGGER);

    }
}
