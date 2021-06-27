package com.cnn.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {

    @FindBy(id = "account-icon-button")
    private WebElement userAccountButton;

    public void clickOnUserAccountButton(){
        userAccountButton.click();
    }
}
