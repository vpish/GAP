package com.lohika.gap.pages;

import com.lohika.gap.core.Wait;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditFilePage extends BasePage {


    @FindBy(css = "input.form-control.js-blob-filename.js-breadcrumb-nav")
    private WebElement fileNameField;

    @FindBy(css = "div.CodeMirror-code")
    private WebElement editField;

    @FindBy(id = "commit-summary-input")
    private WebElement commitField;

    @FindBy(id = "submit-file")
    private WebElement submitButton;

    @FindBy(css = "a.btn.btn-danger")
    private WebElement cancelButton;

    public EditFilePage(WebDriver driver) {
        super(driver);
    }

    public void createFile(String fileName, String text, String commitComment ){
        Wait.forElement(fileNameField);
        fileNameField.sendKeys(fileName);
        Wait.forElement(editField);
        editField.click();
        editField.sendKeys(text);
        Wait.forElement(commitField);
        commitField.sendKeys(commitComment);
        Wait.forElement(submitButton);
        submitButton.click();
    }

    public void editFile(String text, String commitComment ){
        Wait.forElement(editField);
        editField.click();
        editField.sendKeys(text);
        Wait.forElement(commitField);
        commitField.sendKeys(commitComment);
        Wait.forElement(submitButton);
        submitButton.click();
    }

    public void renameFile(String fileName){
        Wait.forElement(fileNameField);
        fileNameField.clear();
        fileNameField.sendKeys(fileName);
        Wait.forElement(submitButton);
        submitButton.click();
    }

    public void cancelCreateFile(String fileName, String text, String commitComment ){
        Wait.forElement(fileNameField);
        fileNameField.sendKeys(fileName);
        Wait.forElement(editField);
        editField.click();
        editField.sendKeys(text);
        Wait.forElement(commitField);
        commitField.sendKeys(commitComment);
        Wait.forElement(cancelButton);
        cancelButton.click();
        Alert alert = driver.switchTo().alert();
        Wait.seconds(1);
        alert.accept();
    }

}



