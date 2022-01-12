package pageObjects;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageComponents.FooterNav;
import pageComponents.HeaderNav;
import pageComponents.SearchFlights;
import pageComponents.TripSetter;

public class TravelHomePage {

	private WebDriver driver;
	private SearchFlights searchFlights;
	private By footerElm = By.id("traveller-home");
	private By headerElm = By.id("buttons");

	public TravelHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void goTo(String url) {

		driver.get(url);
	}
	
	public FooterNav getFooterNav() {
		return new FooterNav(driver,footerElm);
	}
	
	public HeaderNav getHeaderNav() {
		return new HeaderNav(driver,headerElm);
	}
	
	public void setTrip(String trip) {
		TripSetter tripSetter = new TripSetter(driver);
		searchFlights = tripSetter.setTrip(trip);
		
	}
	
	public void checkFlights(HashMap<String, String> testData) {
		searchFlights.checkFlights(testData);
	}

}
