package com.cnn.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage {

    @FindBy(id = "userLogout-link")
    private WebElement logOutButton;

    @FindBy(xpath = "//a[@aria-label='CNN']")
    private WebElement cnnLogo;

    @FindBy(xpath = "(//span[@class='cd__headline-text vid-left-enabled'])[19]")
    private WebElement headLine1;

    @FindBy(xpath = "//h1[@class='pg-headline']")
    private WebElement headLineTile;

    @FindBy(id = "header-search-bar")
    private WebElement searchField;

    @FindBy(xpath = "//button[@class='sc-jhAzac sc-gisBJw hioqcg']")
    private WebElement searchIcon;

    @FindBy(xpath = "//button[@aria-label='Search']")
    private WebElement searchButton;

    public void clickONLogOutButton(){
        logOutButton.click();
    }

    public void clickOnNewsHeadline(){
        headLine1.click();

    }

    public void logoDisplay(){
        Assert.assertTrue(cnnLogo.isDisplayed(),"Logo is not displayed");
    }

    public void clickOnSearchIcon(){
        searchIcon.click();
    }

    public void typeOnSearchBar(String data){
        searchField.sendKeys(data);
    }

    public void clickOnSearchButton(){
        searchButton.click();
    }





}
