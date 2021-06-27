package com.cnn.tests;

import com.amazon.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ClickOnNavigationTabsTest extends TestBase {


    @Test
    public void validateUserBeingAbleToChooseNewsCategoryFromNavigationTab(String data){

        WebElement category = driver.findElement(By.linkText(data));
        Actions actions = new Actions(driver);
        actions.moveToElement(category).build().perform();
        category.click();
    }


}
