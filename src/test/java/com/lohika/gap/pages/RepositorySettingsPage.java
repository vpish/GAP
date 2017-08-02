package com.lohika.gap.pages;

import com.lohika.gap.core.BasePage;
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

    public void removeCurrentRepository() {
        Wait.forElement(reposytoryName);
        String name = reposytoryName.getText();
        clickOnElement(removeRepositoryButton);
        insertTextToElement(name, confirmation_field);
        clickOnElement(confirmButton);
    }

    public void renameCurrentRepository(String newName) {
        insertTextToElement(newName, rename_field);
        clickOnElement(rename_button);
    }
}



