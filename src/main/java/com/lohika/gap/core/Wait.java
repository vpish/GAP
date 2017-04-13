package com.lohika.gap.core;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

   private static final int DEFAULT_TIMEOUT = 10; // seconds

    public static void seconds(int time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean isReady(WebElement element) {
        boolean res = false;
        try {
            res = element.isDisplayed();
            return res;
        } catch (NoSuchElementException e) {
            return res;
        }
    }

    public static void forElement(WebElement element) {
        forElement(element, DEFAULT_TIMEOUT);
    }

    public static void forElement(WebElement element, Integer time) {
        double finish_time = System.currentTimeMillis() + time * 1000;
        while (System.currentTimeMillis() < finish_time) {
            if (isReady(element)) {
                return;
            }
        }
        if (!isReady(element)) {
            throw new TimeoutException("Timed out after " + time + "s. waiting for element: " + element);
        }
    }

    public static void untilElementIsVisible(WebElement element, int time, WebDriver driver) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, time);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

}
