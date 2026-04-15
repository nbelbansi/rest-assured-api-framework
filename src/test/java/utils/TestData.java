package utils;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "userData")
    public static Object[][] getUserData() {

        return new Object[][]{
                {"Neelesh", "QA Lead"},
                {"Rahul", "SDET"},
                {"Amit", "Manager"}
        };
    }
}