package com.lohika.gap.tests;

import com.lohika.gap.core.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RepositoryDescriptionTest extends BaseTest {

    @Test
    public void testSetNewDescription(){
        homePage.selectRepository("TestRepo");
        repositoryPage.editDescription("Test test","https://www.skype.com");
        repositoryPage.saveChanges();
        //Wait.seconds(1);
        Assert.assertEquals(repositoryPage.getDescriptionText(),"Test test","New Description wasn't set. ");
    }

    @Test
    public void testRemoveCurrentDescription(){
        homePage.selectRepository("TestRepo");
        repositoryPage.editDescription("","");
        repositoryPage.saveChanges();
        Assert.assertEquals(repositoryPage.getDescriptionText(),"No description, website, or topics provided.","Description wasn't removed. ");
    }

    @Test
    public void testSetDescriptionWithIncorectWebpage(){
        homePage.selectRepository("TestRepo");
        String description = repositoryPage.getDescriptionText();
        repositoryPage.editDescription("abcd","abcd");
        repositoryPage.saveChanges();
        Assert.assertTrue(repositoryPage.alertAppears(),"Alert doesn't appear");
    }

    @Test
    public void testChangeDescriptionWithoutSaving(){
        homePage.selectRepository("TestRepo");
        String description = repositoryPage.getDescriptionText();
        repositoryPage.editDescription("zzzz","zzzz");
        repositoryPage.cancelChanges();
        Assert.assertEquals(repositoryPage.getDescriptionText(),description,"Description was changed. ");
    }
//---------------------------
/*
    @Test
    public void testTrash(){
        homePage.selectRepository("qqq");
        homePage.selectRepository("qqq");
        homePage.selectRepository("TestRepo");
        homePage.selectRepository("asdasdasd");
        Wait.seconds(2);

    }
    */
    //----------------------------------

}


