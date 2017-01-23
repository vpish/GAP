package com.lohika.gap.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailSettingsPage extends BasePage {

    @FindBy(id = "email") private WebElement emailField;
    @FindBy(xpath = "//button[@type='submit' and contains(text(),'Add')]") private WebElement addEmailButton;
    //@FindBy(id = "user_new_password") private WebElement newPasswordField;
   // @FindBy(id = "user_confirm_new_password") private WebElement confirmNewPasswordField;


    public EmailSettingsPage(WebDriver driver) {
        super(driver);
    }

    public void addNewEmail(String email){
        insertTextToElement(email,emailField);
        clickOnElement(addEmailButton);
    }

}



