package com.amazon.pages;

import com.amazon.base.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class HomePage extends TestBase{


    @FindBy(id = "nav-logo-sprites")
    private WebElement amazonLogo;

    @FindBy(linkText = "Sign in")
    private WebElement signInButton;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchTextBox;

    @FindBy(id = "nav-iss-attach")
    private WebElement autoSuggestion;

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchButton;

    @FindBy(xpath = "//h1[@class='a-size-base s-desktop-toolbar a-text-normal']")
    private WebElement searchResult;

    @FindBy(xpath = "(//span[@class='a-truncate-cut'])[1]")
    private WebElement selectProductCategoryAfterSearch;

    @FindBy(xpath = "(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")
    private WebElement selectProductFromSearchList;

    @FindBy(id = "searchDropdownBox")
    private WebElement categoryDropDown;

    @FindBy(id = "nav-link-accountList")
    private WebElement accountList;

    @FindBy(id = "nav-hamburger-menu")
    private WebElement hamburgerMenu;

    @FindBy(linkText = "Movers & Shakers")
    private WebElement moversAndShakersOption;

    @FindBy(linkText = "Prime Video")
    private WebElement primeVideoOption;

    @FindBy(linkText = "Rent or Buy")
    private WebElement rentOrButOption;


    @FindBy(linkText = "Sign Out")
    private WebElement signOutOption;

    @FindBy(id = "nav-cart")
    private WebElement shoppingCartButton;


    public void amazonLogoIsDisplayed(){

        Assert.assertTrue(amazonLogo.isDisplayed(),"Logo is not displayed");
    }

    public void clickOnSignButton(){
        signInButton.click();
    }

    public void typeOnSearchBar(){
        searchTextBox.sendKeys("Nike");
    }

    public void typeOnSearchBar(String text){
        searchTextBox.sendKeys(text);
    }

    public void clickOnSearchButton(){
        searchButton.click();
    }

    public void productCategoryDropDown(String data){

        Select select = new Select(categoryDropDown);
        select.selectByVisibleText(data);
        searchButton.click();
    }

    public void verifySearchResult(String data){
        WebElement result = searchResult;

        String log = result.getText();
        Assert.assertTrue(log.contains(data),"log didn't match");
    }

    public void verifyAutosuggestion(){
        autoSuggestion.isDisplayed();

    }

    public void selectProductCategoryAfterSearch(){
        selectProductCategoryAfterSearch.click();
    }

    public void navigateProductFromSearchResult(){
        selectProductFromSearchList.click();
    }
    public void selectProductsFromHamburgerMenu(){
        hamburgerMenu.click();
        moversAndShakersOption.click();

    }

    public void selectProductsFromHamburgerMenu1(){
        hamburgerMenu.click();
        sleepFor(2);
        primeVideoOption.click();
        sleepFor(2);
        rentOrButOption.click();

    }

    public void clickOnShoppingCartButton(){
        shoppingCartButton.click();
    }

    public void signOutFromAccount(){
        Actions actions = new Actions(driver);
        actions.moveToElement(accountList).build().perform();
        sleepFor(2);
        signOutOption.click();
    }





}
