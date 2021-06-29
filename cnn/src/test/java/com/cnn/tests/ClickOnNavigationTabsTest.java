package com.cnn.tests;

import com.amazon.base.TestBase;
import com.amazon.base.report.ExtentTestManager;
import com.cnn.data.DataProviderForTests;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ClickOnNavigationTabsTest extends TestBase {

    private static final Logger LOGGER = Logger.getLogger(ClickOnNavigationTabsTest.class);

    @Test(dataProviderClass = DataProviderForTests.class,dataProvider = "getDataForClickOnNavigationTests")
    public void validateUserBeingAbleToChooseNewsCategoryFromNavigationTab(String data){

        validateUrlWithExpected("https://www.cnn.com/");

        WebElement category = driver.findElement(By.linkText(data));
        Actions actions = new Actions(driver);
        actions.moveToElement(category).build().perform();
        category.click();
        ExtentTestManager.log("Clicked on news category",LOGGER);
    }


}
