package pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TripSetter {
	
	private WebDriver driver;
	private By sectionElement= By.id("flightSearchContainer");
	
	public TripSetter(WebDriver driver) {
		this.driver = driver;
	}
	
	public SearchFlights setTrip(String trip) {
		if(trip.equalsIgnoreCase("multitrip")) {
			return new MultiTrip(driver,sectionElement);
		}
		else if(trip.equalsIgnoreCase("roundtrip")) {
			return new RoundTrip(driver,sectionElement);
		}
		return null;
	}

}
