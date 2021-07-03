package com.cigna.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage {

    @FindBy(linkText = "Log in to myCigna")
    private WebElement loginButton;

    @FindBy(xpath = "//a[@class='navbar-brand']")
    private WebElement cignaLogo;

    public void logoDisplayed(){
        Assert.assertTrue(cignaLogo.isDisplayed(),"Logo is not displayed");
    }

    public void clickOnLoginButton(){
        loginButton.click();
    }

}
