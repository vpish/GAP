package com.lohika.gap.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public enum BrowserType{
        FIREFOX,
        CHROME
    }

    public static WebDriver getDriver (BrowserType type){
        WebDriver driver = null;
        switch (type){
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver","D:\\Dev\\GAP\\geckodriver.exe");
                driver = new FirefoxDriver();
                //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                break;
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "D:\\Dev\\GAP\\chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                break;
            default:
                System.setProperty("webdriver.gecko.driver","D:\\Dev\\GAP\\geckodriver.exe");
                driver = new FirefoxDriver();
                //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                break;
        }
        return driver;
    }
}


