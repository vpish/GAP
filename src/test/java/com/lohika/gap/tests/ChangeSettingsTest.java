package com.lohika.gap.tests;

import com.lohika.gap.core.Wait;
import org.testng.annotations.Test;

public class ChangeSettingsTest extends BaseTest {

    @Test
    public void testChangeUserProfile(){
        homePage.openProfilePage();
        //newRepositoryPage.createNewRepository("ABC","Creating already existing repository" );
        Wait.seconds(5);
        //Assert.assertEquals(homePage.getMessageText(),"Repository creation failed.","Repository doesn't exist.");
    }

    @Test
    public void testChangeAccountsSettings(){
        homePage.openAccountPage();
        //newRepositoryPage.createNewRepository("ABC","Creating already existing repository" );
        Wait.seconds(5);
        //Assert.assertEquals(homePage.getMessageText(),"Repository creation failed.","Repository doesn't exist.");
    }

    @Test
    public void testChangeEmailSettings(){
        homePage.openEmailsPage();
        //newRepositoryPage.createNewRepository("ABC","Creating already existing repository" );
        Wait.seconds(5);
        //Assert.assertEquals(homePage.getMessageText(),"Repository creation failed.","Repository doesn't exist.");
    }

}

