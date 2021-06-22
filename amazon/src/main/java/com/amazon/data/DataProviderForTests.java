package com.amazon.data;

import org.testng.annotations.DataProvider;

public class DataProviderForTests {

    @DataProvider(name = "getDataForLoginTest")
    public Object[][] getDataForLoginTest(){
        return new Object[][]{
                {"PeopleNTech Tareq","pntbootcamp2021@gmail.com","pntbc2021"}
        };
    }
}
