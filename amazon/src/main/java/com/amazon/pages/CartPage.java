package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage {

    @FindBy(id = "add-to-cart-button")
    private WebElement addToCartButton;

    @FindBy(id = "hlb-ptc-btn-native")
    private WebElement proceedToCheckOutButton;



    public void clickOnAddToCartButton(){
        addToCartButton.click();
    }

    public void clickOnProceedToCheckOutButton(){
        proceedToCheckOutButton.click();
    }
}
