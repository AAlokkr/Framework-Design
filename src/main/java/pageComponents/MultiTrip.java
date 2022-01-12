package pageComponents;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.function.Consumer;

public class MultiTrip extends SelectComponent implements SearchFlights {

    private ExtentTest logger;
    private By radioMultiCity = By.id("ctl00_mainContent_rbtnl_Trip_2");
    private By modalPopUp = By.id("MultiCityModelAlert");
    private By txtFrom = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By txtTo = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By txtDestination = By.id("ctl00_mainContent_ddl_originStation2_CTXT");
    private By submit = By.id("ctl00_mainContent_btn_FindFlights");

    public MultiTrip(WebDriver driver, ExtentTest logger, By sectionElement) {
        super(driver, logger, sectionElement);
        this.logger = logger;
    }

    @Override
    public void checkFlights(HashMap<String, String> testData) {
        logger.info("Checking flights for multi trip");
        try{
            makePageReady(s -> selectOriginCity(testData.get("origin")));
            selectDestinationCity(testData.get("destination"));
            selectDestinationCity2(testData.get("destination"));
            findElement(submit).click();
            logger.pass("Flights searched successfully");
        }
        catch (Exception e) {
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

    public void selectDestinationCity2(String destination) {
        try{
            findElement(txtDestination).click();
            findElement(By.xpath("(//a[@value='" + destination + "'])[3]")).click();
            logger.pass("Destination-2 city selected");
        }
        catch (Exception e) {
            logger.fail("Destination-2 city selection failed");
        }

    }

    public void makePageReady(Consumer<MultiTrip> consumer) {
        logger.info("Making page ready");
        try{
            findElement(radioMultiCity).click();
            findElement(modalPopUp).click();
            waitForElementToDisappear(modalPopUp);
            logger.pass("Page is ready");
        }
        catch (Exception e){
            logger.fail("Page ready failed");
        }
        consumer.accept(this);
    }
}
