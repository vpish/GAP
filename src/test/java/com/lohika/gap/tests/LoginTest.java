package com.lohika.gap.tests;

import com.lohika.gap.core.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testSignout(){
        homePage.signout();
        Wait.seconds(1);
        Assert.assertEquals(driver.getTitle(),"How people build software · GitHub","User is not signed out");
    }

    @Test (dependsOnMethods = {"testSignout"})
    public void testSigninWithIncorrectCredentials (){
        loginPage.goToLoginMode();
        loginPage.login("qqq","qqqq");
        Assert.assertEquals(loginPage.getErrorText(),"Incorrect username or password.");
    }

    @Test (dependsOnMethods = {"testSigninWithIncorrectCredentials"})
    public void testSignin(){
        loginPage.login(USER_NAME,USER_PASS);
        Wait.seconds(1);
        Assert.assertEquals(driver.getTitle(),"GitHub","User is not signed in");
    }




}

