package testPackage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dataLoader.DataReader;
import pageObjects.TravelHomePage;

/* implement TestNG listeners for onFail etc and extent reporting *
 * */
public class SampleTest extends BaseTest {

	WebDriver driver;
	TravelHomePage travelHomePage;

	@BeforeTest
	public void invokeBrowser() throws IOException {
		driver = getDriver();
	}

	@Test(dataProvider="getData")
	public void testCase(HashMap<String, String> testData) {
		travelHomePage = new TravelHomePage(driver);
		travelHomePage.goTo(url);
		travelHomePage.getHeaderNav().clickFlights();
		travelHomePage.setTrip(testData.get("trip"));
		travelHomePage.checkFlights(testData);

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
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
