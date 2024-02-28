package mylistener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNg {
    public static ExtentReports extent;
    public static ExtentReports getReporterObject(){
        String path = System.getProperty("user.dir")+"//test-output//index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Sanjay");
        reporter.config().setDocumentTitle("caw-studios-assignment");
        reporter.getAnalysisStrategy();
        reporter.getTestList();
        reporter.getStatusCollection();
        reporter.getReportStatusStats();
        reporter.config().setTimeStampFormat("dd/MM/yyyy HH:mm:ss");
        reporter.config().setTheme(Theme.STANDARD);
        reporter.getRunDuration();
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("tester", "Sanjay Kumar A");
        return  extent;
    }
}
