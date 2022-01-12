package pageComponents;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RoundTrip extends SelectComponent implements SearchFlights {

	private By radioRoundTrip = By.id("ctl00_mainContent_rbtnl_Trip_1");
	private By txtFrom = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
	private By txtTo = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
	private By checkbox = By.id("ctl00_mainContent_chk_IndArm");
	private By buttonSearch = By.id("ctl00_mainContent_btn_FindFlights");

	public RoundTrip(WebDriver driver, By sectionLocator) {
		super(driver, sectionLocator);
	}

	@Override
	public void checkFlights(HashMap<String, String> testData) {
		System.out.println("Round Trip");
		findElement(radioRoundTrip).click();
		findElement(txtFrom).click();
		selectOriginCity(testData.get("origin"));
		selectDestinationCity(testData.get("destination"));
		findElement(checkbox).click();
		findElement(buttonSearch).click();
		System.out.println("Completed");

	}

	public void selectOriginCity(String origin) {
		findElement(txtFrom).click();
		findElement(By.xpath("//a[@value='" + origin + "']")).click();
	}

	public void selectDestinationCity(String destination) {
		findElement(txtTo).click();
		findElement(By.xpath("(//a[@value='" + destination + "'])[2]")).click();
	}

}
