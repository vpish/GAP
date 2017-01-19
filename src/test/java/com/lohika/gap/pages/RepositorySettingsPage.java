package com.lohika.gap.pages;

import com.lohika.gap.core.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RepositorySettingsPage extends BasePage {

    @FindBy(xpath = "//button[@type and contains(text(), 'Delete this repository')]")
    private WebElement removeRepositoryButton;

    @FindBy(id = "rename_field")
    private WebElement rename_field;

    @FindBy(css = "button.btn.js-rename-repository-button")
    private WebElement rename_button;

    @FindBy(xpath = "//*[@id='facebox']/div/div/form/p/input")
    private WebElement confirmation_field;

    @FindBy(xpath = ".//*[@id='facebox']/div/div/form/button")
    private WebElement confirmButton;

    @FindBy(xpath = "//strong[@itemprop='name']/a")
    private WebElement reposytoryName;


    public RepositorySettingsPage(WebDriver driver) {
        super(driver);
    }

    public void removeCurrentRepository(){
        Wait.forElement(reposytoryName);
        String name = reposytoryName.getText();
        Wait.forElement(removeRepositoryButton);
        removeRepositoryButton.click();
        Wait.forElement(confirmation_field);
        confirmation_field.sendKeys(name);
        Wait.forElement(confirmButton);
        confirmButton.click();
    }

    public void renameCurrentRepository(String newName){
        Wait.forElement(rename_field);
        rename_field.clear();
        rename_field.sendKeys(newName);
        Wait.forElement(rename_button);
        rename_button.click();
    }
}



