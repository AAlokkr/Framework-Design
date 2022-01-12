package pageObjects;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageComponents.FooterNav;
import pageComponents.HeaderNav;
import pageComponents.SearchFlights;
import pageComponents.TripSetter;

import java.util.HashMap;

public class TravelHomePage extends BasePage {

    private WebDriver driver;
    private ExtentTest logger;
    private SearchFlights searchFlights;
    private By footerElm = By.id("traveller-home");
    private By headerElm = By.id("buttons");

    public TravelHomePage(WebDriver driver, ExtentTest logger) {
        super(driver, logger);
        this.driver = driver;
        this.logger = logger;
    }

    public void goTo(String url) {
        logger.info("Opening URL: "+url);
        try{
            driver.get(url);
            logger.pass("Successfully fetched the URL");
        }
        catch (Exception e){
            logger.fail("Couldn't fetch the URL");
        }

    }

    public FooterNav getFooterNav() {
        return new FooterNav(driver, logger, footerElm);
    }

    public HeaderNav getHeaderNav() {
        return new HeaderNav(driver, logger, headerElm);
    }

    public void setTrip(String trip) {
        TripSetter tripSetter = new TripSetter(driver, logger);
        searchFlights = tripSetter.setTrip(trip);

    }

    public void checkFlights(HashMap<String, String> testData) {
        searchFlights.checkFlights(testData);
    }

}
