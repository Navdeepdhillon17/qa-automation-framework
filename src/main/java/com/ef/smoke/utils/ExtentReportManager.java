package com.ef.smoke.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ExtentReportManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            // Ensure reports directory exists
            File reportsDir = new File("reports");
            if (!reportsDir.exists()) {
                reportsDir.mkdirs();
            }

            // Define report location
            ExtentSparkReporter spark = new ExtentSparkReporter("reports/SmokeTestReport.html");
            spark.config().setReportName("TestFlow Smoke Suite Results");
            spark.config().setDocumentTitle("Automation Report");
            spark.config().setTheme(Theme.DARK);

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Tester", "Nav");
            extent.setSystemInfo("Environment", "QA");
        }
        return extent;
    }
}