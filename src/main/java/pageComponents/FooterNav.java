package pageComponents;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterNav extends SelectComponent {

    private By flights = By.cssSelector("[title='Flights']");
    private By links = By.cssSelector("a");

    public FooterNav(WebDriver driver, ExtentTest logger, By footerElm) {
        super(driver, logger, footerElm);
    }

    public String getClassAttribute() {
        return findElement(flights).getAttribute("class");
    }

    public int getLinkCount() {
        return findElements(links).size();
    }

}
