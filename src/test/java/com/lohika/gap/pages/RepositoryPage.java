package com.lohika.gap.pages;

import com.lohika.gap.core.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class RepositoryPage extends BasePage {

    @FindBy(linkText = "Settings")  private WebElement repoSettingsLink;
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

    public String getRepositoryName(){
        return getTextFromElement(reposytoryName);
    }

    public String getCommitText(){
        return getTextFromElement(textInMessage);
    }

    public String getStatusText() {
        return getTextFromElement(statusText);
    }

    public String getSearchStatus() {
        return getTextFromElement(searchStatus);
    }

    public void openFile(String fileName){
        clickOnElement(findFileButton);
        insertTextToElement(fileName,finderField);
        Wait.seconds(1);
        clickOnElement(fileNameInFilter);
    }

    public void openRepositorySettings(){
        clickOnElement(repoSettingsLink);
    }

    public void createNewFile(){
        clickOnElement(createNewFileButton);
    }

    public void goToEditMode(){
        clickOnElement(editButton);
    }

    public void removeCurrentFile(){
        clickOnElement(removeButton);
        insertTextToElement("Removed a file",commitSummaryField);
        clickOnElement(submitButton);
    }

    public void findFile(String fileName){
        clickOnElement(findFileButton);
        insertTextToElement(fileName,finderField);
    }
//-------------------uploadFile------------------------

    public void uploadFile(String fileName){
        clickOnElement(uploadFilesButton);
        insertTextToElement("D:\\Dev\\GAP\\" + fileName,upload);
        Wait.seconds(1);
        Wait.forElement(uploadedFile);
        insertTextToElement("Upload " +fileName,commitSummaryField);
        clickOnElement(submitUpload);
    }

    public void failedUploadFile(){
        clickOnElement(uploadFilesButton);
        clickOnElement(submitUpload);
    }

    public void uploadFileViaExplorer(String fileName) throws IOException {
        clickOnElement(uploadFilesButton);
        clickOnElement(upload);
        Wait.seconds(1);
        Runtime.getRuntime().exec(new String[] {"loadFile.exe", ""});
        Wait.seconds(1);
        Wait.forElement(uploadedFile);
        insertTextToElement("Upload " +fileName,commitSummaryField);
        clickOnElement(submitUpload);
    }
    //---------------RepositoryDescriptionTest------------------------------------------
    public void editDescription(String description, String webpage){
        clickOnElement(editDescriptionButton);
        insertTextToElement(description,editRepoDescriptionField);
        insertTextToElement(webpage,editRepoHomepageField);
    }

    public void saveChanges(){
        clickOnElement(saveDescriptionButton);
    }

    public void cancelChanges(){
        clickOnElement(cancelDescriptionButton);
    }

    public boolean alertAppears() {
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



