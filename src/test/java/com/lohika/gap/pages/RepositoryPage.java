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

    @FindBy(css = "div.CodeMirror-lines")
    private WebElement editField;




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

    public void createNewFile(String fileName){
        Wait.forElement(createNewFileButton);
        createNewFileButton.click();
        Wait.forElement(editField);
        editField.click();
       // editField.sendKeys("Some text ...");
    }
}



