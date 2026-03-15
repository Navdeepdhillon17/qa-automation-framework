package com.ef.smoke.pages;

import com.ef.smoke.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PrivacyPolicyPage extends BasePage {
    WebDriver driver;
    public PrivacyPolicyPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    //locators
    By pageAnchor = By.tagName("h1");

    //action
    public boolean isLoaded() {
        return driver.findElement(pageAnchor).isDisplayed();
    }
}
