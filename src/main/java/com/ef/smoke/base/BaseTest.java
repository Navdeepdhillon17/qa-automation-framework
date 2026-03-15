package com.ef.smoke.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    protected WebDriver driver;
    protected ConfigReader config;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        config = new ConfigReader();
        boolean headless = Boolean.parseBoolean(config.getProperty("headless"));
        String browser = config.getProperty("browser");
        if (browser.equalsIgnoreCase("chrome")) {
            if (headless) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=new");
                options.addArguments("--window-size=1920,1080");
                driver = new ChromeDriver(options);
                driver.manage().window().maximize();
                driver.get(config.getProperty("url"));
            } else {
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.get(config.getProperty("url"));
            }
        } else if (browser.equalsIgnoreCase("firefox")) {
            if (headless) {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless=new");
                options.addArguments("--window-size=1920,1080");
                driver = new FirefoxDriver(options);
                driver.manage().window().maximize();
                driver.get(config.getProperty("url"));
            } else {
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                driver.get(config.getProperty("url"));
            }
        } else if (browser.equalsIgnoreCase("edge")) {
            if (headless) {
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--headless=new");
                options.addArguments("--window-size=1920,1080");
                driver = new EdgeDriver(options);
                driver.manage().window().maximize();
                driver.get(config.getProperty("url"));
            } else {
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                driver.get(config.getProperty("url"));
            }
        } else {
            throw new RuntimeException("Unsupported browser: " + browser);
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public String captureScreenshot(String testName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotsDir = "reports/screenshots/";
        String fileName = testName + "_" + System.currentTimeMillis() + ".png";
        String path = screenshotsDir + fileName;
        try {
            // Ensure the screenshots directory exists
            File destFile = new File(path);
            File parent = destFile.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }
            FileUtils.copyFile(src, destFile);
            // Return absolute path so Extent can reliably attach the screenshot
            return destFile.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Fallback to relative path
        return "reports/screenshots/" + fileName;
    }

    // Provide driver getter for listeners
    public WebDriver getDriver() {
        return this.driver;
    }

}
