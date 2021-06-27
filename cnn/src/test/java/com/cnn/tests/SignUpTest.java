package com.cnn.tests;

import com.amazon.base.TestBase;
import com.amazon.base.report.ExtentTestManager;
import com.cnn.pages.LandingPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sun.java2d.pipe.hw.ExtendedBufferCapabilities;

public class SignUpTest extends TestBase {

    private static final Logger LOGGER = Logger.getLogger(SignUpTest.class);

    private LandingPage landingPage;

    @BeforeMethod
    private void setPOM(){
        landingPage = PageFactory.initElements(driver,LandingPage.class);
    }

    @Test
    public void validateUserBeingAbleToSignUp(){

        validateUrlWithExpected("https://www.cnn.com/");

        landingPage.clickOnUserAccountButton();
        ExtentTestManager.log("CLicked on 'user account' button",LOGGER);

    }

}
