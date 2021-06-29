package com.cnn.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage {

    @FindBy(id = "registration-email-input")
    private WebElement emailField;

    @FindBy(id = "registration-password-input")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@aria-label='Show Password']")
    private WebElement showPasswordButton;

    @FindBy(id = "registration-zip-input")
    private WebElement zipcodeField;

    @FindBy(xpath = "//button[@class='user-account-shared__button user-account-registration__form-button']")
    private WebElement createAccountButton;

    public void typeOnEmailField(String data){
        emailField.sendKeys(data);
    }

    public void typeOnPasswordField(String data){
        passwordField.sendKeys(data);
    }

    public void typeOnZipcodeField(String data){
        zipcodeField.sendKeys(data);
    }

    public void clickOnCreateAccountButton(){
        createAccountButton.click();
    }
}
