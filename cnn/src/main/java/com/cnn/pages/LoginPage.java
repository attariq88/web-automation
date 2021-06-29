package com.cnn.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(id = "login-registration-link")
    private WebElement signUpButton;

    @FindBy(xpath = "//input[@aria-label='Email address']")
    private WebElement emailInputField;

    @FindBy(xpath = "//input[@aria-label='Password']")
    private WebElement passwordInputField;

    @FindBy(id = "login-form-button")
    private WebElement loginButton;

    public void clickOnSignUpButton(){
        signUpButton.click();
    }

    public void typeOnEmailField(String data){
        emailInputField.sendKeys(data);
    }

    public void typeOnPasswordField(String data){
        passwordInputField.sendKeys(data);
    }

    public void clickOnLoginButton(){
        loginButton.click();
    }
}
