package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports reports;

    public static ExtentReports getReports() {
        if (reports == null) {
            String reportName = "Extent-Report_" + DateUtils.getTimeStamp() + ".html";
            reports = new ExtentReports();
            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\test-output\\results\\" + reportName);
            reports.attachReporter(extentSparkReporter);

            reports.setSystemInfo("OS", "Win 10");
            reports.setSystemInfo("Site", "RahulShettyAcademy");

            extentSparkReporter.config().setReportName("Flights Report");
            extentSparkReporter.config().setDocumentTitle("UI Automation Report");
        }
        return reports;
    }
}
