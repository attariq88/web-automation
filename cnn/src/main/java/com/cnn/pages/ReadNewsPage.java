package com.cnn.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ReadNewsPage {

    @FindBy(xpath = "//h1[@class='pg-headline']")
    private WebElement pageHeadline;

    @FindBy(xpath = "//div[@class='cnn-search__results-count']")
    private WebElement searchResult;

    public void verifySearchResult(String data){
        WebElement result = searchResult;

        String log = searchResult.getText();
        Assert.assertTrue(log.contains(data),"Result didn't match");
    }

}
