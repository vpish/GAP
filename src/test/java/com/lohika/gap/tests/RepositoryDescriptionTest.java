package com.lohika.gap.tests;

import com.lohika.gap.TestData.CorrectValues;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RepositoryDescriptionTest extends BaseTest {

    @Test(groups = {"positive"}, dataProvider = "RepositoryDescriptions", dataProviderClass = CorrectValues.class)
    public void testSetNewDescription(String description, String webpage, String descriptionText) {
        homePage.selectRepository("TestRepo");
        repositoryPage.editDescription(description, webpage);
        repositoryPage.saveChanges();
        Assert.assertEquals(repositoryPage.getDescriptionText(), descriptionText, "Description wasn't changed. ");
    }

    @Test(groups = {"negative"})
    public void testSetNewDescription_IncorectWebpage() {
        homePage.selectRepository("TestRepo");
        repositoryPage.editDescription("abcd", "abcd");
        repositoryPage.saveChanges();
        Assert.assertTrue(repositoryPage.alertAppears(), "Alert doesn't appear");
    }

    @Test(groups = {"positive"})
    public void testSetNewDescription_Canceled() {
        homePage.selectRepository("TestRepo");
        String description = repositoryPage.getDescriptionText();
        repositoryPage.editDescription("zzzz", "zzzz");
        repositoryPage.cancelChanges();
        Assert.assertEquals(repositoryPage.getDescriptionText(), description, "Description was changed. ");
    }

}


