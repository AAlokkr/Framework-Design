package pageComponents;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SelectComponent {

    private WebDriver driver;
    private ExtentTest logger;
    private WebElement sectionLocator;

    public SelectComponent(WebDriver driver, ExtentTest logger, By sectionLocator) {
        this.driver = driver;
        this.logger = logger;
        this.sectionLocator = driver.findElement(sectionLocator);
    }

    public WebElement findElement(By locator) {
        return sectionLocator.findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        return sectionLocator.findElements(locator);
    }

    public void waitForElementToDisappear(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
            logger.pass(by.toString() + " located.");
        } catch (Exception e) {
            logger.fail(by.toString() + " cannot be located.");
        }
    }

}
