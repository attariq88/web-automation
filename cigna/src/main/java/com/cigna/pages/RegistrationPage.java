package com.cigna.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage {

    @FindBy(id = "firstname")
    private WebElement firstnameField;

    @FindBy(id = "lastname")
    private WebElement lastnameField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement nextButton;

    public void typeOnFirstnameField(String data){
        firstnameField.sendKeys(data);
    }

    public void typeOnLastnameField(String data){
        lastnameField.sendKeys(data);
    }

    public void clickOnNextButton(){
        nextButton.click();
    }
}
