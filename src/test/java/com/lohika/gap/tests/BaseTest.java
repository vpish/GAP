package com.lohika.gap.tests;

import com.lohika.gap.core.DriverFactory;
import com.lohika.gap.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static com.lohika.gap.core.DriverFactory.BrowserType.CHROME;

/**
 * Created by vova on 10.01.2017.
 */
public class BaseTest {

    protected WebDriver driver;
    DriverFactory.BrowserType type = CHROME;
    //DriverFactory.BrowserType type = FIREFOX;

    protected final String SITE_URL = "https://github.com/login";
    protected final String USER_NAME = "vvpp03";
    protected final String USER_PASS = "12qwaszx";

    protected LoginPage loginPage;
    protected HomePage homePage;
    protected NewRepositoryPage newRepositoryPage;
    protected RepositoryPage repositoryPage;
    protected RepositorySettingsPage repositorySettingsPage;
    protected EditFilePage editFilePage;
    protected ProfilePage profilePage;
    protected AccountPage accountPage;
    protected EmailSettingsPage emailSettingsPage;


    @BeforeClass(alwaysRun = true)
    public void SetupMethod(){

        driver = DriverFactory.getDriver(type);

        driver.get(SITE_URL);
        loginPage = new LoginPage(driver);
        loginPage.login(USER_NAME, USER_PASS);

        homePage = new HomePage(driver);
        newRepositoryPage = new NewRepositoryPage(driver);
        repositoryPage =  new RepositoryPage(driver);
        repositorySettingsPage = new RepositorySettingsPage(driver);
        editFilePage = new EditFilePage(driver);
        profilePage = new ProfilePage(driver);
        accountPage = new AccountPage(driver);
        emailSettingsPage = new EmailSettingsPage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void cleanMethod(){
        driver.quit();
    }

}
