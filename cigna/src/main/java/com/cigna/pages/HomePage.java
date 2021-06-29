package com.cigna.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(linkText = "Log in to myCigna")
    private WebElement loginButton;

    public void clickOnLoginButton(){
        loginButton.click();
    }
}
