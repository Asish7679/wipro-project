package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager {

	private static ExtentReports extent;

	public static ExtentReports getExtentReports() {
		if (extent == null) {
			ExtentSparkReporter report = new ExtentSparkReporter("target/ExtentReport.html");
			report.config().setReportName("Test Report");
			report.config().setDocumentTitle("Test Results");

			extent = new ExtentReports();
			extent.attachReporter(report);

			extent.setSystemInfo("Tester", "Anurag Das");
			extent.setSystemInfo("Project", "SauceDemoAutomation");
		}
		return extent;
	}
}
