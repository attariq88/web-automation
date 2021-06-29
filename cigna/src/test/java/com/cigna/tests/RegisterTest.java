package com.cigna.tests;

import com.amazon.base.TestBase;
import com.cigna.pages.HomePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest extends TestBase {

    private static final Logger LOGGER = Logger.getLogger(RegisterTest.class);

    private HomePage homePage;

    @BeforeMethod
    private void setPOM(){
        homePage = PageFactory.initElements(driver,HomePage.class);

    }

    @Test
    public void validateUserBeingAbleToRegister(){

    }
}
