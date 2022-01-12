package pageComponents;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class RoundTrip extends SelectComponent implements SearchFlights {

    private ExtentTest logger;
    private By radioRoundTrip = By.id("ctl00_mainContent_rbtnl_Trip_1");
    private By txtFrom = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By txtTo = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By checkbox = By.id("ctl00_mainContent_chk_IndArm");
    private By buttonSearch = By.id("ctl00_mainContent_btn_FindFlights");

    public RoundTrip(WebDriver driver, ExtentTest logger, By sectionLocator) {
        super(driver, logger, sectionLocator);
        this.logger = logger;
    }

    @Override
    public void checkFlights(HashMap<String, String> testData) {
        logger.info("Checking flights for round trip");
        try{
            findElement(radioRoundTrip).click();
            findElement(txtFrom).click();
            selectOriginCity(testData.get("origin"));
            selectDestinationCity(testData.get("destination"));
            findElement(checkbox).click();
            findElement(buttonSearch).click();
            logger.pass("Flights searched successfully");
        }
        catch (Exception e){
            logger.fail("Flights search failed");
        }

    }

    public void selectOriginCity(String origin) {
        try{
            findElement(txtFrom).click();
            findElement(By.xpath("//a[@value='" + origin + "']")).click();
            logger.pass("Origin city selected");
        }
        catch (Exception e){
            logger.fail("Origin city selection failed");
        }
    }

    public void selectDestinationCity(String destination) {
        try{
            findElement(txtTo).click();
            findElement(By.xpath("(//a[@value='" + destination + "'])[2]")).click();
            logger.pass("Destination city selected");
        }
        catch (Exception e) {
            logger.fail("Destination city selection failed");
        }
    }

}
