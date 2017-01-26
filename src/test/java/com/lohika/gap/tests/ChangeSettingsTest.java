package com.lohika.gap.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeSettingsTest extends BaseTest {

    @Test
    public void testChangeUserProfile(){
        homePage.openProfilePage();
        profilePage.udateProfile("Vova","It's me", "www.skype.com", "Skype","Lviv");
        Assert.assertEquals(homePage.getMessageText(),"Profile updated successfully — view your profile.","Profile wasn't updated");
    }

    @Test
    public void testChangePassword_WrongOldPassword(){
        homePage.openAccountPage();
        accountPage.changePassword("qwerty","1q2w3e4r");
        Assert.assertEquals(homePage.getMessageText(),"Old password isn't valid");
    }

    @Test
    public void testChangePassword_WrongNewPassword(){
        homePage.openAccountPage();
        accountPage.changePassword(USER_PASS,"1q");
        Assert.assertEquals(homePage.getMessageText(),"Password is too short (minimum is 7 characters)");
    }

    @Test
    public void testAddExistingEmail(){
        homePage.openEmailsPage();
        emailSettingsPage.addNewEmail("old_mail@gmail.com");
        Assert.assertEquals(homePage.getMessageText(),"Error adding old_mail@gmail.com: email is already in use");
    }

    @Test
    public void testAddNewEmail(){
        homePage.openEmailsPage();
        emailSettingsPage.addNewEmail("new_mail@gmail.com");
        Assert.assertEquals(homePage.getMessageText(),"We sent a verification email to new_mail@gmail.com. Please follow the instructions in it.", "Email wasn't added. ");
    }

    @Test (dependsOnMethods = {"testAddNewEmail"})
    public void testRemoveEmail(){
        homePage.openEmailsPage();
        emailSettingsPage.removeAddedEmail();
        Assert.assertEquals(homePage.getMessageText(),"Removed email new_mail@gmail.com from your account.", "Email wasn't removed. ");
    }

    @Test
    public void testChangeEmailPreferences(){
        homePage.openEmailsPage();
        emailSettingsPage.changeEmailPreferences();
        Assert.assertEquals(homePage.getMessageText(),"Successfully updated your email preferences.", "Email preferences wasn't changed. ");
    }

}

