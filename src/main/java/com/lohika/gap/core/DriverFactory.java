package com.lohika.gap.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    public enum BrowserType {
        FIREFOX,
        CHROME
    }

    public static WebDriver getDriver(BrowserType type) {
        WebDriver driver = null;
        String path = System.getProperty("user.dir");
        switch (type) {
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", path + File.separator + "geckodriver.exe");
                driver = new FirefoxDriver();
                //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                //driver.manage().window().maximize();
                break;
            case CHROME:
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications", "disable-infobars", "--start-maximized");
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                options.setExperimentalOption("prefs", prefs);
                System.setProperty("webdriver.chrome.driver", path + File.separator + "chromedriver.exe");
                driver = new ChromeDriver(options);
                break;
            default:
                ChromeOptions opt = new ChromeOptions();
                opt.addArguments("--disable-notifications", "disable-infobars", "--start-maximized");
                System.setProperty("webdriver.chrome.driver", path + File.separator + "chromedriver.exe");
                driver = new ChromeDriver(opt);
                break;
        }
        return driver;
    }

}


