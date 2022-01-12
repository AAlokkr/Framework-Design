package pageComponents;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectComponent {
	
	private WebDriver driver;
	private WebElement sectionLocator;
	
	public SelectComponent(WebDriver driver, By sectionLocator) {
		this.driver = driver;
		this.sectionLocator = driver.findElement(sectionLocator);
	}
	
	public WebElement findElement(By locator) {
		return sectionLocator.findElement(locator);
	}
	
	public List<WebElement> findElements(By locator) {
		return sectionLocator.findElements(locator);
	}
	
	public void waitForElementToDisappear(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

}
