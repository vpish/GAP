package com.lohika.gap.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {

    @FindBy(id = "user_old_password") private WebElement oldPasswordField;
    @FindBy(id = "user_new_password") private WebElement newPasswordField;
    @FindBy(id = "user_confirm_new_password") private WebElement confirmNewPasswordField;
    @FindBy(css = "button.btn.mr-2") private WebElement updatePasswordButton;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public void changePassword(String old_password,String new_password){
        insertTextToElement(old_password,oldPasswordField);
        insertTextToElement(new_password, newPasswordField);
        insertTextToElement(new_password,confirmNewPasswordField);
        clickOnElement(updatePasswordButton);
    }

}



