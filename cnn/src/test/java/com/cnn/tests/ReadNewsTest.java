package com.cnn.tests;

import com.amazon.base.TestBase;
import com.cnn.pages.HomePage;
import com.cnn.pages.LandingPage;
import com.cnn.pages.LoginPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

public class ReadNewsTest extends TestBase {

    private static final Logger LOGGER = Logger.getLogger(ReadNewsTest.class);

    private HomePage homePage;

    @BeforeMethod
    private void setPOM() {
        homePage = PageFactory.initElements(driver,HomePage.class);

    }
}
