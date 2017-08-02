package com.lohika.gap.pages;

import com.lohika.gap.core.BasePage;
import com.lohika.gap.core.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewRepositoryPage extends BasePage {

    @FindBy(id = "repository_name")
    private WebElement repositoryName;
    @FindBy(id = "repository_description")
    private WebElement repositoryDescription;
    @FindBy(css = "button.btn.btn-primary.first-in-line")
    private WebElement submitButton;

    public NewRepositoryPage(WebDriver driver) {
        super(driver);
    }

    public void createNewRepository(String name, String description) {
        insertTextToElement(name, repositoryName);
        insertTextToElement(description, repositoryDescription);
        Wait.seconds(1);
        clickOnElement(submitButton);
    }

}
