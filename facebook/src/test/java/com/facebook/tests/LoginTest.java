package com.facebook.tests;

import com.amazon.base.TestBase;
import com.facebook.pages.AccountInfoPage;
import com.facebook.pages.LandingPage;
import com.facebook.pages.SignUpPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

public class LoginTest extends TestBase {

    private static final Logger LOGGER = Logger.getLogger(LoginTest.class);

    private LandingPage landingPage;
    private SignUpPage signUpPage;

    @BeforeMethod
    private void setPOM(){
        landingPage = PageFactory.initElements(driver,LandingPage.class);
        signUpPage = PageFactory.initElements(driver,SignUpPage.class);
    }
}
