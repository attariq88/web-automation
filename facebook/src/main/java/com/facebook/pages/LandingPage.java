package com.facebook.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class LandingPage {

    @FindBy(id = "u_0_2_Kw")
    private WebElement createNewAccountButton;

    @FindBy(xpath = "//input[@aria-label='First name']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@aria-label='Last name']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@aria-label='Mobile number or email']")
    private WebElement numberOrEmailField;

    @FindBy(id = "password_step_input")
    private WebElement passwordField;

    @FindBy(id = "month")
    private WebElement birthMonthDropdown;

    @FindBy(id = "day")
    private WebElement birthDateDropdown;

    @FindBy(id = "year")
    private WebElement birthYearDropdown;

    @FindBy(xpath = "(//span[@class='_5k_2 _5dba'])[2]")
    private WebElement maleGender;

    @FindBy(id = "u_w_s_1D")
    private WebElement signUpButton;

    public void clickOnCreateNewAccountButton(){
        createNewAccountButton.click();
    }

    public void typeOnFirstNameField(String data){
        firstNameField.sendKeys(data);
    }

    public void typeOnLastNameField(String data){
        lastNameField.sendKeys(data);
    }

    public void typeOnEmailField(String data){
        numberOrEmailField.sendKeys(data);
    }

    public void typeOnPasswordField(String data){
        passwordField.sendKeys(data);
    }

    public void selectBirthMonth(String data){
        Select select = new Select(birthMonthDropdown);
        select.selectByVisibleText(data);
    }

    public void selectBirthDate(String data){
        Select select = new Select(birthDateDropdown);
        select.selectByVisibleText(data);
    }

    public void selectBirthYear(String data){
        Select select = new Select(birthYearDropdown);
        select.selectByVisibleText(data);
    }

    public void selectGender(){
        maleGender.click();
    }

    public void clickOnSignUpButton(){
        signUpButton.click();
    }
}
