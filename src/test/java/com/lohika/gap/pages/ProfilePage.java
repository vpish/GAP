package com.lohika.gap.pages;

import com.lohika.gap.core.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {

    @FindBy(id = "user_profile_name") private WebElement nameField;
    @FindBy(id = "user_profile_bio") private WebElement biofField;
    @FindBy(id = "user_profile_blog") private WebElement urlField;
    @FindBy(id = "user_profile_company") private WebElement companyField;
    @FindBy(id = "user_profile_location") private WebElement locationField;
    @FindBy(xpath = "//button[@type='submit' and contains(text(),'Update profile')]") private WebElement updateProfileButton;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public void udateProfile(String name,String bio, String url, String company, String location){
        insertTextToElement(name,nameField);
        insertTextToElement(bio, biofField);
        insertTextToElement(url,urlField);
        insertTextToElement(company,companyField);
        insertTextToElement(location,locationField);
        clickOnElement(updateProfileButton);
    }

}



