package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver){
        super(driver);
    }
    private By header = By.id("navigation");
    private By mainLayout = By.cssSelector("main.flexible-layout");
    private By footer = By.id("footer");

    public void openHomePage(){
        driver.get("https://insiderone.com/");
        acceptCookiesIfPresent();
    }
    public boolean isHomePageLoaded() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(header));
        wait.until(ExpectedConditions.visibilityOfElementLocated(mainLayout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(footer));
        return true;
    }

}
