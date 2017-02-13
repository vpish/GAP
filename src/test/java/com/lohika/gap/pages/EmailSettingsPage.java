package com.lohika.gap.pages;

import com.lohika.gap.core.BasePage;
import com.lohika.gap.core.Wait;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailSettingsPage extends BasePage {

    @FindBy(id = "email") private WebElement emailField;
    @FindBy(css = "button.btn") private WebElement addEmailButton;
    @FindBy(id = "type_marketing") private WebElement typeMarketingRadiobutton;
    @FindBy(id = "type_transactional") private WebElement typeTransactionalRadiobutton;
    @FindBy(css = "input.btn.js-email-global-unsubscribe-submit") private WebElement SaveEmailPreferencesButton;
    @FindBy(xpath = "//span[@title='new_mail@gmail.com']/following-sibling::span[2]/form/button") private WebElement removeButton;

    public EmailSettingsPage(WebDriver driver) {
        super(driver);
    }

    public void addNewEmail(String email){
        insertTextToElement(email,emailField);
        clickOnElement(addEmailButton);
    }

    public void removeAddedEmail(){
        clickOnElement(removeButton);
        Alert alert = driver.switchTo().alert();
        Wait.seconds(1);
        alert.accept();
    }

    public void changeEmailPreferences(){
        Wait.forElement(typeMarketingRadiobutton);
        Wait.seconds(1);
        if (typeMarketingRadiobutton.isSelected()){
            clickOnElement(typeTransactionalRadiobutton);
        }
        else{
            clickOnElement(typeMarketingRadiobutton);
        }
        clickOnElement(SaveEmailPreferencesButton);
    }

}



