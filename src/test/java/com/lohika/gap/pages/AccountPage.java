package com.lohika.gap.pages;

import com.lohika.gap.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {

    @FindBy(id = "user_old_password")
    private WebElement oldPasswordField;
    @FindBy(id = "user_new_password")
    private WebElement newPasswordField;
    @FindBy(id = "user_confirm_new_password")
    private WebElement confirmNewPasswordField;
    @FindBy(css = "button.btn.mr-2")
    private WebElement updatePasswordButton;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public void changePassword(String oldPassword, String newPassword) {
        insertTextToElement(oldPassword, oldPasswordField);
        insertTextToElement(newPassword, newPasswordField);
        insertTextToElement(newPassword, confirmNewPasswordField);
        clickOnElement(updatePasswordButton);
    }

}



