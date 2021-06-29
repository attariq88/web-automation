package com.cigna.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(id = "loginbutton")
    private WebElement loginButton;

    @FindBy(id = "register")
    private WebElement registerButton;

    public void clickOnLoginButton(){
        loginButton.click();
    }

    public void clickOnRegisterButton(){
        registerButton.click();
    }
}
