package com.lohika.gap.tests;

import com.lohika.gap.core.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class RepositoryFilesTest extends BaseTest {

    @Test
    public void testAddNewFile(){
        homePage.selectRepository("TestRepo");
        repositoryPage.createNewFile();
        editFilePage.createFile("New_file.txt","First line.","Added new file");
        Wait.seconds(2);
        Assert.assertEquals(repositoryPage.getCommitText(),"Added new file","New file was not created");
    }

    @Test
    public void testAddNewFileWithExistingName(){
        homePage.selectRepository("TestRepo");
        repositoryPage.createNewFile();
        editFilePage.createFile("abcd","","");
        Wait.seconds(2);
        Assert.assertEquals(homePage.getMessageText(),"A file with the same name already exists. Please choose a different name and try again.");
    }

    @Test
    public void testEditFile(){
        homePage.selectRepository("TestRepo");
        repositoryPage.openFile("Edit_file");
        repositoryPage.goToEditMode();
        editFilePage.editFile("add new text ","Update Edit_file");
        Wait.seconds(2);
        Assert.assertEquals(repositoryPage.getStatusText(),"Update Edit_file","File wasn't edited");
    }

    @Test
    public void testRenameFile(){
        homePage.selectRepository("TestRepo");
        repositoryPage.openFile("old_name");
        repositoryPage.goToEditMode();
        editFilePage.renameFile("new_name");
        Wait.seconds(2);
        Assert.assertEquals(repositoryPage.getStatusText(),"Rename old_name to new_name","File wasn't renamed");
        repositoryPage.goToEditMode();
        editFilePage.renameFile("old_name");
    }

    @Test (dependsOnMethods = {"testAddNewFile"})
    public void testRemoveFile(){
        homePage.selectRepository("TestRepo");
        repositoryPage.openFile("New_file.txt");
        repositoryPage.removeCurrentFile();
        Wait.seconds(2);
        Assert.assertEquals(homePage.getMessageText(),"File successfully deleted.","File wasn't removed");
    }

    @Test
    public void testUploadFile(){
        homePage.selectRepository("TestRepo");
        repositoryPage.uploadFile("upload1.txt");
        Wait.seconds(2);
        Assert.assertEquals(repositoryPage.getCommitText(),"Upload upload1.txt","upload1.txt file was not uploaded");
    }

    @Test
    public void testFailedUploadFile(){
        homePage.selectRepository("TestRepo");
        repositoryPage.failedUploadFile();
        Wait.seconds(2);
        Assert.assertEquals(homePage.getMessageText(),"Add some files to include in this commit.");
    }

    @Test
    public void testUploadFileViaAUTOIT() throws IOException {
        homePage.selectRepository("TestRepo");
        repositoryPage.uploadFileViaExplorer("upload2.txt");
        Wait.seconds(2);
        Assert.assertEquals(repositoryPage.getCommitText(),"Upload upload2.txt","upload2.txt file was not uploaded");
    }

    @Test
    public void testCancelAddNewFile(){
        homePage.selectRepository("TestRepo");
        repositoryPage.createNewFile();
        editFilePage.cancelCreateFile("some_file.txt","First line.","Added new file");
        repositoryPage.findFile("some_file.txt");
        Wait.seconds(2);
        Assert.assertEquals(repositoryPage.getSearchStatus(),"No matching files found.");
    }

}


