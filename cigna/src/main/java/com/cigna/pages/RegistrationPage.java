package com.cigna.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {

    @FindBy(id = "firstname")
    private WebElement firstnameField;

    @FindBy(id = "lastname")
    private WebElement lastnameField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement nextButton;

    @FindBy(id = "month")
    private WebElement birthMonth;

    @FindBy(id = "day")
    private WebElement birthDate;

    @FindBy(id = "year")
    private WebElement birthYear;

    @FindBy(id = "zipcode")
    private WebElement zipcodeField;

    @FindBy(xpath = "(//label[@class='small-text pointer col-11'])[5]")
    private WebElement selectPlan;

    public void typeOnFirstnameField(String data){
        firstnameField.sendKeys(data);
    }

    public void typeOnLastnameField(String data){
        lastnameField.sendKeys(data);
    }

    public void clickOnNextButton(){
        nextButton.click();
    }

    public void selectBirthMonth(String data){

        WebElement monthDropdown = birthMonth;
        Select select = new Select(monthDropdown);
        select.selectByVisibleText(data);
    }

    public void typeOnBirthDayField(String data){
        birthDate.sendKeys(data);
    }

    public void typeOnBirthYearField(String data){
        birthYear.sendKeys(data);
    }

    public void typeOnZipcodeField(String data){
        zipcodeField.sendKeys(data);
    }

    public void selectProfilePlan(){
        selectPlan.click();
    }
}
