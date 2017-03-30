package com.lohika.gap.TestData;

import org.testng.annotations.DataProvider;

/**
 * Created by vova on 29.03.2017.
 */
public class IncorrectValues  {

    @DataProvider(name = "IncorrectCredentials")
    public Object [][] credentials(){
        return new Object[][]{
                {"vvpp03", "12abcd","Incorrect username or password." },
                {"abcd", "abcd","Incorrect username or password." },
                {"abcd", "","Incorrect username or password." },
                {"", "abcd","Incorrect username or password." },
                {"", "","Incorrect username or password." },
        };
    }

    @DataProvider(name = "IncorrectPasswords")
    public Object [][] passwords(){
        return new Object[][]{
                {"qwerty", "1q2w3e4r","Old password isn't valid" },
                {"12qwaszx", "1q","Password is too short (minimum is 7 characters)" },
                {"1q", "1q","Password is too short (minimum is 7 characters) and Old password isn't valid" },
        };
    }

    @DataProvider(name = "IncorrectRepositoryName")
    public Object [][] repositoryNames(){
        return new Object[][]{
                {"ABC", "Creating already existing repository","Repository creation failed." },
                {"", "Repository without name","Repository creation failed." },
        };
    }

}
