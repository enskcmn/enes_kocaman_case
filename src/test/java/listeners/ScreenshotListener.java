package listeners;

import base.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScreenshotListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {

        Object instance = result.getInstance();
        if (!(instance instanceof BaseTest)) return;

        WebDriver driver = ((BaseTest) instance).getDriver();
        if (driver == null) return;

        try {
            Files.createDirectories(Paths.get("screenshots"));

            File src = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            Files.copy(
                    src.toPath(),
                    Paths.get("screenshots/" + result.getName() + ".png")
            );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
