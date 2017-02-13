package com.lohika.gap.pages;

import com.lohika.gap.core.BasePage;
import com.lohika.gap.core.Wait;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditFilePage extends BasePage {

    @FindBy(css = "input.form-control.js-blob-filename.js-breadcrumb-nav") private WebElement fileNameField;
    @FindBy(css = "div.CodeMirror-code") private WebElement editField;
    @FindBy(id = "commit-summary-input") private WebElement commitField;
    @FindBy(id = "submit-file") private WebElement submitButton;
    @FindBy(css = "a.btn.btn-danger") private WebElement cancelButton;

    public EditFilePage(WebDriver driver) {
        super(driver);
    }

    public void editFile(String fileName, String text, String commitText ){
        insertTextToElement(fileName,fileNameField);
        insertTextToElement(text,editField);
        insertTextToElement(commitText,commitField);
        clickOnElement(submitButton);
    }

    public void cancelCreateFile(String fileName, String text, String commitText ){
        insertTextToElement(fileName,fileNameField);
        insertTextToElement(text,editField);
        insertTextToElement(commitText,commitField);
        clickOnElement(cancelButton);
        Alert alert = driver.switchTo().alert();
        Wait.seconds(1);
        alert.accept();
    }

}



