package testPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    private WebDriver driver;
    private FileReader fr;
    private Properties prop;
    protected String url, testDataLoc;
    private String browser;
    private int timeout;

    public void readPropertiesFile() throws IOException {
        fr = new FileReader("config.properties");
        prop = new Properties();
        prop.load(fr);
        url = prop.getProperty("URL");
        browser = prop.getProperty("Browser");
        timeout = Integer.parseInt(prop.getProperty("Timeout"));
        testDataLoc = prop.getProperty("TestDataLocation");
    }

    public WebDriver getDriver() throws IOException {
        readPropertiesFile();
        driver = selectDriver(browser);
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver selectDriver(String browser) {
        if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver",
                    System.getProperty("user.dir") + "\\src\\resources\\drivers\\msedgedriver.exe");
            return new EdgeDriver();
        }
        return null;
    }

}
