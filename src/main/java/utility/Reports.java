package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {

	public static ExtentReports createReport()
	{
		ExtentReports report = new ExtentReports();
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("SwagLabReporter.html");
		report.attachReporter(htmlReport);
		report.setSystemInfo("Application Name", "SwagLabs");
		report.setSystemInfo("Test Type", "Regration");
		report.setSystemInfo("Created By ", "Omkar Nighot");
		return report;
	}
}
