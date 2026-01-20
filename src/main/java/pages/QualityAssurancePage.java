package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class QualityAssurancePage extends BasePage{
    public QualityAssurancePage(WebDriver driver){
        super(driver);
    }
    //Locators
    private By pageHead = By.id("page-head");
    private By pageTitle = By.cssSelector("#page-head h1");
    private By allQaJobsBtn = By.xpath("//section[@id='page-head']//a[contains(text(),'See all QA jobs')]");
    public void openQaPage(){
        driver.get("https://insiderone.com/careers/quality-assurance/");
        acceptCookiesIfPresent();
    }
    public boolean isQaPageLoaded(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageHead));
        return driver.findElement(pageTitle).isDisplayed();
    }
    public void clickAllQaJobsBtnIfPresent(){
      try {
          WebElement btn = driver.findElement(allQaJobsBtn);
          if (btn.isDisplayed()){
              btn.click();
              System.out.println("See all QA jobs btn clicked");
          }
      } catch (NoSuchElementException e){
          System.out.println("Button not present");
      }
    }
}
