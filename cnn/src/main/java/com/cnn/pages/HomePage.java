package com.cnn.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(id = "userLogout-link")
    private WebElement logOutButton;

    public void clickONLogOutButton(){
        logOutButton.click();
    }
}
