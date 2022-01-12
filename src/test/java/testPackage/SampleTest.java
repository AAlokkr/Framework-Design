package testPackage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import dataLoader.DataReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.TravelHomePage;
import utils.ExtentReportManager;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

/* implement TestNG listeners for onFail etc and extent reporting *
 * */
public class SampleTest extends BaseTest {

    private WebDriver driver;
    private TravelHomePage travelHomePage;
    private ExtentTest logger;
    private ExtentReports extentReports;

    @BeforeTest
    public void invokeBrowser() throws IOException {
        extentReports = ExtentReportManager.getReports();
        driver = getDriver();
    }

    @Test(dataProvider = "getData")
    public void testCase(HashMap<String, String> testData, Method method) {
        logger = extentReports.createTest(method.getName());
        travelHomePage = new TravelHomePage(driver, logger);
        travelHomePage.goTo(url);
        travelHomePage.getHeaderNav().clickFlights();
        travelHomePage.setTrip(testData.get("trip"));
        travelHomePage.checkFlights(testData);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
        extentReports.flush();
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> dataList;
        DataReader dataReader = new DataReader();
        dataList = dataReader.getData(testDataLoc);
        Object[][] dataSet = new Object[dataList.size()][1];

        for (int i = 0; i < dataList.size(); i++) {
            dataSet[i][0] = dataList.get(i);
        }

        return dataSet;
    }

}
