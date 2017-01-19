package com.lohika.gap.tests;

import com.lohika.gap.core.Wait;
import org.testng.annotations.Test;

public class RepositoryTest extends BaseTest {

    @Test
    public void testAddNewFile(){
        homePage.selectRepository("TestRepo");
        repositoryPage.createNewFile("first_file.txt");
        Wait.seconds(2);
       // Assert.assertEquals(driver.getTitle(),"vvpp03/ABC01","ABC repository was not created");
    }

}

