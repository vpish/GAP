package com.lohika.gap.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.Optional;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void insertTextToElement(String text, WebElement element) {
        Wait.forElement(element);
        element.clear();
        element.sendKeys(text);
    }

    public void clickOnElement(WebElement element) {
        Wait.forElement(element);
        element.click();
    }

    public String getTextFromElement(WebElement element) {
        Wait.forElement(element);
        return element.getText();
    }

    public void selectValueFromDropdown(WebElement dropdown, String value) {
        Wait.forElement(dropdown);
        Select select = new Select(dropdown);
        select.selectByValue(value);
        Wait.seconds(1);
    }

    public void clickOnElementInList(String value, List<WebElement> list) {
        Optional<WebElement> element = list.stream()
                .filter(e -> e.getText().equals(value))
                .findFirst();
        if (element.isPresent()) {
            element.get().click();
        } else {
            throw new RuntimeException("No element - " + value + " in list - " + list);
        }
    }

    /* OLD METHOD:
    public void clickOnElementInList(String value, List<WebElement> list) {
        Boolean noElement = true;
        for (WebElement e : list) {
            if (e.getText().equals(value)) {
                e.click();
                noElement = false;
                break;
            }
        }
        if (noElement) {
            throw new RuntimeException("No element - " + value + " in list - " + list);
        }
    }*/

}
