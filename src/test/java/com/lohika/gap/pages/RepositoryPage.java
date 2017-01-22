package com.lohika.gap.pages;

import com.lohika.gap.core.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class RepositoryPage extends BasePage {

    @FindBy(linkText = "Settings")  private WebElement settingsLink;
    @FindBy(xpath = "//strong[@itemprop='name']/a") private WebElement reposytoryName;
    @FindBy(css = "button.btn.btn-sm.BtnGroup-item") private WebElement createNewFileButton;
    @FindBy(css = "div.CodeMirror-code") private WebElement editField;
    @FindBy(xpath = "//span[@class='commit-author-section']/following-sibling::a[@class='message']") private WebElement textInMessage;
    @FindBy(css = "a.message") private WebElement statusText;
    @FindBy(css = "a.btn.btn-sm.empty-icon.float-right.BtnGroup-item") private WebElement findFileButton;
    @FindBy(id = "tree-finder-field") private WebElement finderField;
    @FindBy(xpath = "//a[@class and child::mark]") private WebElement fileNameInFilter;
    @FindBy(css = "svg.octicon.octicon-pencil") private WebElement editButton;
    @FindBy(css = "button.btn-octicon.btn-octicon-danger.tooltipped.tooltipped-nw") private WebElement removeButton;
    @FindBy(id = "submit-file") private WebElement submitButton;
    @FindBy(id = "commit-summary-input") private WebElement commitSummaryField;
    @FindBy(css = "div.no-results.blankslate.blankslate-clean-background") private WebElement searchStatus;
    @FindBy(linkText = "Upload files") private WebElement uploadFilesButton;
    @FindBy( xpath= "//input[@type='file']") private WebElement upload;
    @FindBy( css= "tbody.js-manifest-file-list-root") private WebElement uploadedFile;
    @FindBy( css= "button.btn.btn-primary.js-blob-submit") private WebElement submitUpload;
    @FindBy( xpath= "//span[@class='edit-link']/button[@type='button']") private WebElement editDescriptionButton;
    @FindBy( id= "repo_description") private WebElement editRepoDescriptionField;
    @FindBy( id= "repo_homepage") private WebElement editRepoHomepageField;
    @FindBy( xpath= "//button[@type='submit' and contains(text(),'Save')]") private WebElement saveDescriptionButton;
    @FindBy( css= "button.btn-link.js-details-target") private WebElement cancelDescriptionButton;
    @FindBy( css= "em.d-inline-block.text-gray.mb-1") private WebElement noDescriptionText;
    @FindBy( css= "span.col-11.text-gray-dark") private WebElement descriptionText;


    public RepositoryPage(WebDriver driver) {
        super(driver);
    }

    public void openRepositorySettings(){
        Wait.forElement(settingsLink);
        settingsLink.click();
    }

    public String getRepositoryName(){
        Wait.forElement(reposytoryName);
        String name = reposytoryName.getText();
        return name;
    }

    public void createNewFile(){
        Wait.forElement(createNewFileButton);
        createNewFileButton.click();
    }

    public String getCommitText(){
        Wait.forElement(textInMessage);
        //System.out.println(textInMessage.getText());
        return textInMessage.getText();
    }

    public String getStatusText() {
        Wait.forElement(statusText);
      //  System.out.println(statusText.getText());
        return statusText.getText();
    }

    public String getSearchStatus() {
        Wait.forElement(searchStatus);
        //System.out.println(searchStatus.getText());
        return searchStatus.getText();
    }

    public void openFile(String fileName){
        Wait.forElement(findFileButton);
        findFileButton.click();
        Wait.forElement(finderField);
        finderField.sendKeys(fileName);
        Wait.seconds(1);
        Wait.forElement(fileNameInFilter);
        fileNameInFilter.click();
    }

    public void goToEditMode(){
        Wait.forElement(editButton);
        editButton.click();
    }

    public void removeCurrentFile(){
        Wait.forElement(removeButton);
        removeButton.click();
        Wait.forElement(commitSummaryField);
        commitSummaryField.sendKeys("Removed a file");
        Wait.forElement(submitButton);
        submitButton.click();
    }

    public void findFile(String fileName){
        Wait.forElement(findFileButton);
        findFileButton.click();
        Wait.forElement(finderField);
        finderField.sendKeys(fileName);
    }

    public void uploadFile(String fileName){
        Wait.forElement(uploadFilesButton);
        uploadFilesButton.click();
        Wait.forElement(upload);
        upload.sendKeys("D:\\Dev\\GAP\\" + fileName);
        Wait.forElement(uploadedFile);
        Wait.forElement(commitSummaryField);
        commitSummaryField.sendKeys("Upload " +fileName);
        Wait.forElement(submitUpload);
        submitUpload.click();
    }

    public void failedUploadFile(){
        Wait.forElement(uploadFilesButton);
        uploadFilesButton.click();
        Wait.forElement(submitUpload);
        submitUpload.click();
    }

    public void uploadFileViaExplorer(String fileName) throws IOException {
        Wait.forElement(uploadFilesButton);
        uploadFilesButton.click();
        Wait.forElement(upload);
        upload.click();
        //Runtime.getRuntime().exec(new String[] {"12.exe", "D:\\Dev\\GAP\\12.exe"});
        Runtime.getRuntime().exec(new String[] {"loadFile.exe", ""});
        Wait.forElement(uploadedFile);
        Wait.forElement(commitSummaryField);
        commitSummaryField.sendKeys("Upload " +fileName);
        Wait.forElement(submitUpload);
        submitUpload.click();
    }
    //---------------RepositoryDescriptionTest------------------------------------------
    public void editDescription(String description, String webpage){
        Wait.forElement(editDescriptionButton);
        editDescriptionButton.click();
        for(int i=0; i<5; i++){
            Wait.seconds(1);
            if (Wait.isReady(editDescriptionButton)){
                editDescriptionButton.click();
                break;
            }
            else if (Wait.isReady(editRepoDescriptionField)){
                break;
            }
        }
        Wait.forElement(editRepoDescriptionField);
        editRepoDescriptionField.clear();
        editRepoDescriptionField.sendKeys(description);
        Wait.forElement(editRepoHomepageField);
        editRepoHomepageField.clear();
        editRepoHomepageField.sendKeys(webpage);
    }

    public void saveChanges(){
        Wait.forElement(saveDescriptionButton);
        saveDescriptionButton.click();
    }

    public void cancelChanges(){
        Wait.forElement(saveDescriptionButton);
        cancelDescriptionButton.click();
    }

    public boolean isAlertPresent() {
        saveDescriptionButton.click();
        if (Wait.isReady(saveDescriptionButton) && (Wait.isReady(cancelDescriptionButton))) {
            return true;
        }
        else{
             return false;
        }
    }

    public String getDescriptionText(){
        if (Wait.isReady(noDescriptionText)) {
            return noDescriptionText.getText();
        }
        else
            return descriptionText.getText();
    }
}



