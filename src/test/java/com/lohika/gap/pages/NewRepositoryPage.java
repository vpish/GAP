package com.lohika.gap.pages;

import com.lohika.gap.core.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewRepositoryPage extends BasePage{

    @FindBy(id = "repository_name")
    private WebElement repositoryName;

    @FindBy(id = "repository_description")
    private WebElement repositoryDescription ;

    @FindBy(xpath = "//button[@data-disable-with='Creating repository…']")
    private WebElement submitButton ;

    public NewRepositoryPage(WebDriver driver) {
       super(driver);
    }

    public void createNewRepository(String name, String description) {
        Wait.forElement(repositoryName);
        repositoryName.sendKeys(name);
        Wait.forElement(repositoryDescription);
        repositoryDescription.sendKeys(description);
        Wait.seconds(1);
        Wait.forElement(submitButton);
        submitButton.click();
    }

}
