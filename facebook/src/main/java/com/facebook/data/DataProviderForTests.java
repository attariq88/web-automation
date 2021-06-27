package com.facebook.data;

import org.testng.annotations.DataProvider;

public class DataProviderForTests {

    @DataProvider(name = "getDataForSignUpTest")
    public Object[][] getDataForSignUpTest(){
        return new Object[][]{
                {"Peoplentech","Tariq","pntbootcamp2021@gmail.com","pntbc2021"}
        };
    }



}
