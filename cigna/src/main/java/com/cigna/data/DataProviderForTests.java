package com.cigna.data;

import org.testng.annotations.DataProvider;

public class DataProviderForTests {

    @DataProvider(name = "getDataForRegistrationTest")
    public Object[][] getDataForRegistrationTest(){
        return new Object[][]{
                {"Peoplentech","Tariq","October","17","1981","12190"}
        };
    }


}
