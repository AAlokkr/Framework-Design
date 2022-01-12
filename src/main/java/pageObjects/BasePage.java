package pageObjects;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private WebDriver driver;
    private ExtentTest logger;
    private WebDriverWait wait;

    public BasePage(WebDriver driver, ExtentTest logger){
        this.driver = driver;
        this.logger = logger;
        wait = new WebDriverWait(driver, 10);
    }

    public void click(By by){
        try {
            waitVisibility(by).click();
            logger.pass("Clicked "+by.toString());
        }
        catch (Exception e){
            logger.fail("Can't click "+by.toString());
        }
    }

    public void writeText(By by, String text){
        try{
            waitVisibility(by).sendKeys(text);
            logger.pass("Successfully sent keys to "+by.toString());
        }
        catch (Exception e){
            logger.fail("Couldn't send keys to "+by.toString());
        }
    }

    public String readText(By by){
        return waitVisibility(by).getText();
    }

    public WebElement waitVisibility(By by){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}