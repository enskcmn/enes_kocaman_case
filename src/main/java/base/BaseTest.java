package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected WebDriver driver;
    public WebDriver getDriver() {
        return driver;
    }
    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("chrome") String browser){
        driver = DriverFactory.createDriver(browser);
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}
