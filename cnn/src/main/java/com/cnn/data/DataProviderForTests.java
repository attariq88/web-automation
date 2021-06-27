package com.cnn.data;

import org.testng.annotations.DataProvider;

public class DataProviderForTests {

    @DataProvider(name = "getDataForSignUpTest")
    public Object[][] getDataForSignUpTest(){
        return new Object[][]{
                {""}
        };
    }
}
