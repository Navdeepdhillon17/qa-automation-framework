package com.ef.smoke.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.ef.smoke.base.BaseTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    private static ExtentReports extent = ExtentReportManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        // Only create a new test entry if it's NOT a retry attempt
        if (result.wasRetried()) {
            // Remove the failed first attempt from the report
            extent.removeTest(test.get());
        }

        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // 1. Attempt to capture Screenshot only if driver is available
        String screenshotPath = null;
        Object instance = result.getInstance();
        if (instance instanceof BaseTest) {
            BaseTest baseTest = (BaseTest) instance;
            if (baseTest.getDriver() != null) {
                screenshotPath = baseTest.captureScreenshot(result.getName());
            }
        }

        // 2. Log Failure and attach screenshot if present
        if (screenshotPath != null) {
            test.get().fail("Test Failed: " + result.getThrowable(),
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } else {
            test.get().fail("Test Failed: " + result.getThrowable() + " (screenshot unavailable)");
        }
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        // If it wasn't already started (because it was skipped due to dependency)
        if (test.get() == null) {
            ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
            test.set(extentTest);
        }
        test.get().log(Status.SKIP, "Test Skipped: " + result.getName());
        test.get().log(Status.INFO, "Reason: " + result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("DEBUG: Test Suite Finished. Flushing Report...");
        extent.flush();
        System.out.println("DEBUG: Report should be available at: " + System.getProperty("user.dir") + "/reports/SmokeTestReport.html");
    }
}
