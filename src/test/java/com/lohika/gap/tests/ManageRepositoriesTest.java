package com.lohika.gap.tests;

import com.lohika.gap.TestData.IncorrectValues;
import com.lohika.gap.core.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ManageRepositoriesTest extends BaseTest {

    @Test(groups = {"positive"})
    public void testCreateNewRepository() {
        homePage.openNewRepositoryPage();
        newRepositoryPage.createNewRepository("ABC01", "new test repository");
        Assert.assertEquals(repositoryPage.getRepositoryName(), "ABC01", "ABC01 repository was not created");
    }

    @Test(groups = {"negative"}, dataProvider = "IncorrectRepositoryName", dataProviderClass = IncorrectValues.class)
    public void testCreateNewRepository_Failed(String repoName, String repoDecription, String errorText) {
        homePage.openNewRepositoryPage();
        newRepositoryPage.createNewRepository(repoName, repoDecription);
        Assert.assertEquals(homePage.getMessageText(), errorText, "Text message doesn't match with expected text.");
    }

    @Test(groups = {"positive"}, dependsOnMethods = {"testCreateNewRepository"})
    public void testRemoveRepository() {
        homePage.selectRepository("ABC01");
        repositoryPage.openRepositorySettings();
        repositorySettingsPage.removeCurrentRepository();
        Wait.seconds(4);
        Assert.assertEquals(homePage.getMessageText(), "Your repository \"vvpp03/ABC01\" was successfully deleted.", "repository was NOT removed");
    }

    @Test(groups = {"positive"})
    public void testRenameRepository() {
        homePage.selectRepository("qqq");
        repositoryPage.openRepositorySettings();
        repositorySettingsPage.renameCurrentRepository("zzz");
        Assert.assertEquals(repositoryPage.getRepositoryName(), "zzz", "repository was NOT renamed");
        repositoryPage.openRepositorySettings();
        repositorySettingsPage.renameCurrentRepository("qqq");
    }

    @Test(groups = {"negative"})
    public void testRenameRepository_NameAlreadyExist() {
        homePage.selectRepository("qqq");
        repositoryPage.openRepositorySettings();
        repositorySettingsPage.renameCurrentRepository("ABC");
        Assert.assertEquals(homePage.getMessageText(), "Name already exists on this account", "New Name does not exist on this account");
    }
}

