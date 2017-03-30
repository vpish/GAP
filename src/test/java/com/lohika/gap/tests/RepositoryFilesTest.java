package com.lohika.gap.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class RepositoryFilesTest extends BaseTest {

    @Test (groups = {"positive"})
    public void testAddNewFile(){
        homePage.selectRepository("TestRepo");
        repositoryPage.createNewFile();
        editFilePage.editFile("New_file.txt","First line.","Added new file");
        Assert.assertEquals(repositoryPage.getCommitText(),"Added new file","New file was not created");
    }

    @Test (groups = {"negative"})
    public void testAddNewFile_AlreadyExists(){
        homePage.selectRepository("TestRepo");
        repositoryPage.createNewFile();
        editFilePage.editFile("abcd","","");
        Assert.assertEquals(homePage.getMessageText(),"A file with the same name already exists. Please choose a different name and try again.");
    }

    @Test (groups = {"positive"})
    public void testEditFile(){
        homePage.selectRepository("TestRepo");
        repositoryPage.openFile("Edit_file");
        repositoryPage.goToEditMode();
        editFilePage.editFile("Edit_file","add new text ","Update Edit_file");
        Assert.assertEquals(repositoryPage.getStatusText(),"Update Edit_file","File wasn't edited");
    }

    @Test (groups = {"positive"}, dependsOnMethods = {"testAddNewFile"})
    public void testRemoveFile(){
        homePage.selectRepository("TestRepo");
        repositoryPage.openFile("New_file.txt");
        repositoryPage.removeCurrentFile();
        Assert.assertEquals(homePage.getMessageText(),"File successfully deleted.","File wasn't removed");
    }

    @Test (groups = {"positive"})
    public void testUploadFile(){
        homePage.selectRepository("TestRepo");
        repositoryPage.uploadFile("upload1.txt");
        Assert.assertEquals(repositoryPage.getCommitText(),"Upload upload1.txt","upload1.txt file was not uploaded");
    }

    @Test (groups = {"negative"})
    public void testUploadFile_Failed(){
        homePage.selectRepository("TestRepo");
        repositoryPage.failedUploadFile();
        Assert.assertEquals(homePage.getMessageText(),"Add some files to include in this commit.");
    }

    @Test (groups = {"positive"})
    public void testUploadFileViaAUTOIT() throws IOException {
        homePage.selectRepository("TestRepo");
        repositoryPage.uploadFileViaExplorer("upload2.txt");
        Assert.assertEquals(repositoryPage.getCommitText(),"Upload upload2.txt","upload2.txt file was not uploaded");
    }

    @Test (groups = {"negative"})
    public void testAddNewFile_Canceled(){
        homePage.selectRepository("TestRepo");
        repositoryPage.createNewFile();
        editFilePage.cancelCreateFile("some_file.txt","First line.","Added new file");
        repositoryPage.findFile("some_file.txt");
        Assert.assertEquals(repositoryPage.getSearchStatus(),"No matching files found.");
    }

}


