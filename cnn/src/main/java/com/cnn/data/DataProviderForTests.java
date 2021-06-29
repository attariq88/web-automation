package com.cnn.data;

import org.testng.annotations.DataProvider;

public class DataProviderForTests {

    @DataProvider(name = "getDataForSignUpTest")
    public Object[][] getDataForSignUpTest(){
        return new Object[][]{
                {"pntbootcamp2021@gmail.com","Pntbc@2021","12190"}
        };
    }

    @DataProvider(name = "getDataForLoginTest")
    public Object[][] getDataForLoginTest(){
        return new Object[][]{
                {"pntbootcamp2021@gmail.com","Pntbc@2021"}
        };
    }

    @DataProvider(name = "getDataForClickOnNavigationTests")
    public Object[][] getDataForClickOnNavigationTests(){
        return new Object[][]{
                {"Sports"}
        };
    }

    @DataProvider(name = "getDataForNewsSearchTest")
    public Object[][] getDataForNewsSearchTest(){
        return new Object[][]{
                {"Euro championship"}
        };
    }
}
