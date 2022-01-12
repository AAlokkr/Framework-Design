package pageComponents;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderNav extends SelectComponent {

    private ExtentTest logger;
    private By flights = By.cssSelector("[title='Flights']");
    private By links = By.cssSelector("a");

    public HeaderNav(WebDriver driver, ExtentTest logger, By HeaderElm) {
        super(driver, logger, HeaderElm);
        this.logger = logger;
    }

    public String getClassAttribute() {
        return findElement(flights).getAttribute("class");
    }

    public int getLinkCount() {
        return findElements(links).size();
    }

    public void clickFlights() {
        try{
            findElement(flights).click();
            logger.pass("Clicked on flights");
        }
        catch (Exception e){
            logger.fail("Clicking on flights failed");
        }
    }

}
