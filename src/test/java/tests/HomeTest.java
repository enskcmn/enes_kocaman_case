package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomeTest extends BaseTest {
    @Test
    public void checkHomePageIsOpenedAndLoaded(){
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();

        Assert.assertTrue(homePage.isHomePageLoaded(),
                "Home page main blocks are not loaded");
    }
}
