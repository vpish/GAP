package com.lohika.gap.pages;

import com.lohika.gap.core.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//a[@aria-label='Create new…']")
    private WebElement plusDropdown;

    @FindBy(xpath = "//a[@class= 'dropdown-item' and @href='/new']")
    private WebElement newRepositoryItem;

    @FindBy(css = "svg[height='28']")
    private WebElement homeButton;

    @FindBy(id = "your-repos-filter")
    private WebElement searchFilter;

    @FindBy(xpath = "//li[not(@style)]/a/span/span[@class='repo']")
    private WebElement repositoryLink;

    @FindBy(xpath = "  //div[@class='container']")
    private WebElement messageContainer ;

    public HomePage(WebDriver driver) {
       super(driver);
    }

    public void openNewRepositoryPage(){
        Wait.forElement(plusDropdown);
        plusDropdown.click();
        Wait.forElement(newRepositoryItem);
        newRepositoryItem.click();
    }

    public void selectRepository(String name){
        Wait.forElement(homeButton);
        homeButton.click();
        Wait.forElement(searchFilter);
        searchFilter.sendKeys(name);
        Wait.seconds(2);
        Wait.forElement(repositoryLink);
        repositoryLink.click();
    }

    public String getMessageText(){
        Wait.forElement(messageContainer);
        return messageContainer.getText();
    }

}
