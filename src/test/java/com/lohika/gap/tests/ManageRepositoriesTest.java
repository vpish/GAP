package com.lohika.gap.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ManageRepositoriesTest extends BaseTest {

    @Test
    public void testCreateNewRepository(){
        homePage.openNewRepositoryPage();
        newRepositoryPage.createNewRepository("ABC01","new test repository" );
        Assert.assertEquals(driver.getTitle(),"vvpp03/ABC01","ABC repository was not created");
    }

    @Test
    public void testCreateExistingRepository(){
        homePage.openNewRepositoryPage();
        newRepositoryPage.createNewRepository("ABC","Creating already existing repository" );
        Assert.assertEquals(homePage.getMessageText(),"Repository creation failed.","Repository doesn't exist.");
    }

    @Test
    public void testCreateNamelessRepository(){
        homePage.openNewRepositoryPage();
        newRepositoryPage.createNewRepository("","Repository without name" );
        Assert.assertEquals(homePage.getMessageText(),"Repository creation failed.");
    }

    @Test (dependsOnMethods = {"testCreateNewRepository"})
    public void testRemoveRepository(){
        homePage.selectRepository("ABC01");
        repositoryPage.openRepositorySettings();
        repositorySettingsPage.removeCurrentRepository();
        Assert.assertEquals(homePage.getMessageText(),"Your repository \"vvpp03/ABC01\" was successfully deleted.", "repository was NOT removed");
    }

    @Test
    public void testRenameRepository(){
        homePage.selectRepository("qqq");
        repositoryPage.openRepositorySettings();
        repositorySettingsPage.renameCurrentRepository("zzz");
        Assert.assertEquals(repositoryPage.getRepositoryName(),"zzz", "repository was NOT renamed");
        repositoryPage.openRepositorySettings();
        repositorySettingsPage.renameCurrentRepository("qqq");
    }

    @Test
    public void testRenameRepositoryToAlreadyExistingName(){
        homePage.selectRepository("qqq");
        repositoryPage.openRepositorySettings();
        repositorySettingsPage.renameCurrentRepository("ABC");
        Assert.assertEquals(homePage.getMessageText(),"Name already exists on this account", "New Name does not exist on this account");
    }
}

