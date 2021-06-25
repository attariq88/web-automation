package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage {

    @FindBy(id = "ap_email")
    private WebElement emailOrPhoneNumberField;

    @FindBy(id = "createAccountSubmit")
    private WebElement createAccountButton;

    @FindBy(id = "continue")
    private  WebElement continueButton;

    @FindBy(id = "ap_password")
    private WebElement passwordField;

    @FindBy(id = "signInSubmit")
    private WebElement signInButton;

    public void clickOnCreateAccountButton(){
        createAccountButton.click();
    }

    public void typeInMobileNumberOrEmailField(String data){
        emailOrPhoneNumberField.sendKeys(data);
    }

    public void clickOnContinueButton(){
        continueButton.click();
    }

    public void typeInPasswordFiled(String data){
        passwordField.sendKeys(data);
    }

    public void clickOnSignInButton(){
        signInButton.click();
    }
}
