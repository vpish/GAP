package com.lohika.gap.pages;

import com.lohika.gap.core.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "login_field")
    private WebElement loginInput;

    @FindBy(id = "password")
    private WebElement passInput;

    @FindBy(name = "commit")
    private WebElement signInButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String name, String pass) {
        Wait.forElement(loginInput);
        loginInput.sendKeys(name);
        Wait.forElement(passInput);
        passInput.sendKeys(pass);
        Wait.forElement(signInButton);
        signInButton.click();
    }

}
