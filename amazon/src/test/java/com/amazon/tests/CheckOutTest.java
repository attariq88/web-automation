package com.amazon.tests;

import com.amazon.base.TestBase;
import com.amazon.base.report.ExtentTestManager;
import com.amazon.data.DataProviderForTests;
import com.amazon.pages.CartPage;
import com.amazon.pages.CreateAccountPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.SignInPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckOutTest extends TestBase {

    private static final Logger LOGGER = Logger.getLogger(CheckOutTest.class);

    private HomePage homePage;
    private SignInPage signInPage;
    private CartPage cartPage;

    @BeforeMethod
    private void setPOM(){
        homePage = PageFactory.initElements(driver, HomePage.class);
        signInPage = PageFactory.initElements(driver,SignInPage.class);
        cartPage = PageFactory.initElements(driver,CartPage.class);
    }

    @Test(enabled = false,dataProviderClass = DataProviderForTests.class,dataProvider = "getDataForCheckOutTest")
    public void validateUserBeignAbleToCheckOutFromAddToCartButton(String email, String password, String booksName){

        validateUrlWithExpected("https://www.amazon.com/");
        homePage.amazonLogoIsDisplayed();
        ExtentTestManager.log("Logo display is validated",LOGGER);

        homePage.clickOnSignButton();
        ExtentTestManager.log("Sign in button clicked.",LOGGER);
        sleepFor(2);

        signInPage.typeInMobileNumberOrEmailField(email);
        ExtentTestManager.log("Email field typed in successfully",LOGGER);
        sleepFor(2);

        signInPage.clickOnContinueButton();
        ExtentTestManager.log("Continue button clicked",LOGGER);
        sleepFor(2);

        signInPage.typeInPasswordFiled(password);
        ExtentTestManager.log("Password field typed in successfully",LOGGER);
        sleepFor(2);

        signInPage.clickOnSignInButton();
        ExtentTestManager.log("Sign in button clicked",LOGGER);
        sleepFor(5);

        homePage.typeOnSearchBar(booksName);
        ExtentTestManager.log(booksName + " typed on the search bar.",LOGGER);
        sleepFor(2);

        homePage.clickOnSearchButton();
        ExtentTestManager.log("Clicked on the search button.",LOGGER);

        homePage.verifySearchResult(booksName);
        ExtentTestManager.log("Search result displayed",LOGGER);
        sleepFor(2);

        homePage.navigateProductFromSearchResult();
        ExtentTestManager.log("Item selected from search result list",LOGGER);
        sleepFor(2);

        cartPage.clickOnAddToCartButton();
        ExtentTestManager.log("Clicked on 'Add to Cart' button",LOGGER);
        sleepFor(2);

        cartPage.proceedToCheckOutButtonInAddToCart();
        ExtentTestManager.log("Clicked on 'Proceed to check out' button",LOGGER);

        signInPage.typeInPasswordFiled(password);
        ExtentTestManager.log("Password field typed in successfully",LOGGER);
        sleepFor(2);

        signInPage.clickOnSignInButton();
        ExtentTestManager.log("Sign in button clicked",LOGGER);
        sleepFor(2);

    }

    @Test(enabled = true,dataProviderClass = DataProviderForTests.class,dataProvider = "getDataForCheckOutTest")
    public void validateUserBeignAbleToCheckOutFromShoppingCartIcon(String email, String password, String booksName){
        validateUrlWithExpected("https://www.amazon.com/");
        homePage.amazonLogoIsDisplayed();

        homePage.clickOnSignButton();
        ExtentTestManager.log("Sign in button clicked.",LOGGER);
        sleepFor(2);

        signInPage.typeInMobileNumberOrEmailField(email);
        ExtentTestManager.log("Email field typed in successfully",LOGGER);
        sleepFor(2);

        signInPage.clickOnContinueButton();
        ExtentTestManager.log("Continue button clicked",LOGGER);
        sleepFor(2);

        signInPage.typeInPasswordFiled(password);
        ExtentTestManager.log("Password field typed in successfully",LOGGER);
        sleepFor(2);

        signInPage.clickOnSignInButton();
        ExtentTestManager.log("Sign in button clicked",LOGGER);
        sleepFor(5);

        homePage.clickOnShoppingCartButton();
        ExtentTestManager.log("Clicked on shopping cart option",LOGGER);
        sleepFor(2);

        cartPage.proceedToCheckoutButtonInShoppingCart();
        ExtentTestManager.log("Clicked on 'Proceed to check out' button",LOGGER);
        sleepFor(2);

        signInPage.typeInPasswordFiled(password);
        ExtentTestManager.log("Password field typed in successfully",LOGGER);
        sleepFor(2);

        signInPage.clickOnSignInButton();
        ExtentTestManager.log("Sign in button clicked",LOGGER);
        sleepFor(2);

    }
}
