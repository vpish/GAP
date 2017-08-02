package com.lohika.gap.TestData;

import org.testng.annotations.DataProvider;

public class CorrectValues {

    @DataProvider(name = "RepositoryDescriptions")
    public Object[][] descriptions() {
        return new Object[][]{
                {"Test test", "https://www.skype.com", "Test test"},
                {"Test", "", "Test"},
                {"", "", "No description, website, or topics provided."},
        };
    }

}
