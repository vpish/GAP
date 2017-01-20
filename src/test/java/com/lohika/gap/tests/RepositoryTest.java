package com.lohika.gap.tests;

import com.lohika.gap.core.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RepositoryTest extends BaseTest {

    @Test
    public void testAddNewFile(){
        homePage.selectRepository("TestRepo");
        repositoryPage.createNewFile();
        editFilePage.editFile("New_file.txt","First line.","Added new file");
        Wait.seconds(2);
        Assert.assertEquals(repositoryPage.getCommitText(),"Added new file","New file was not created");
    }

    @Test
    public void testAddNewFileWithExistingName(){
        homePage.selectRepository("TestRepo");
        repositoryPage.createNewFile();
        editFilePage.editFile("abcd","","");
        Wait.seconds(2);
        Assert.assertEquals(homePage.getMessageText(),"A file with the same name already exists. Please choose a different name and try again.");
    }

    @Test
    public void testEditFile(){
        homePage.selectRepository("TestRepo");
        repositoryPage.openFile("Edit_file");
        repositoryPage.goToEditMode();
        editFilePage.editFile("","add new text ","");
        Wait.seconds(2);
        Assert.assertEquals(repositoryPage.getStatusText(),"Update Edit_file","File wasn't edited");
    }

    @Test (dependsOnMethods = {"testAddNewFile"})
    public void testRemoveFile(){
        homePage.selectRepository("TestRepo");
        repositoryPage.openFile("New_file.txt");
        repositoryPage.removeCurrentFile();
        Wait.seconds(2);
        Assert.assertEquals(homePage.getMessageText(),"File successfully deleted.","File wasn't removed");
    }


}

