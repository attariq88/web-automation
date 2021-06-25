package com.amazon.tests;

import com.amazon.base.TestBase;
import com.amazon.pages.CreateAccountPage;
import com.amazon.pages.HomePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

public class CheckOutTest extends TestBase {

    private static final Logger LOGGER = Logger.getLogger(CheckOutTest.class);

    private HomePage homePage;
    private CreateAccountPage createAccountPage;

    @BeforeMethod
    private void setPOM(){
        homePage = PageFactory.initElements(driver, HomePage.class);
        createAccountPage = PageFactory.initElements(driver,CreateAccountPage.class);
    }
}
