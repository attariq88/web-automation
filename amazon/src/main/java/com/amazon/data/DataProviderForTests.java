package com.amazon.data;

import org.testng.annotations.DataProvider;

public class DataProviderForTests {

    @DataProvider(name = "getDataForCreateAccountTest")
    public Object[][] getDataForCreateAccountTest(){
        return new Object[][]{
                {"PeopleNTech Tareq","pntbootcamp2021@gmail.com","pntbc2021"}
        };
    }

    @DataProvider(name = "getDataForSearchtest")
    public Object[][] getDataForSearchtest(){
        return new Object[][]{{"Marvel Books"}};
    }

    @DataProvider(name = "getDataForBrowseProductsTest")
    public Object[][] getDataForBrowseProductsTest(){
        return new Object[][]{{"Prime"}};
    }

    @DataProvider(name = "getDataForSearchDropDownTest")
    public Object[][] getDataForSearchDropDownTest(){
        return new Object[][]{{"Baby"}};
    }

    @DataProvider(name = "getDataForLoginTest")
    public Object[][] getDataForLoginTest(){
        return new Object[][]{{"tarik88sep@gmail.com","020619@Tariq"}};
    }

    @DataProvider(name = "getDataForCheckOutTest")
    public Object[][] getDataForCheckOutTest(){
        return new Object[][]{{"tarik88sep@gmail.com","020619@Tariq","Marvel Books"}};
    }
}
