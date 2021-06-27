package com.facebook.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountInfoPage {

    @FindBy(xpath = "//div[@aria-label='Continue']")
    private WebElement continueButton;

    public void clickOnContinueButton(){
        continueButton.click();
    }

}
