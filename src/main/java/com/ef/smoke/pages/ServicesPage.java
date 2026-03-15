package com.ef.smoke.pages;

import com.ef.smoke.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ServicesPage extends BasePage {

    WebDriver driver;
    public ServicesPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //locators
    By pageAnchor = By.tagName("h1");

    //actions
    public boolean isLoaded() {
        waitForElementVisible(pageAnchor);
        return driver.findElement(pageAnchor).isDisplayed();
    }
}
