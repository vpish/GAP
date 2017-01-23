package com.lohika.gap.tests;

import com.lohika.gap.core.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeSettingsTest extends BaseTest {

    @Test
    public void testChangeUserProfile(){
        homePage.openProfilePage();
        profilePage.udateProfile("Vova","It's me", "www.skype.com", "Skype","Lviv");
        Wait.seconds(2);
        Assert.assertEquals(homePage.getMessageText(),"Profile updated successfully — view your profile.","Profile wasn't updated");
    }

    @Test
    public void testChangePassword_WrongOldPassword(){
        homePage.openAccountPage();
        accountPage.changePassword("qwerty","1q2w3e4r");
        Wait.seconds(2);
        Assert.assertEquals(homePage.getMessageText(),"Old password isn't valid");
    }

    @Test
    public void testChangePassword_WrongNewPassword(){
        homePage.openAccountPage();
        accountPage.changePassword(USER_PASS,"1q");
        Wait.seconds(2);
        Assert.assertEquals(homePage.getMessageText(),"Password is too short (minimum is 7 characters)");
    }

    @Test
    public void testChangeEmailSettings(){
        homePage.openEmailsPage();
        emailSettingsPage.addNewEmail("new_mail@gmail.com");
        Wait.seconds(2);
        //Assert.assertEquals(homePage.getMessageText(),"Repository creation failed.","Repository doesn't exist.");
    }

}

