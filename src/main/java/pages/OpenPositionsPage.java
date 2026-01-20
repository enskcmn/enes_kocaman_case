package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class OpenPositionsPage extends BasePage{
    public OpenPositionsPage(WebDriver driver){
        super(driver);
    }
    //Locators
    private By pageTitle = By.xpath("//section[@id='career-position-list']//h3[contains(text(),'Browse Open Positions')]");
    private By filterByLocation = By.id("filter-by-location");
    private By filterByDepartment = By.id("filter-by-department");
    private By jobList = By.cssSelector("#jobs-list .position-list-item");
    private By viewRoleBtns = By.cssSelector("#jobs-list .position-list-item a.btn");
    public boolean isPageLoaded(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
        wait.until(ExpectedConditions.visibilityOfElementLocated(filterByLocation));
        wait.until(ExpectedConditions.visibilityOfElementLocated(filterByDepartment));

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(jobList));

        return true;
    }
    public boolean checkFilteredJobs() {
        List<WebElement> jobs = driver.findElements(jobList);

        if (jobs.isEmpty()) {
            return false;
        }
        for (WebElement job : jobs) {

            String location = job.getAttribute("data-location");
            String team = job.getAttribute("data-team");

            if (!"istanbulturkiye".equals(location)) {
                return false;
            }

            if (!"qualityassurance".equals(team)) {
                return false;
            }
        }
        return true;
    }
    public void clickFirstViewBtn(){
        List<WebElement> buttons = driver.findElements(viewRoleBtns);
        if (!buttons.isEmpty()){
            buttons.get(0).click();
        }
    }
    public void applyFilters(){
        int beforeCount = driver.findElements(jobList).size();

        new Select(driver.findElement(filterByLocation))
                .selectByVisibleText("Istanbul, Turkiye");

        new Select(driver.findElement(filterByDepartment))
                .selectByVisibleText("Quality Assurance");

        wait.until(d -> d.findElements(jobList).size() != beforeCount);
    }
}
