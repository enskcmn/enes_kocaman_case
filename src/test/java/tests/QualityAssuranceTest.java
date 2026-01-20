package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualityAssurancePage;

public class QualityAssuranceTest extends BaseTest {
    @Test
    public void checkQaPageAndClickAllJobs(){
        QualityAssurancePage qaPage = new QualityAssurancePage(driver);
        qaPage.openQaPage();

        Assert.assertTrue(qaPage.isQaPageLoaded(),"QA page is not loaded");
        qaPage.clickAllQaJobsBtnIfPresent();
    }

}
