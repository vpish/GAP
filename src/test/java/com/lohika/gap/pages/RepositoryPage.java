package com.lohika.gap.pages;

import com.lohika.gap.core.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RepositoryPage extends BasePage {

    @FindBy(linkText = "Settings")
    private WebElement settingsLink;

    @FindBy(xpath = "//strong[@itemprop='name']/a")
    private WebElement reposytoryName;

    @FindBy(css = "button.btn.btn-sm.BtnGroup-item")
    private WebElement createNewFileButton;

    @FindBy(css = "div.CodeMirror-code")
    private WebElement editField;

    @FindBy(xpath = "//span[@class='commit-author-section']/following-sibling::a[@class='message']")
    private WebElement textInMessage;

    @FindBy(css = "a.message")
    private WebElement statusText;

    @FindBy(css = "a.btn.btn-sm.empty-icon.float-right.BtnGroup-item")
    private WebElement findFileButton;

    @FindBy(id = "tree-finder-field")
    private WebElement finderField;

    @FindBy(xpath = "//a[@class and child::mark]")
    private WebElement fileNameInFilter;

    @FindBy(css = "svg.octicon.octicon-pencil")
    private WebElement editButton;

    @FindBy(css = "button.btn-octicon.btn-octicon-danger.tooltipped.tooltipped-nw")
    private WebElement removeButton;

    @FindBy(id = "submit-file")
    private WebElement submitButton;

    @FindBy(id = "commit-summary-input")
    private WebElement commitSummaryField;


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

    public void openFile(String fileName){
        Wait.forElement(findFileButton);
        findFileButton.click();
        Wait.forElement(finderField);
        finderField.sendKeys(fileName);
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

}



