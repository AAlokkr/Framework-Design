package pageComponents;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TripSetter {

    private WebDriver driver;
    private  ExtentTest logger;
    private By sectionElement = By.id("flightSearchContainer");

    public TripSetter(WebDriver driver, ExtentTest logger) {
        this.driver = driver;
        this.logger = logger;
    }

    public SearchFlights setTrip(String trip) {
        if (trip.equalsIgnoreCase("multitrip")) {
            return new MultiTrip(driver, logger, sectionElement);
        } else if (trip.equalsIgnoreCase("roundtrip")) {
            return new RoundTrip(driver, logger, sectionElement);
        }
        return null;
    }

}
