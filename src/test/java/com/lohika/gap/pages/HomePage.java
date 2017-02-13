package com.lohika.gap.pages;

import com.lohika.gap.core.BasePage;
import com.lohika.gap.core.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[@aria-label='Create new…']") private WebElement plusDropdown;
    @FindBy(xpath = "//a[@class= 'dropdown-item' and @href='/new']") private WebElement newRepositoryItem;
    @FindBy(css = "svg[height='30']") private WebElement homeButton;
    @FindBy(css = "div.dashboard-sidebar.column.one-third") private WebElement dashboard;
    //@FindBy(id = "your-repos-filter") private WebElement searchFilter;
    //@FindBy(xpath = "//li[not(@style)]/a/span/span[@class='repo']") private WebElement repositoryLink;
    @FindBy(xpath = "//div[@class='container']") private WebElement messageContainer ;
    @FindBy(xpath = "//strong[@itemprop='name']/a") private WebElement repoNameLink ;
    @FindBy (xpath = "//a[@aria-label='View profile and more']") private WebElement profileDropdown;
    @FindBy (linkText = "Settings") private WebElement settingsItem;
    @FindBy (linkText = "Account") private WebElement accountLink;
    @FindBy (linkText = "Emails") private WebElement emailsLink;
    @FindBy(css = "button.dropdown-item.dropdown-signout") private WebElement signoutItem;
    @FindBy (css="span.repo") private List<WebElement> repoList;


    public HomePage(WebDriver driver) {
       super(driver);
    }

    public void openNewRepositoryPage(){
        clickOnElement(plusDropdown);
        clickOnElement(newRepositoryItem);
    }

    public void selectRepository(String name){
        String Url;
        Url = "https://github.com/vvpp03/" + name;
        if (driver.getCurrentUrl().equals(Url)) {
            repoNameLink.click();
            Wait.seconds(1);
        }
        else {
            clickOnElement(homeButton);
            Wait.forElement(dashboard);
            clickOnElementInList(name,repoList);
        }
    }

    public String getMessageText(){
        return getTextFromElement(messageContainer);
    }

    public void openProfilePage(){
        clickOnElement(profileDropdown);
        clickOnElement(settingsItem);
    }

    public void openAccountPage(){
        clickOnElement(profileDropdown);
        clickOnElement(settingsItem);
        clickOnElement(accountLink);
    }

    public void openEmailsPage(){
        clickOnElement(profileDropdown);
        clickOnElement(settingsItem);
        clickOnElement(emailsLink);
    }

    public void signout(){
        clickOnElement(profileDropdown);
        clickOnElement(signoutItem);
    }

}
