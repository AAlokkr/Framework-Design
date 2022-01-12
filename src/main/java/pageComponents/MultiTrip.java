package pageComponents;

import java.util.HashMap;
import java.util.function.Consumer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultiTrip extends SelectComponent implements SearchFlights {
	
	private By radioMultiCity = By.id("ctl00_mainContent_rbtnl_Trip_2");
	private By modalPopUp = By.id("MultiCityModelAlert");
	private By txtFrom = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
	private By txtTo = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
	private By txtDestination = By.id("ctl00_mainContent_ddl_originStation2_CTXT");
	private By submit = By.id("ctl00_mainContent_btn_FindFlights");
	
	public MultiTrip(WebDriver driver, By sectionElement) {
		super(driver,sectionElement);
	}

	@Override
	public void checkFlights(HashMap<String, String> testData) {
		System.out.println("Multi Trip");
		makePageReady(s->selectOriginCity(testData.get("origin")));
		selectDestinationCity(testData.get("destination"));
		selectDestinationCity2(testData.get("destination"));
		findElement(submit).click();
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

	public void selectDestinationCity2(String destination) {
		findElement(txtDestination).click();
		findElement(By.xpath("(//a[@value='" + destination + "'])[3]")).click();
	}
	
	public void makePageReady(Consumer<MultiTrip> consumer) {
		findElement(radioMultiCity).click();
		findElement(modalPopUp).click();
		waitForElementToDisappear(modalPopUp);
		System.out.println("Page is ready");
		consumer.accept(this);
		System.out.println("Excuted the consumer function");
	}
}
