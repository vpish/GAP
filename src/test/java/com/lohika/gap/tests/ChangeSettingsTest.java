package com.lohika.gap.tests;

import com.lohika.gap.TestData.IncorrectValues;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeSettingsTest extends BaseTest {

    // ---- profile ----
    @Test (groups = {"positive"})
    public void testChangeUserProfile(){
        homePage.openProfilePage();
        profilePage.udateProfile("Vova","It's me", "www.skype.com", "Skype","Lviv");
        Assert.assertEquals(homePage.getMessageText(),"Profile updated successfully — view your profile.","Profile wasn't updated");
    }

    // --- password ---
    @Test (groups = {"negative"}, dataProvider = "IncorrectPasswords", dataProviderClass = IncorrectValues.class)
    public void testChangePassword_failed(String oldPassword, String newPassword, String errorText){
        homePage.openAccountPage();
        accountPage.changePassword(oldPassword, newPassword);
        Assert.assertEquals(homePage.getMessageText(),errorText,"Text message doesn't match with expected text");
    }

    // ---- emails ---
    @Test (groups = {"positive"})
    public void testAddNewEmail(){
        homePage.openEmailsPage();
        emailSettingsPage.addNewEmail("new_mail@gmail.com");
        Assert.assertEquals(homePage.getMessageText(),"We sent a verification email to new_mail@gmail.com. Please follow the instructions in it.", "Email wasn't added. ");
    }

    @Test (groups = {"negative"})
    public void testAddNewEmail_AlreadyExist(){
        homePage.openEmailsPage();
        emailSettingsPage.addNewEmail("old_mail@gmail.com");
        Assert.assertEquals(homePage.getMessageText(),"Error adding old_mail@gmail.com: email is already in use");
    }

    @Test (groups = {"positive"}, dependsOnMethods = {"testAddNewEmail"})
    public void testRemoveEmail(){
        homePage.openEmailsPage();
        emailSettingsPage.removeAddedEmail();
        Assert.assertEquals(homePage.getMessageText(),"Removed email new_mail@gmail.com from your account.", "Email wasn't removed. ");
    }

    @Test (groups = {"positive"})
    public void testChangeEmailPreferences(){
        homePage.openEmailsPage();
        emailSettingsPage.changeEmailPreferences();
        Assert.assertEquals(homePage.getMessageText(),"Successfully updated your email preferences.", "Email preferences wasn't changed. ");
    }

    //--- test for skipping ---
    @Test (groups = {"positive"})
    public void testOpenGooglePage(){
        driver.get("https://www.google.com");
        Assert.assertEquals(driver.getTitle(),"Google","Google page is not opened");
    }

}

