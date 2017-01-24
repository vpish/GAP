package com.lohika.gap.pages;

import com.lohika.gap.core.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

    public String getTextFromElement(WebElement element){
        Wait.forElement(element);
        return element.getText();
    }

    public void selectValueFromDropdown(WebElement dropdown,String value){
        Wait.forElement(dropdown);
        Select select = new Select(dropdown);
        Wait.seconds(1);
        select.selectByValue(value);
        Wait.seconds(1);
    }

}
