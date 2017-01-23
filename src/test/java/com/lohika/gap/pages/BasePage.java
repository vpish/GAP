package com.lohika.gap.pages;

import com.lohika.gap.core.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void insertTextToElement(String text, WebElement element){
        Wait.forElement(element);
        element.clear();
        element.sendKeys(text);
    }

    public void clickOnElement(WebElement element){
        Wait.forElement(element);
        element.click();
    }

}
