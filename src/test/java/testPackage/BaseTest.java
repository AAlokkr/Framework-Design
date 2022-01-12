package testPackage;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseTest {

	protected String url, testDataLoc;
	private String browser;
	private int timeout;

	public void readPropertiesFile() throws IOException {
		FileReader fr = new FileReader("config.properties");
		Properties prop = new Properties();
		prop.load(fr);
		url = prop.getProperty("URL");
		browser = prop.getProperty("Browser");
		timeout = Integer.parseInt(prop.getProperty("Timeout"));
		testDataLoc = prop.getProperty("TestDataLocation");

	}

	public WebDriver getDriver() throws IOException {
		readPropertiesFile();
		WebDriver driver = selectDriver(browser);
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	public static WebDriver selectDriver(String browser) {
		if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver",
					System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\msedgedriver.exe");
			return new EdgeDriver();
		}
		return null;
	}

}
