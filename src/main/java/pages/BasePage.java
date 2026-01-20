package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    private By cookieAcceptBtn = By.id("wt-cli-accept-all-btn");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }
    public void acceptCookiesIfPresent() {
        try {
            WebElement acceptBtn = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(cookieAcceptBtn)
            );
            acceptBtn.click();
        } catch (Exception e) {
            //There is an exception regarding cookies
        }
    }
}
