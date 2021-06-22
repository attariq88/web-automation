package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    @FindBy(linkText = "Sign in")
    private WebElement signInButton;

    public void clickOnSignButton(){
        signInButton.click();
    }
}
