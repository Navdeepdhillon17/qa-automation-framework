package com.ef.smoke.components;

import com.ef.smoke.base.BasePage;
import com.ef.smoke.pages.AboutPage;
import com.ef.smoke.pages.PrivacyPolicyPage;
import com.ef.smoke.pages.TermsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterComponent extends BasePage {
    WebDriver driver;

    public FooterComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //locators
//    footer root (container)
    By footerContainer = By.tagName("footer");
//    privacy link
    By privacyLink = By.cssSelector("a[href*=privacy]");
//    terms link
    By termsLink = By.cssSelector("a[href*=terms]");
//    about link
    By aboutLink = By.cssSelector("a[href*=about]");


    //actions
//    Go to Privacy Policy
     public PrivacyPolicyPage goToPrivacyPolicy() {
         waitForElementClickable(privacyLink);
         driver.findElement(privacyLink).click();
         return new PrivacyPolicyPage(driver);
     }
//    Go to Terms of Service
    public TermsPage goToTermsPage() {
        waitForElementClickable(termsLink);
         driver.findElement(termsLink).click();
          return new TermsPage(driver);
    }
//    Go to About Us
    public AboutPage goToAboutPage() {
            waitForElementClickable(aboutLink);
            driver.findElement(aboutLink).click();
           return new AboutPage(driver);
    }
    
}
