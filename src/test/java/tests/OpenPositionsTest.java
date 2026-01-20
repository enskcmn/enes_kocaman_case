package tests;

import base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OpenPositionsPage;
import pages.QualityAssurancePage;

import java.time.Duration;

public class OpenPositionsTest extends BaseTest {
    @Test
    public void checkOpenQaPositions(){
        QualityAssurancePage qaPage = new QualityAssurancePage(driver);
        //1- Open QA page
        qaPage.openQaPage();
        Assert.assertTrue(qaPage.isQaPageLoaded(),"QA page is not loaded");
        //2- Click to See all QA jobs
        qaPage.clickAllQaJobsBtnIfPresent();

        OpenPositionsPage openPositionsPage = new OpenPositionsPage(driver);
        //3- Check if open positions page is loaded successfully
        Assert.assertTrue(openPositionsPage.isPageLoaded(),"Open positions page cannot be loaded");

        //4- Filter listed jobs
        openPositionsPage.applyFilters();

        //5- Check if all filtered job positions meet the specified criteria
        Assert.assertTrue(
        openPositionsPage.checkFilteredJobs(),
                "Some job do not meet the specified criteria"
        );
        //6- Click first View Role
        openPositionsPage.clickFirstViewBtn();

        //7- New tab
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        String newWindow = driver.getWindowHandles().toArray()[1].toString();
        driver.switchTo().window(newWindow);

        Assert.assertTrue(
                driver.getCurrentUrl().contains("jobs.lever.co"),
                "User is not redirected to Lever job page");
    }
}
