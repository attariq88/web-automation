package com.facebook.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class LandingPage {

    @FindBy(xpath = "//img[@class='fb_logo _8ilh img']")
    private WebElement facebookLogo;

    @FindBy(xpath = "//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")
    private WebElement createNewAccountButton;


    public void facebookLogoIsDisplayed() {
        Assert.assertTrue(facebookLogo.isDisplayed(), "Logo is not displayed");

    }

    public void clickOnCreateNewAccountButton() {
        createNewAccountButton.click();
    }
}


