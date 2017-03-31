package com.lohika.gap.tests;

import com.lohika.gap.TestData.IncorrectValues;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test (groups = {"positive"})
    public void testSignout(){
        homePage.signout();
        loginPage.goToLoginMode();
        Assert.assertTrue(loginPage.isLoginPageOpened(),"User is not signed out");
    }

    @Test (groups = {"negative"}, dependsOnMethods = {"testSignout"}, dataProvider = "IncorrectCredentials", dataProviderClass = IncorrectValues.class )
    public void testSignin_IncorrectCredentials(String userName, String password, String errorText){
        loginPage.login(userName,password);
        Assert.assertEquals(loginPage.getErrorText(),errorText);
    }

    @Parameters({ "userName", "userPassword" })
    @Test (groups = {"positive"}, dependsOnMethods = {"testSignin_IncorrectCredentials"})
    public void testSignin(String user_name, String user_password){
        loginPage.login(user_name, user_password);
        Assert.assertEquals(homePage.getNameFromProfile(),user_name,"User is not signed in");
    }

}

