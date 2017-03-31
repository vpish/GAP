package com.lohika.gap.tests;

import com.lohika.gap.core.DriverFactory;
import com.lohika.gap.core.Wait;
import com.lohika.gap.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

/**
 * Created by vova on 10.01.2017.
 */
public class BaseTest {

    protected WebDriver driver;
    protected final String SITE_URL = "https://github.com/login";
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected NewRepositoryPage newRepositoryPage;
    protected RepositoryPage repositoryPage;
    protected RepositorySettingsPage repositorySettingsPage;
    protected EditFilePage editFilePage;
    protected ProfilePage profilePage;
    protected AccountPage accountPage;
    protected EmailSettingsPage emailSettingsPage;

    @Parameters({ "userName", "userPassword","browser" })
    @BeforeClass(alwaysRun = true)
    public void SetupMethod(@Optional("vvpp03") String user_name,
                            @Optional("12qwaszx") String user_password,
                            @Optional("CHROME") DriverFactory.BrowserType browser){
        // ------- initialize WebDriver
        DriverFactory.BrowserType type = browser;
        driver = DriverFactory.getDriver(type);
        System.out.println("browser = "+ browser);
        // ------- login to system
        driver.get(SITE_URL);
        loginPage = new LoginPage(driver);
        loginPage.login(user_name, user_password);
        Wait.seconds(1);
        Assert.assertEquals(driver.getTitle(),"GitHub","User is not signed in");
        //------ pages ----
        homePage = new HomePage(driver);
        //Assert.assertEquals(homePage.getNameFromProfile(),user_name,"User is not signed in");
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
