package pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderNav extends SelectComponent{

    private By flights = By.cssSelector("[title='Flights']");
    private By links = By.cssSelector("a");

	public HeaderNav(WebDriver driver, By HeaderElm) {
		super(driver,HeaderElm);
	}
	
	public String getClassAttribute() {
		return findElement(flights).getAttribute("class");
	}
	
	public int getLinkCount() {
		return findElements(links).size();
	}
	
	public void clickFlights() {
		findElement(flights).click();
	}

}
