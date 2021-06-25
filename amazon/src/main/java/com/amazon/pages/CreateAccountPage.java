package com.amazon.pages;

import com.amazon.base.report.ExtentTestManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class CreateAccountPage {

    private static Logger LOGGER = Logger.getLogger(CreateAccountPage.class);

    @FindBy(id = "ap_customer_name")
    private WebElement nameField;

    @FindBy(id = "ap_email")
    private WebElement mobileNumberOrEmailField;

    @FindBy(id = "ap_password")
    private WebElement passwordField;

    @FindBy(id = "ap_password_check")
    private WebElement reEnterPasswordField;

    @FindBy(xpath = "//label[@for='ap_customer_name']")
    private WebElement nameLabel;

    @FindBy(xpath = "//label[@for='ap_email']")
    private WebElement mobileNumberOrEmailLabel;

    @FindBy(xpath = "//label[@for='ap_password']")
    private WebElement passwordLabel;

    @FindBy(xpath = "//label[@for='ap_password_check']")
    private WebElement reEnterPasswordLabel;

    @FindBy(id = "continue")
    private WebElement verifyEmailButton;

    @FindBy(linkText = "Solve Puzzle")
    private WebElement solvePuzzleButton;

//    @FindBy(xpath = "//input[@class='a-input-text a-span12 cvf-widget-input cvf-widget-input-code']")
//    private WebElement otpField;
//
//    @FindBy(id = "cvf-submit-otp-button-announce")
//    private WebElement otpVerify;


    public void typeInNameField(String data){
        nameField.sendKeys(data);
    }

    public void typeInMobileNumberOrEmailField(String data){
        mobileNumberOrEmailField.sendKeys(data);
    }

    public void typeInPasswordFiled(String data){
        passwordField.sendKeys(data);
    }

    public void typeInReEnterField(String data){
        reEnterPasswordField.sendKeys(data);
    }

    public void validateTheFieldLabelsAreDisplayed(){
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(nameLabel.getText(),"Your name");
        ExtentTestManager.log("Your name labels is displayed",LOGGER);

        softAssert.assertEquals(mobileNumberOrEmailLabel.getText(),"Mobile number or email");
        ExtentTestManager.log("Mobile number or email labels is displayed",LOGGER);

        softAssert.assertEquals(passwordLabel.getText(),"Password");
        ExtentTestManager.log("Password label is displayed",LOGGER);

        softAssert.assertEquals(reEnterPasswordLabel.getText(),"Re-enter password");
        ExtentTestManager.log("Re-enter password is displayed",LOGGER);

        softAssert.assertAll();

    }

    public void clickOnVerifyEmailButton(){
        verifyEmailButton.click();
    }

    public void clickOnSolePuzzleButton(){
        solvePuzzleButton.click();
    }





}
