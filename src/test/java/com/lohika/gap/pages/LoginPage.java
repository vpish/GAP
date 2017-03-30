package com.lohika.gap.pages;

import com.lohika.gap.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "login_field") private WebElement loginInput;
    @FindBy(id = "password") private WebElement passInput;
    @FindBy(name = "commit") private WebElement signInButton;
    @FindBy(linkText = "Sign in") private WebElement loginButton;
    @FindBy (css = "div.flash.flash-full.flash-error") private WebElement loginErrorMessage;
    @FindBy(css = "a.header-logo-invertocat") private WebElement homeButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String name, String pass) {
        insertTextToElement(name,loginInput);
        insertTextToElement(pass,passInput);
        clickOnElement(signInButton);
    }

    public void goToLoginMode(){
            clickOnElement(loginButton);
    }

    public String getErrorText(){
        return getTextFromElement(loginErrorMessage);
    }

}
